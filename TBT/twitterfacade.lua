-- twitterFacade.lua
-- v1.3
-- Release: 03 December 2013
-- @author silverthorax.com

local sqlite3		= require("sqlite3")
local http			= require("socket.http")
local ltn12			= require("ltn12")
local crypto		= require("crypto")
local mime			= require("mime")

local M = {}

M._ = {}

function M.init( consumerKey, consumerSecret, callbackURL, multipleAccounts )
	if multipleAccounts then
		M._.single_account = false
	end
	M._.consumer_key = consumerKey
	M._.consumer_secret = consumerSecret
	M._.callback_url = callbackURL
	M._.createTablesIfNotExist()
	M._.initialized = true
end

function M.getLastResponse()
	return M._.last_response
end

function M.getLastError()
	return M._.last_error
end

function M.tweet( ... )
	if arg.n == 2 then
		if type(arg[1]) == "string" and type(arg[2]) == "string" then
			local path = arg[2]
			local fullpath = nil
			if M._.fileExists( path ) then fullpath = path
			elseif M._.fileExists( system.pathForFile( path, system.ResourceDirectory ) ) then fullpath = system.pathForFile( path, system.ResourceDirectory )
			elseif M._.fileExists( system.pathForFile( path, system.DocumentsDirectory ) ) then fullpath = system.pathForFile( path, system.DocumentsDirectory )
			elseif M._.fileExists( system.pathForFile( path, system.TemporaryDirectory ) ) then fullpath = system.pathForFile( path, system.TemporaryDirectory )
			else
				print("ERROR: cannot find the file "..arg[2])
				return
			end
			args = {
				message = arg[1],
				imageFullPath = fullpath,
			}
		else
			--print("ERROR: wrong arguments provided to function 'tweet()', expected two strings, got "..type(arg[1]).." and "..type(arg[2]))
			return
		end
	elseif arg.n == 1 then
		if type(arg[1]) == "table" then
			args = arg[1]
		elseif type(arg[1]) == "string" then
			args = {
				message = arg[1],
			}
		else
			--print("ERROR: wrong argument provided to function 'tweet()', expected table or string, got "..type(arg[1]))
			return
		end
	else
		print("ERROR: wrong number of arguments provided to function 'tweet()'")
		return
	end
	if args.message == nil or string.len(args.message) == 0 then
		print("ERROR: you must provide a 'message' argument to function 'tweet()'")
		return
	end
	M._.callbackLoop( function ( onResponse )
			if args.imageFullPath then
				M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/update_with_media.json", { { key = 'status', value = args.message } }, "POST", args.imageFullPath )
			else
				M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/update.json", { { key = 'status', value = args.message } }, "POST" )
			end
		end, function () M.tweet( args ) end, args )
end

function M.retweet( args )
	if args.id == nil or string.len(tostring(args.id)) == 0 then
		print("ERROR: you must provide an 'id' argument to function 'retweet()'")
		return
	end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/retweet/"..args.id..".json", { }, "POST" )
		end, function () M.retweet( args ) end, args )
end

function M.searchTweets( args )
	if args.q == nil or string.len(args.q) == 0 then
		print("ERROR: you must provide a 'q' argument to function 'searchTweets()'")
		return
	end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/search/tweets.json", { { key = 'q', value = args.q } }, "GET" )
		end, function () M.searchTweets( args ) end, args )
end

function M.getMentionsTimeline( args )
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/mentions_timeline.json", { }, "GET" )
		end, function () M.getMentionsTimeline( args ) end, args )
end

function M.getUserTimeline( args )
	local argkey, argvalue, continue = M._.checkUserIdOrScreenNameKey( args )
	if not continue then return end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/user_timeline.json", { { key = argkey, value = argvalue } }, "GET" )
		end, function () M.getUserTimeline( args ) end, args )
end

function M.getOwnTimeline( options )
	if options == nil then
		options = {
			inAppUserId = 'defaultUser'
		}
	elseif M._.single_account or options.inAppUserId == nil then
		options.inAppUserId = 'defaultUser'
	end
	M._.loadAccessTokenAndUserId( options.inAppUserId )
	options.user_id = M._.twitter_user_id
	options.screen_name = nil
	M.getUserTimeline( options )
end

function M.getHomeTimeline( args )
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/home_timeline.json", { }, "GET" )
		end, function () M.getHomeTimeline( args ) end, args )
end


function M.getRetweetsOfMe( args )
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/statuses/retweets_of_me.json", { }, "GET" )
		end, function () M.getRetweetsOfMe( args ) end, args )
end

function M.getFollowersOf( args )
	local argkey, argvalue, continue = M._.checkUserIdOrScreenNameKey( args )
	if not continue then return end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/followers/ids.json", { { key = argkey, value = argvalue } }, "GET" )
		end, function () M.getFollowersOf( args ) end, args )
end

function M.getOwnFollowers( options )
	if options == nil then
		options = {
			inAppUserId = 'defaultUser'
		}
	elseif M._.single_account or options.inAppUserId == nil then
		options.inAppUserId = 'defaultUser'
	end
	M._.loadAccessTokenAndUserId( options.inAppUserId )
	options.user_id = M._.twitter_user_id
	options.screen_name = nil
	M.getFollowersOf( options )
end

function M.follow( args )
	local argkey, argvalue, continue = M._.checkUserIdOrScreenNameKey( args )
	if not continue then return end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/friendships/create.json", { { key = argkey, value = argvalue } }, "POST" )
		end, function () M.follow( args ) end, args )
end

function M.getFriendsOf( args )
	local argkey, argvalue, continue = M._.checkUserIdOrScreenNameKey( args )
	if not continue then return end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/friends/ids.json", { { key = argkey, value = argvalue } }, "GET" )
		end, function () M.getFriendsOf( args ) end, args )
end


function M.getOwnFriends( options )
	if options == nil then
		options = {
			inAppUserId = 'defaultUser'
		}
	elseif M._.single_account or options.inAppUserId == nil then
		options.inAppUserId = 'defaultUser'
	end
	M._.loadAccessTokenAndUserId( options.inAppUserId )
	options.user_id = M._.twitter_user_id
	options.screen_name = nil
	M.getFriendsOf( options )
end

function M.getAccount( options )
	if options == nil then
		options = {
			inAppUserId = 'defaultUser'
		}
	elseif M._.single_account or options.inAppUserId == nil then
		options.inAppUserId = 'defaultUser'
	end
	M._.loadAccessTokenAndUserId( options.inAppUserId )
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/account/verify_credentials.json", { }, "GET" )
		end, function () M.getAccount( options ) end, options )
end

function M.getFavoritesOf( options )
	if options == nil then
		options = {
			inAppUserId = 'defaultUser'
		}
		M._.loadAccessTokenAndUserId( options.inAppUserId )
		options.user_id = M._.twitter_user_id
		options.screen_name = nil
	end
	if options.user_id == nil and options.screen_name == nil then
		if M._.single_account or options.inAppUserId == nil then
			options.inAppUserId = 'defaultUser'
		end
		M._.loadAccessTokenAndUserId( options.inAppUserId )
		options.user_id = M._.twitter_user_id
		options.screen_name = nil
	end
	local argkey, argvalue, continue = M._.checkUserIdOrScreenNameKey( options )
	if not continue then return end
	M._.callbackLoop( function ( onResponse )
			M._.makeOAuthRequest( onResponse, "https://api.twitter.com/1.1/favorites/list.json", { { key = argkey, value = argvalue } }, "GET" )
		end, function () M.getFavoritesOf( options ) end, options )
end

function M.returnAllStoredAccounts()
	local accounts = {}
	for r in M._.db:nrows("SELECT * FROM auth;") do
		table.insert( accounts, {
			inapp_id = r.inapp_userid,
			twitter_user_id = r.tw_user_id,
			twitter_screen_name = r.tw_screen_name
		} )
	end
	return accounts
end


M.callbackDelay = 20





function M._.hasUserIdKey( args )
	return not ( args.user_id == nil or string.len(args.user_id) == 0 )
end
function M._.hasScreenNameKey( args )
	return not ( args.screen_name == nil or string.len(args.screen_name) == 0 )
end
function M._.checkUserIdOrScreenNameKey( args )
	if M._.hasUserIdKey( args ) then
		return "user_id", args.user_id, true
	elseif M._.hasScreenNameKey( args ) then
		return "screen_name", args.screen_name, true
	else
		print("ERROR: you must provide either a 'user_id' or a 'screen_name' argument to this function")
		return nil, nil, false
	end
end

function M._.callbackLoop( onAlreadyAuthorized, onAuthCallback, options )
	
	if options == nil then
		options = {}
	end
	local onSuccess = options.onSuccess
	local onFail = options.onFail
	local onUserCancel = options.onUserCancel
	local onBusy = options.onBusy
	local inAppUserId = options.inAppUserId
	local imageFullPath = options.imageFullPath
	
	
	if not M._.initialized then
		M._.last_error = "ERROR: twitterFacade has not been initialized. Please call init(). [source: twitterFacade]"
		print( M._.last_error )
		if onFail then
			timer.performWithDelay( M.callbackDelay, onFail )
		end
		return
	end
	
	if M._.busy and not M._.performing_client_callback then
		M._.last_error = "ERROR: a request has been sent already, please wait until it ends. [source: twitterFacade]"
		print( M._.last_error )
		if onBusy then
			timer.performWithDelay( M.callbackDelay, onBusy )
		end
		return
	end
	
	
	if M._.single_account or inAppUserId == nil then
		inAppUserId = 'defaultUser'
	end
	
	if M._.isAuthorized( inAppUserId ) then
		
		
		M._.loadAccessTokenAndUserId( inAppUserId )
		
		onAlreadyAuthorized(
			function()


				if M._.last_response then
					if string.find( M._.last_response, '"error":' )
					or string.find( M._.last_response, '"errors":' )
					or string.find( M._.last_response, 'ERROR' )
					then
						M._.last_error = M._.last_response .. " [source: Twitter API]"
						print( M._.last_error )
						if onFail then
							timer.performWithDelay( M.callbackDelay, onFail )
						end
					else
						if onSuccess then
							timer.performWithDelay( M.callbackDelay, onSuccess )
						end
					end
				else
					M._.last_error = "No response [source: twitterFacade]"
					print( M._.last_error )
					if onFail then
						timer.performWithDelay( M.callbackDelay, onFail )
					end
				end
			end
		)
		
		return
		
	else
		
		
		M._.getNewOAuthRequestToken(
			
			M._.callback_url,
			
			function()
				
				M._.busy = true

				M._.temp_request_in_app_user_id = inAppUserId
				M._.temp_request_client_callback = function (e)
					M._.performing_client_callback = true
					onAuthCallback()
					M._.performing_client_callback = false
					M._.busy = false
				end
				M._.temp_request_on_cancel = function (e)
					M._.busy = false
					onUserCancel()
				end
				M._.temp_request_on_error = function (e)
					M._.busy = false
					onFail()
				end
				
				native.showWebPopup( 0, 0, display.viewableContentWidth, display.viewableContentHeight, "https://api.twitter.com/oauth/authorize?oauth_token=" .. M._.temp_request_token, { urlRequest = M._.authorizationCallbackListener } )
			end,
			
			onFail
			
		)		
		
	end
	
end


function M._.authorizationCallbackListener( event )
	local url = event.url
	if string.find( url, "oauth_token" ) and string.find( url, M._.callback_url ) then
		url = string.sub( url, string.find( url, "?" ) + 1, string.len( url ) ) 
		
		local authorize_response = M._.responseToTable( url, { "=", "&" } )
		
		M._.getOAuthAccessToken(
			function ()
				if M._.temp_oauth_access_token then			
					local access_response = M._.responseToTable(
						M._.temp_oauth_access_token,
						{"=", "&"}
					)
					M._.setAccessToken( M._.temp_request_in_app_user_id, access_response.oauth_token, access_response.oauth_token_secret, access_response.user_id, access_response.screen_name )
					timer.performWithDelay( M.callbackDelay, M._.temp_request_client_callback )
				else
					M._.last_error = "ERROR: no oAuth access token found [source: twitterFacade]"
					print( M._.last_error )
					timer.performWithDelay( M.callbackDelay, M._.temp_request_on_error )
				end
			end,
			authorize_response.oauth_verifier
		)
		
		return false
		
	elseif url:find( M._.callback_url ) then
		timer.performWithDelay( M.callbackDelay, M._.temp_request_on_cancel )
		return false
	elseif not url:find( "twitter" ) then
		timer.performWithDelay( M.callbackDelay, M._.temp_request_on_cancel )
		return false
	end
	
	return true
	
end


function M._.createTablesIfNotExist()
	M._.db:exec("CREATE TABLE IF NOT EXISTS auth (inapp_userid TEXT, access_token TEXT, access_token_secret TEXT, tw_user_id TEXT, tw_screen_name TEXT);")
end

function M._.isAuthorized( inAppUserId )
	for r in M._.db:nrows("SELECT * FROM auth WHERE inapp_userid = '" .. inAppUserId .. "';") do
		return true
	end
	return false
end

function M._.loadAccessTokenAndUserId( inAppUserId )
	for r in M._.db:nrows("SELECT * FROM auth WHERE inapp_userid = '" .. inAppUserId .. "';") do
		M._.access_token = r.access_token
		M._.access_token_secret = r.access_token_secret
		M._.twitter_user_id = r.tw_user_id
		M._.twitter_screen_name = r.tw_screen_name
	end
end

function M._.setAccessToken( inAppUserId, accessToken, accessTokenSecret, twitterUserId, twitterScreenName )
	M._.db:exec("INSERT INTO auth VALUES( '" .. inAppUserId .. "', '" .. accessToken .. "', '" .. accessTokenSecret .. "', '" .. twitterUserId .. "', '" .. twitterScreenName .. "' )")
end


function M._.getFilename( fullPath )
	local regex = "[/]?([^/]+)$"
	local match = string.match( fullPath, regex )
	if not match then
		return nil
	else
		return match
	end
end

function M._.fileExists( fullPath )
	print (fullPath)
	local fh = io.open( fullPath, "r" )
	if fh ~= nil then
		io.close( fh )
		return true
	else
		return false
	end
end


function M._.getNewOAuthRequestToken( callbackURL, onSuccess, onError )
	
	local requestTokenURL = "https://api.twitter.com/oauth/request_token"
	
	M._.temp_request_token = nil
	M._.temp_request_token_secret = nil
	
	local oauth_params = {
		oauth_consumer_key		= M._.consumer_key,
		oauth_nonce				= M._.get_nonce(),
		oauth_signature_method	= "HMAC-SHA1",
		oauth_timestamp			= M._.get_timestamp(),
		oauth_version			= '1.0',
		oauth_callback			= callbackURL,
	}
	
	local post_data = M._.oAuthSign( requestTokenURL, "POST", oauth_params, M._.consumer_secret )
	
	M._.rawRequestEnhanced(
		function( event )
			if event.isError then
				M._.temp_request_token = ""
				M._.temp_request_token_secret = ""
				M._.last_error = event.response .. " [source: network.request]"
				if onError then
					timer.performWithDelay( M.callbackDelay, onError )
				end
				return
			else
				if event.status == 200 then
					local result = event.response
					M._.temp_request_token = result:match( 'oauth_token=([^&]+)' )
					M._.temp_request_token_secret = result:match( 'oauth_token_secret=([^&]+)' )
					if onSuccess then
						timer.performWithDelay( M.callbackDelay, onSuccess )
					end
					return
				else
					M._.temp_request_token = ""
					M._.temp_request_token_secret = ""
					M._.last_error = event.response .. " [source: Twitter API]"
					if onError then
						timer.performWithDelay( M.callbackDelay, onError )
					end
					return
				end
			end
		end,
		requestTokenURL,
		post_data,
		true
	)

end

function M._.getOAuthAccessToken( callback, verifier )
	
	local accessTokenURL = "https://api.twitter.com/oauth/access_token"
	
	local oauth_params = {
		oauth_consumer_key		= M._.consumer_key,
		oauth_nonce				= M._.get_nonce(),
		oauth_signature_method	= "HMAC-SHA1",
		oauth_timestamp			= M._.get_timestamp(),
		oauth_version			= '1.0',
		oauth_token				= M._.temp_request_token,
		oauth_token_secret		= M._.temp_request_token_secret,
		oauth_verifier			= verifier,
	}
	
	local post_data = M._.oAuthSign( accessTokenURL, "POST", oauth_params, M._.consumer_secret )
	
	M._.rawRequestEnhanced(
		function( event )
			if event.isError then
			else
				if event.status == 200 then
					M._.temp_oauth_access_token = event.response
					callback()
				else
				end
			end
		end,
		accessTokenURL,
		post_data,
		true
	)
	
end

function M._.makeOAuthRequest( callback, url, body, method, imageFullPath )
	
	
	local oauth_params = {
		oauth_consumer_key		= M._.consumer_key,
		oauth_nonce				= M._.get_nonce(),
		oauth_signature_method	= "HMAC-SHA1",
		oauth_token				= M._.access_token,
		oauth_timestamp			= M._.get_timestamp(),
		oauth_version			= '1.0',
		oauth_token_secret		= M._.access_token_secret,
	}
	
	local isMultipart = ( imageFullPath ~= nil )
	
	local multipart = nil
	
	if isMultipart then
		multipart = M._.createMultipartObject()
		multipart.addFile( "media[]", imageFullPath, "application/octet-stream", "./" .. M._.getFilename( imageFullPath ) )
		for i = 1, #body do
			multipart.addField( body[i].key, body[i].value )
		end
	else
		for i = 1, #body do
			oauth_params[body[i].key] = body[i].value
		end
	end
	
	local post_data = M._.oAuthSign( url, method, oauth_params, M._.consumer_secret, isMultipart )
	
	if isMultipart then
		multipart.addHeader( "Authorization", post_data )
	end
	
	M._.rawRequestEnhanced(
		function( event )
			if event.isError then
			else
				if event.status == 200 then
					M._.last_response = event.response
					callback()
					return
				else
					M._.last_response = "HTTP " .. event.status .. " - Response: " .. event.response
					callback()
					return
				end
			end
		end,
		url,
		post_data,
		(method == "POST"),
		multipart
	)
	
end


function M._.createMultipartObject()
	local newBoundary = "MPFD-"..crypto.digest( crypto.sha1, "MultipartFormData"..tostring(object)..tostring(os.time())..tostring(os.clock()), false )
	local object = { 
		isClass = true,
		boundary = newBoundary,
		headers = {},
		elements = {},
	}
	object.headers["Content-Type"] = ""
	object.headers["Content-Length"] = ""
	object.headers["Accept"] = "*/*"
	object.headers["Accept-Encoding"] = "gzip"
	object.headers["Accept-Language"] = "en-us"
	object.headers["connection"] = "keep-alive"
	
	object.getBody = function()
		local src = {}
		for i = 1, #object.elements do
			local el = object.elements[i]
			if el then
				if el.intent == "field" then
					local elData = {
						"--"..object.boundary.."\r\n",
						"Content-Disposition: form-data; name=\"",
						el.name,
						"\"\r\n\r\n",
						el.value,
						--"\r\n"
					}
					local elBody = table.concat(elData)
					table.insert(src, ltn12.source.chain(ltn12.source.string(elBody), mime.normalize()))
				elseif el.intent == "file" then
					local elData = {
						"--"..object.boundary.."\r\n",
						"Content-Disposition: form-data; name=\"",
						el.name,
						"\"; filename=\"",
						el.filename,
						"\"\r\n",
						"Content-Type: ",
						el.mimetype,
						"\r\n",
						"Content-Transfer-Encoding: "..el.encoding.."",
						"\r\n\r\n",
					}
					local elHeader = table.concat(elData)

					local elFile = io.open( el.path, "rb" )
					assert(elFile)
					local fileSource = ltn12.source.cat(
						ltn12.source.chain(ltn12.source.string(elHeader), mime.normalize()),
						ltn12.source.chain(
							ltn12.source.file(elFile), 
							ltn12.filter.chain(
								mime.encode(el.encoding),
								mime.wrap()
							)
						)
					)
					table.insert(src, fileSource)
				end
			end
		end
		
		table.insert(src, ltn12.source.chain(ltn12.source.string("\r\n--"..object.boundary.."--"), mime.normalize()))
		
		local source = ltn12.source.empty()
		for i = 1, #src do
				source = ltn12.source.cat(source, src[i])
		end
		
		local sink, data = ltn12.sink.table()
		ltn12.pump.all(source,sink)     
		local body = table.concat(data)
		
		object.headers["Content-Type"] = "multipart/form-data; boundary="..object.boundary
		
		object.headers["Content-Length"] = string.len(body)
		
		return body
	end
	
	object.getHeaders = function()
		assert(object.headers["Content-Type"])
		assert(object.headers["Content-Length"])
		return object.headers
	end
	
	object.addHeader = function( key, val )
		object.headers[key] = val
	end
	
	object.addField = function( key, val )
		table.insert( object.elements, { intent = "field", name = key, value = val } )
	end
	
	object.addFile = function( fileName, filePath, mimeType, remoteFileName )
        table.insert( object.elements, { intent = "file", name = fileName, path = filePath, mimetype = mimeType, filename = remoteFileName, encoding = "base64" } )
	end
	
	object.setBoundary = function( val )
		object.boundary = val
	end
	
	return object
end

function M._.rawRequestEnhanced( callback, url, data, isPost, multipartObject )
	local r, c, h
	
	local isMultipart = ( multipartObject ~= nil )
	
	if isPost then
		if isMultipart then
			r, c, h = network.request(
				url,
				"POST",
				callback,
				{
					headers	= multipartObject:getHeaders(),
					body = multipartObject:getBody(),
				}
			)
			
			
		else
			r, c, h = network.request(
				url,
				"POST",
				callback,
				{
					headers	= {
						["Content-Type"]	= "application/x-www-form-urlencoded",
						["Content-Length"]	= string.len( data ),
					},
					body = data,
				}
			)
			
			
		end
	else
		r, c, h = network.request(
			data,
			"GET",
			callback
		)
		
		
	end
end

function M._.rawRequest( url, data, isPost, multipartObject )
	local r, c, h
	local response = {}
	
	local isMultipart = ( multipartObject ~= nil )
	
	if isPost then
		if isMultipart then
			r, c, h = http.request {
				url		= url,
				method	= "POST",
				headers	= multipartObject:getHeaders(),
				source	= ltn12.source.string( multipartObject:getBody() ),
				sink	= ltn12.sink.table( response ),
			}			
			return c
		else
			r, c, h = http.request {
				url		= url,
				method	= "POST",
				headers	= {
					["Content-Type"]	= "application/x-www-form-urlencoded",
					["Content-Length"]	= string.len( data ),
				},
				source	= ltn12.source.string( data ),
				sink	= ltn12.sink.table( response ),
			}
			return table.concat( response, "" ), c
		end
	else
		r, c, h = http.request {
			url		= data,
			sink	= ltn12.sink.table( response ),
		}
		return table.concat( response, "" )
	end
end

function M._.get_nonce()
	return mime.b64( crypto.hmac( crypto.sha1, tostring( math.random() ) .. "random" .. tostring( os.time() ), "keyyyy" ) )
end

function M._.get_timestamp()
	return tostring( os.time() + 1 )
end


function M._.encode_parameter( str )
	return str:gsub(
		'[^-%._~a-zA-Z0-9]',
		function( c )
			return string.format( "%%%02x", c:byte() ):upper()
		end
	)
end

function M._.sha1( str, key, binary )
	binary = binary or false
	return crypto.hmac( crypto.sha1, str, key, binary )
end

function M._.oAuthSign( url, method, args, consumer_secret, multipart )
	
	local token_secret = args.oauth_token_secret or ""
	args.oauth_token_secret = nil
	
	local keys_and_values = {}
	for key, val in pairs( args ) do
		table.insert(
			keys_and_values,
			{
				key = M._.encode_parameter(key),
				val = M._.encode_parameter(val)
			}
		)
	end
	
	table.sort(
		keys_and_values,
		function(a,b)
			if a.key < b.key then
				return true
			elseif a.key > b.key then
				return false
			else
				return a.val < b.val
			end
		end
	)
	
	local key_value_pairs = {}
	for _, rec in pairs(keys_and_values) do
		table.insert(key_value_pairs, rec.key .. "=" .. rec.val)
	end
	
	local query_string_except_signature = table.concat(key_value_pairs, "&")
	
	local sign_base_string
	sign_base_string = method .. '&' .. M._.encode_parameter(url) .. '&' .. M._.encode_parameter(query_string_except_signature)

	local key = M._.encode_parameter(consumer_secret) .. '&' .. M._.encode_parameter(token_secret)
	local hmac_binary = M._.sha1(sign_base_string, key, true)

	local hmac_b64 = mime.b64(hmac_binary)
	local query_string = query_string_except_signature .. '&oauth_signature=' .. M._.encode_parameter(hmac_b64)

	if multipart then
		key_value_pairs = {}
		for _, rec in pairs( keys_and_values ) do
			table.insert( key_value_pairs, rec.key .. "=\"" .. rec.val .. "\"" )
		end
		query_string_except_signature = table.concat(key_value_pairs, ", ")
		local auth = "OAuth " .. query_string_except_signature .. ', oauth_signature=\"' .. M._.encode_parameter(hmac_b64) .."\""
		return auth
	end
	
	if method == "GET" then
		return url .. "?" .. query_string
	else
		return query_string
	end
	
end

function M._.responseToTable( str, delimeters )
	local obj = {}

	while str:find(delimeters[1]) ~= nil do
		if #delimeters > 1 then
			local key_index = 1
			local val_index = str:find(delimeters[1])
			local key = str:sub(key_index, val_index - 1)
	
			str = str:sub((val_index + delimeters[1]:len()))
	
			local end_index
			local value
	
			if str:find(delimeters[2]) == nil then
				end_index = str:len()
				value = str
			else
				end_index = str:find(delimeters[2])
				value = str:sub(1, (end_index - 1))
				str = str:sub((end_index + delimeters[2]:len()), str:len())
			end
			obj[key] = value
		else	
			local val_index = str:find(delimeters[1])
			str = str:sub((val_index + delimeters[1]:len()))
	
			local end_index
			local value
	
			if str:find(delimeters[1]) == nil then
				end_index = str:len()
				value = str
			else
				end_index = str:find(delimeters[1])
				value = str:sub(1, (end_index - 1))
				str = str:sub(end_index, str:len())
			end
			
			obj[#obj + 1] = value
		end
	end
	
	return obj
end

M._.initialized = false

M._.db = sqlite3.open(system.pathForFile("twitterFacade.sqlite", system.DocumentsDirectory))

Runtime:addEventListener( "system", function ( event )
	if ( event.type == "applicationExit" ) then
		if M._.db ~= nil then
			M._.db:close()
		end
	end
end )


M._.consumer_key = nil
M._.consumer_secret = nil
M._.callback_url = nil

M._.access_token = nil
M._.access_token_secret = nil

M._.busy = false
M._.performing_client_callback = false
M._.temp_request_token = nil
M._.temp_request_token_secret = nil
M._.temp_oauth_access_token = nil
M._.temp_request_in_app_user_id = nil
M._.temp_request_client_callback = nil
M._.temp_request_on_cancel = nil
M._.temp_request_on_error = nil

M._.last_error = nil
M._.last_response = nil

M._.twitter_user_id = nil
M._.twitter_screen_name = nil

M._.single_account = true


return M
