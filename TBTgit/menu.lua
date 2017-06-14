-----------------------------------------------------------------------------------------



-- show default status bar (iOS)
display.setStatusBar( display.DefaultStatusBar )
display.setDefault( "background", 1, 1, 1 )

-- include Corona's "widget" library
local widget = require "widget"
local composer = require "composer"
local facebook = require("plugin.facebook.v4")
local scene = composer.newScene()
local title, throwButton, reminderButton, servicesButton
local json = require ("json")


-- saved file requirements
local fbPublish = require("myFBPublish")
fbPublish = 0

local tbt_twitter = require("tbt_twitter")

local tbt_reminder = require("tbt_reminder")

local tbt_facebook = require("tbt_facebook")

local facebookText = ""

local tbt_doubletap = require("tbt_doubletap")

--initialize buttons
local postButton,printsButton,pickButton,fbButton,postButtonPrint
--local tbtFile = "TBTfaded.png"
local photoGroup = display.newGroup( )
local photo
local PHOTO_FUNCTION = media.PhotoLibrary 		-- or media.SavedPhotosAlbum

--initialize application screen "map"
local centerX = display.contentCenterX
local centerY = display.contentCenterY
local _W = display.contentWidth
local _H = display.contentHeight

--facebook api initializations
local appId = "removed"

local fb_random_id = {}

local messageText = ""


--text field aad text boxes
local defaultField
defaultField = native.newTextField( centerX, 322, 220, 30 )
--defaultField.inputType="number"
defaultField.isVisible=false


local doubleTap = display.newText( "", 0, 0, native.systemFont, 12 )
local confirm = display.newText( "", 0, 0, native.systemFont, 14 )
local fbOrElse = false


--twitter initializations

local tw = require( "twitterfacade" )
local consumer_key = "removed" -- key string goes here
local consumer_secret = "removed" -- secret string goes here
local webURL = "http://www.tbtapp.com"
tw.init(consumer_key,consumer_secret,webURL)

local callback = {}
local twitterText = tbt_twitter.load()



local doubleTapText  = tbt_doubletap.load()

local pickPhoto
local gotPrints
local fBookGet

local text = display.newText( "#tbtapp", centerX+50, centerY+50, "Helvetica", 18 )
	   text:setTextColor( 0.2, 0.2, 0.2, 205 )
	   text.isVisible = false


-- ads initializations

local ads = require( "ads" )
local bannerAppID = "removed"  --for your iOS banner
local interstitialAppID = "removed"  --for your iOS interstitial
if ( system.getInfo( "platformName" ) == "Android" ) then
    bannerAppID = "removed"  --for your Android banner
    interstitialAppID = "removed"  --for your Android interstitial
end

local adProvider = "admob"



 function adListener( event )
    --(more on this later)
    --print ("in adListener")
    	if event.isError then
    		confirm.text = "Error loading ad"
    		transition.fadeOut( confirm, {time = 2000} )
	else

	end
end

-- Check for an item inside the provided table
-- Based on implementation at: https://www.omnimaga.org/other-computer-languages-help/(lua)-check-if-array-contains-given-value/
local function inTable( table, item )
	for k,v in pairs( table ) do
		if v == item then
			return true
		end
	end
	return false
end

-- This function is useful for debugging problems with using FB Connect's web api,
-- e.g. you passed bad parameters to the web api and get a response table back
local function printTable( t, label, level )
	if label then print( label ) end
	level = level or 1

	if t then
		for k,v in pairs( t ) do
			local prefix = ""
			for i=1,level do
				prefix = prefix .. "\t"
			end

			print( prefix .. "[" .. tostring(k) .. "] = " .. tostring(v) )
			if type( v ) == "table" then
				print( prefix .. "{" )
				printTable( v, nil, level + 1 )
				print( prefix .. "}" )
			end
		end
	end
end

function fbDoubleTapListener(event)
	if(event.numTaps == 2) then
			
			--tbtImg.isVisible=false
			--photoGroup.isVisible = false
		--text.isVisible=false
		   if(photo) then 
		   	photo.isVisible=false
		   	display.remove(photo)
		   end
		   doubleTap.text = ""
		    --display.remove(tbtImg)
		    --display.remove(photoGroup)
		    fBookGet()
			--facebook.request( "me/photos","GET", {limit="500"})
		--	photo.isVisible=true
		--tbtImg.isVisible=true
		--photoGroup.isVisible=true
	end
end


function galleryDoubleTapListener(event)
		--photo.isVisible=false
		--tbtImg.isVisible=false
		--photoGroup.isVisible = false
		--print("single tap")
	if(event.numTaps == 2) then
		print("double tap")
		photo.isVisible = false
		--tbtImg.isVisible = false
		--photoGroup.isVisible = false
		display.remove( photo )
		--display.remove( tbtImg)
		--display.remove( photoGroup)
		pickPhoto()
		--photo.isVisible=true
		--tbtImg.isVisible=true
		--photoGroup.isVisible=true
	end
end

function printsDoubleTapListener(event)
	if(event.numTaps == 2) then
		photo.isVisible = false
		----tbtImg.isVisible = false
		--photoGroup.isVisible = false
		text.isVisible = false
		display.remove( photo )
		--display.remove( tbtImg)
		--display.remove( photoGroup)
		gotPrints()
	end
end

function showImage( event )
   	print ("showImage")

   	--tbtImg = display.newImage( "TBTfaded.png" )

   	photo = event.target
	        	--print ("photo name: "..event.ta.name)
   	--event.target.alpha = 0
	        	--event.target.xScale = 0.15
	       	 	--event.target.yScale = 0.15
   	local scaleFactor = 1
	if event.target.width > event.target.height then
		scaleFactor =  250 / event.target.width
		--tbtImg.x = centerX+50
		--tbtImg.y = centerY+10
		print ("width greater  "..event.target.height..scaleFactor) 

	else
		scaleFactor = 200 / event.target.height
		--tbtImg.x = centerX+50
		--tbtImg.y = centerY+20
		print ("height greater  "..event.target.height..scaleFactor) 
	end

		--event.target:scale( scaleFactor, scaleFactor )
				
		--display.save( event.target, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})

   	--transition.to( event.target, { alpha = 1.0 , xScale = scaleFactor, yScale = scaleFactor} )
   --	photo = event.target
   	--photoGroup:photo)
   	--photoGroup:insert(tbtImg)
   	--photoGroup:toFront( )

   	print("pre transition")
	
	transition.to( event.target, { alpha = 1.0 , xScale = scaleFactor, yScale = scaleFactor} )

	print("post transition")
	--photoGroup:insert(event.target)
	--photoGroup:insert(tbtImg)
	--photoGroup.isVisible=true
	photo = event.target
   	photo:addEventListener("tap",fbDoubleTapListener)

   	print("list add event")

   	--photoGroup:addEventListener("tap",fbDoubleTapListener)
end

function facebookListener( event )

	print( "in facebookListener")
	--print("facebookListener text "..facebookText)

	--facebookText = tbt_facebook.load()

	local maxStr = 20		-- set maximum string length
	local endStr
	
	for k,v in pairs( event ) do
		local valueString = tostring(v)
		if string.len(valueString) > maxStr then
			endStr = " ... #" .. tostring(string.len(valueString)) .. ")"
		else
			endStr = ")"
		end
		print( "   " .. tostring( k ) .. "(" .. tostring( string.sub(valueString, 1, maxStr ) ) .. endStr )
	end

	--- End of debug Event routine -------------------------------------------------------


	
    print( "event.name", event.name )  --"fbconnect"
    print( "event.type:", event.type ) --type is either "session", "request", or "dialog"
    print( "event.phase ", event.phase )
    print( "isError: " .. tostring( event.isError ) )
    print( "didComplete: " .. tostring( event.didComplete ) )


    --"session" events cover various login/logout events
    --"request" events handle calls to various Graph API calls
    --"dialog" events are standard popup boxes that can be displayed


    if ( "session" == event.type ) then
        --options are: "login", "loginFailed", "loginCancelled", or "logout"
        if ( "login" == event.phase ) then
            local access_token = event.token
            --code for tasks following a successful login
        end

        if(facebookText=="GET_PHOTOS") then
        	print("facebookListener.login.user_photos")
        	--facebook.request("me/photos","GET", {limit="500"})
        	facebook.request("me", "GET", {fields="photos{images}"})
        end
        

        if(facebookText=="POST_PHOTO") then
        	print("facebookListener.login.publish_actions")
    		local attachment = {
        		message = messageText,
    			--    source = photo
	    		--}
    			source = { baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" }
    		}

    		print ("facebookListener session POST_PHOTO messageText= "..messageText)

        	--facebook.request( "me/photos", "POST", attachment )

        end



    elseif ( "request" == event.type ) then
        
        if ( not event.isError ) then
        	print ("fbook response successful" )
            local response = json.decode( event.response )
            
            --print (event.response)

            print (response.id)

            print (response.photos)

            print (response.photos.data)

            print (#response.photos.data)





            --print ("t[id]: "..t[id])
            --print ("t{id} " .. t["id"])
            --print ("t[photos]"..t[photos])
            --print ("t{photos}"..t["photos"])

            --mydata.fid = response["id"]

            




    	print("request facebookText "..facebookText)
    	if(facebookText == "GET_PHOTOS") then
    		--print("data".. event.response)
    		--print (#data)
    		math.randomseed( os.time() )
			local i = math.random(0, #response.photos.data) 
			--table.insert(fb_random_id,i) 
 			print ("i: "..i)
 			print (response.photos.data[i].images[1].source)
    
    		--print (data[i].images[1].source)
    		display.loadRemoteImage(response.photos.data[i].images[1].source,
                                "GET",
                                showImage,
                                "tbttemp.jpg", 
                                system.DocumentsDirectory,
                                display.contentCenterX,
                                display.contentCenterY-50 )

    		--photoGroup:insert(photo)
    		--photoGroup:insert(tbtImg)

    		--display.save( photoGroup, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})

    		--photoGroup.isVisible=false

    		--photo = display.newImage( "tbttemp.jpg")
    		--tbtImg = display.newImage( "TBTfaded.png" )

    		--photoGroup:insert(photo)
    		--photoGroup:insert(tbtImg)

    		--transition.to( photo, { alpha = 1.0 , xScale = scaleFactor, yScale = scaleFactor} )

    		--display.save( photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})

    		--photoGroup:toFront()

    		--photo:addEventListener("tap",fbDoubleTapListener)

 
    	elseif (facebookText == "POST_PHOTO") then
    			
    			-- ads.show( "interstitial", { x=0, y=0, appId="otherAppId" } )

				ads.show( "interstitial", { appId=interstitialAppID } )
					--else
					--	ads.show( "banner", { x=0, y=442 } )

    			confirm.text = "Upload Completed"
    			confirm.isVisible=true
    			confirm:setFillColor( 0 )	-- black
    			confirm.alpha = 1
				confirm.x = display.contentWidth * 0.5
				confirm.y = 222
    			transition.fadeOut( confirm, {time = 4000} )

    	end


        else
        	print ("request response error")
        	print ("fbook response " .. event.response)
        	--printTable( event.response, "Post Failed Response", 3 )
        end


    elseif ( "dialog" == event.type ) then
        print( "dialog", event.response )
        --handle dialog results here
    end
end
	


facebook.login( appId, facebookListener )


ads.init( adProvider, bannerAppID, adListener )



 function fieldHandler( event )
		if ( "began" == event.phase ) then
			-- This is the "keyboard has appeared" event
			-- In some cases you may want to adjust the interface when the keyboard appears.
			--cancelButton.y = 122
			--throwButton.y = 172

			transition.to( defaultField, { time=200, y=242} )

		
		elseif ( "ended" == event.phase ) then
			-- This event is called when the user stops editing a field: for example, when they touch a different field
			native.setKeyboardFocus( nil )
			
		elseif ( "editing" == event.phase ) then
			print(event.target.text)
		
		elseif ( "submitted" == event.phase ) then
			-- This event occurs when the user presses the "return" key (if available) on the onscreen keyboard
			print( event.target.text )
			
			-- Hide keyboard
			native.setKeyboardFocus( nil )
			--reset text field location
			transition.to( defaultField, { time=400, y=322 } )
		end
end


local cancelHandler = function( event )
		
	title.text = "#TBT"

	--if ( not fbOrElse) then 
		--photoGroup.isVisible = false
		--tbtImg.isVisible = false
		--photoGroup.isVisible = false
		--display.remove( photo )
		--display.remove( tbtImg)
		--display.remove( photoGroup)
	--else
	if (photo) then
		photo.isVisible = false
		display.remove(photo)
	end
	--end
--		backButton.isVisible = true
	pickButton.isVisible = true
	printsButton.isVisible=true
	postButton.isVisible = false
		
	doubleTap.text = ""
	fbButton.isVisible=true
	postButtonPrint.isVisible = false
	buttonCancel.isVisible = false
	messageText = ""
	servicesButton.isVisible = true
	reminderButton.isVisible = true
	defaultField.isVisible = false
	confirm.text=""
	doubleTap.text = ""
	--composer.removeScene( "view1", true )
	--composer.gotoScene( "menu", options )

end



 fBookGet = function(event)

	defaultField.text = ""
	print("fBookGet")

	confirm.text="Loading"
	confirm.alpha = 1
	transition.fadeOut( confirm, {time = 900}  )

		

	if( photo ) then 
	display.remove( photo )
	end

	--confirm.text = ""
	--tbt_facebook.set("GET_PHOTOS")
	--tbt_facebook.save()

	title.text = "Review Upload"
	defaultField.isVisible=true
	defaultField.placeholder= "Describe this with #fbtbtapp"
	defaultField:addEventListener( "userInput", fieldHandler ) 
	defaultField.font = native.newFont( "Helvetica-Bold", 11 )


	facebookText = "GET_PHOTOS"
		--print(facebookText)
	facebook.login( appId, facebookListener ,  { "user_photos","publish_actions"} )

--		backButton.isVisible=true
	pickButton.isVisible=false
	fbButton.isVisible=false
	postButton.isVisible=true
	printsButton.isVisible=false
	reminderButton.isVisible=false
	servicesButton.isVisible=false
	buttonCancel.isVisible=true
	
	--messageText = "#tbt #tbtapp #fbtbt"



		--facebook.request( "me/photos","GET", {limit=500})
		--facebook.request("me/photos","GET", {limit="500"})
		--print ("post request")
		--print(doubleTapText)
	if(doubleTapText == nil) then
		 
		 doubleTap.text = "Double tap to refresh photo"
    	 doubleTap.isVisible=true
    	 doubleTap:setFillColor( 0 )	-- black
		 doubleTap.x = display.contentWidth * 0.5
		 doubleTap.y = 80
		 transition.fadeOut( doubleTap, {time = 6000} )
		 --tbt_doubletap.set(1)
		 --tbt_doubletap.save()
		 --doubleTapText = tbt_doubletap.load()
	end


		--tbt_twitter.set(0)
	    --tbt_twitter.save()
	    --twitterText = tbt_twitter.load()
end



local pickPhotoHandler = function(event)
	fbOrElse = false
	defaultField.text = ""
	photo = event.target
	--print (photo)
	--print (photo.name)
	if photo then

		local scaleFactor = 1

		--save to temporary location
		--local baseDir = system.DocumentsDirectory
		--tbtImg = display.newImage( "TBTfaded.png" )


		if photo.width > photo.height then
				scaleFactor =  250 / photo.width
				--tbtImg.x = centerX+80
				--tbtImg.y = centerY+10

		else

			scaleFactor = 200 / photo.height
			print ("height greater  "..photo.height..scaleFactor)
				--tbtImg.x = centerX+70
				--tbtImg.y = centerY+20
		end
			
			
		-- Scale image to fit content scaled screen
		local xScale = _W / photo.width
		local yScale = _H / photo.height
		local scale = math.max( xScale, yScale ) 

		print( "pre scale photo w,h = " .. photo.width .. "," .. photo.height, xScale, yScale, scale, scaleFactor )
		photo:scale( scaleFactor, scaleFactor )
			
		--display.save( photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})
			
		print( "pre 2nd scale photo w,h = " .. photo.width .. "," .. photo.height, xScale, yScale, scale )

		

		--photo:scale( scale * .4 , scale * .4)
		--pickButton actions
		

		

		photo.x = centerX
		photo.y = centerY-50

		--text.isVisible = true

		--photoGroup = display.newGroup( )

		--photoGroup:insert(photo)
		--photoGroup:insert(tbtImg)
		--photo.fill = { type="image", filename="Icon-60.png" }
		--photo.isVisible=true

		display.save( photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})

		--photoGroup:insert( photo)
		--photoGroup:insert( tbtImg)

		--photo.isVisible = true
		photo:addEventListener("tap",galleryDoubleTapListener)
		--photoGroup:toFront( )
		--photoGroup.isVisible = true
		--backButton.isVisible=true
		pickButton.isVisible=false
		fbButton.isVisible=false
--		button3.isVisible=false
		postButton.isVisible=true
		printsButton.isVisible=false
		reminderButton.isVisible=false
		servicesButton.isVisible=false
		buttonCancel.isVisible=true

		defaultField.isVisible=true
		defaultField:addEventListener( "userInput", fieldHandler ) 
		--local t = native.newTextBox( centerX, 322, 180, 40 )
		defaultField.placeholder= "Describe this with #tbtapp"
		defaultField.font = native.newFont( "Helvetica-Bold", 11 )
		defaultField:setTextColor( 0.8, 0.8, 0.8 )
		--t.hasBackground = true
		--t.text = "Enter Year"
		title.text = "Review Upload"
		print( "photo w,h = " .. photo.width .. "," .. photo.height, xScale, yScale, scale )

	else
		title.text = "No Image Selected"
		title.x = display.contentCenterX
		title.y = display.contentCenterY
		print( "No Image Selected" )
	end
end


function pickPhoto( event )
	--display.remove( photo )		-- remove the previous photo object
	confirm.text = ""
	--messageText = "#tbt #tbtapp"
			--title.text = "Select a picture ..."
			--title.x = centerX
			--title.y = centerY
			
			-- Delay some to allow the display to refresh before calling the Photo Picker
	timer.performWithDelay( 100, function() media.selectPhoto( { listener = pickPhotoHandler, mediaSource = PHOTO_FUNCTION } ) end )
	return true
end



function postPhoto(event)

	twitterText = tbt_twitter.load()

	doubleTap.text=""


	local TBTfaded = display.newImage("TBTfaded.png",true)
	TBTfaded.anchorX = 1
	TBTfaded.anchorY = 1

 	if photo.contentWidth > photo.contentHeight then
 		--landscape
 		TBTfaded.oriWidth = TBTfaded.width
 		TBTfaded.width = photo.contentWidth * 0.25
 		TBTfaded.height = TBTfaded.height * TBTfaded.width / TBTfaded.oriWidth
 	else
 		--portrait
 		TBTfaded.oriWidth = TBTfaded.width
 		TBTfaded.width = photo.contentHeight * 0.25
 		TBTfaded.height = TBTfaded.height * TBTfaded.width / TBTfaded.oriWidth
 	end

	TBTfaded.x = photo.x + photo.contentWidth/2 - 5 
	TBTfaded.y = photo.y + photo.contentHeight/2 -5
	local photoGroup = display.newGroup()
	photoGroup:insert(photo)
	photoGroup:insert(TBTfaded)

	display.save( photoGroup, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})
					

		

	if(string.len(defaultField.text) > 0) then
		messageText = messageText..defaultField.text
	end

	print("messageText  "..messageText)

    local attachment = {
        message = messageText,
    	--    source = photo
	    --}
    	source = { baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" }
    	}



	--tbt_facebook.set("POST_PHOTO")
	--tbt_facebook.save()
	facebookText = "POST_PHOTO"

	facebook.login( appId, facebookListener ,  { "user_photos","publish_actions"} )

	facebook.request( "me/photos", "POST", attachment )
	    --print("postPhoto twitter")
	if(twitterText == 1) then
	    local imgFullPath = system.pathForFile(  "tbttemp.jpg", system.DocumentsDirectory )
	    tw.tweet( messageText, imgFullPath )
	end

	    --remove temporary file
	local destDir = system.DocumentsDirectory  -- where the file is stored
	local results, reason = os.remove( system.pathForFile( "tbttemp.jpg", destDir  ) )



	title.text = "Throw it Back"

	--if (fbOrElse) then
	--if (fbOrElse) then
	if(photo) then
		photo.isVisible=false
		display.remove( photo )
	end
	photoGroup:removeSelf()
	photoGroup = nil
	--elseif(not fbOrElse) then
	--	photo.isVisible = false
	--	photoGroup.isVisible = false
	--	tbtImg.isVisible = false
	--	display.remove(photo)
	--	display.remove(photoGroup)
	--	display.remove(tbtImg)

	--end
	text.isVisible = false
	display.remove(text)
		
	fbButton.isVisible = true
	pickButton.isVisible=true
	postButton.isVisible=false
	buttonCancel.isVisible=false
	printsButton.isVisible=true
	reminderButton.isVisible=true
	servicesButton.isVisible=true
	defaultField.text = ""
	defaultField.isVisible=false
	    
	    --facebook.request( "me/myPhoto.photos", "POST", attachment )
end

 function postPhotoPrint(event)

	twitterText = tbt_twitter.load()

 	local TBTfaded = display.newImage("TBTfaded.png",true)
	TBTfaded.anchorX = 1
	TBTfaded.anchorY = 1

 	if photo.contentWidth > photo.contentHeight then
 		--landscape
 		TBTfaded.oriWidth = TBTfaded.width
 		TBTfaded.width = photo.contentWidth * 0.25
 		TBTfaded.height = TBTfaded.height * TBTfaded.width / TBTfaded.oriWidth
 	else
 		--portrait
 		TBTfaded.oriWidth = TBTfaded.width
 		TBTfaded.width = photo.contentHeight * 0.25
 		TBTfaded.height = TBTfaded.height * TBTfaded.width / TBTfaded.oriWidth
 	end

	TBTfaded.x = photo.x + photo.contentWidth/2 - 5 
	TBTfaded.y = photo.y + photo.contentHeight/2 -5
	local photoGroup = display.newGroup()
	photoGroup:insert(photo)
	photoGroup:insert(TBTfaded)

	display.save( photoGroup, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})
					

	if(string.len(defaultField.text) > 0) then
		messageText = messageText..defaultField.text
	end

	--print (messageText)

	 local attachment = {
        message = messageText,
    	--    source = photo
	    --}
    	source = { baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" }
    }



	    --tbt_facebook.set("POST_PHOTO")
		--tbt_facebook.save()
	facebookText = "POST_PHOTO"


	facebook.login( appId, facebookListener, {"publish_actions","user_photos"}  )

	facebook.request( "me/photos", "POST", attachment )
    if(twitterText == 1) then
	    local imgFullPath = system.pathForFile(  "tbttemp.jpg", system.DocumentsDirectory )
    	tw.tweet( messageText, imgFullPath )
	end

	title.text = "#TBT"

	photo.isVisible=false
	display.remove( photo )	
	--tbtImg.isVisible = false
	--display.remove(tbtImg)

	photoGroup:removeSelf()
	photoGroup = nil
	--tbtImg.isVisible = false
	--display.remove(tbtImg)
	text.isVisible = false
	display.remove(text)
	pickButton.isVisible=true
	postButtonPrint.isVisible=false
    printsButton.isVisible=true
    buttonCancel.isVisible=false
    fbButton.isVisible=true
    reminderButton.isVisible=true
    servicesButton.isVisible=true
    defaultField.text = ""
    defaultField.isVisible=false
    --facebook.request( "me/myPhoto.photos", "POST", attachment )
end



local capturePrintHandler = function(event)

	fbOrElse = false
	defaultField.text = ""
	if (event.completed) then
		photo = event.target

			
		print ("event.completed")
		--print (photo.name)
		if photo then

			--if photo.width > photo.height then
			--	photo:rotate( -90 )			-- rotate for landscape
			--	print( "Rotated" )
			--end

			--save to temporary location
			--local baseDir = system.DocumentsDirectory


						pickButton.isVisible=false
			printsButton.isVisible=false
		--		button3.isVisible=false
			postButtonPrint.isVisible=true
			buttonCancel.isVisible=true
			fbButton.isVisible=false
			reminderButton.isVisible=false
			servicesButton.isVisible=false
			--
			local scaleFactor = 1

			--tbtImg = display.newImage( "TBTfaded.png" )

			--save to temporary location
			--local baseDir = system.DocumentsDirectory

			if photo.width > photo.height then
					scaleFactor = 250 / photo.width
					--tbtImg.x = centerX+50
				--tbtImg.y = centerY+10
			else

				scaleFactor = 200 / photo.height
				--tbtImg.x = centerX+50
				--tbtImg.y = centerY+20
				print ("height greater  "..photo.height..scaleFactor) 
			end
				
				-- Scale image to fit content scaled screen
			local xScale = _W / photo.width
			local yScale = _H / photo.height
			local scale = math.min( xScale, yScale ) * scaleFactor

			print( "pre scale photo w,h = " .. photo.width .. "," .. photo.height, xScale, yScale, scale )
	

			photo:scale( scaleFactor, scaleFactor )

			photo.x = centerX
			photo.y = centerY-50

			
			photo.isVisible=true
			--tbtImg.isVisible=true

			--photoGroup:insert(photo)
			--photoGroup:insert(tbtImg)

			--photoGroup:addEventListener( "tap", printsDoubleTapListener )
			
			display.save( photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})
				
			print( "pre 2nd scale photo w,h = " .. photo.width .. "," .. photo.height, xScale, yScale, scale )

			defaultField.isVisible=true
			defaultField:addEventListener( "userInput", fieldHandler ) 
			--local t = native.newTextBox( centerX, 322, 180, 40 )
			defaultField.placeholder= "Describe this with #tbtapp #gotprints"
			defaultField.font = native.newFont( "Helvetica-Bold", 11 )
			defaultField:setTextColor( 0.8, 0.8, 0.8 )

			--photo:scale( scale * .4, scale * .4)
			--pickButton actions
			
			--photoGroup:toFront()
			--photoGroup.isVisible=true

			


			title.text = "Review Upload"
			print( "post final scale photo w,h = " .. photo.width .. "," .. photo.height, xScale, yScale, scale )

		else
			title.text = "No Image Selected"
			title.x = display.contentCenterX
			title.y = display.contentCenterY
			print( "No Image Selected" )
		end
	end
end

gotPrints = function(event)
	--display.remove( photo )		-- remove the previous photo object
	confirm.text = ""
	--messageText = "#tbt #tbtapp #gotprints"
		--title.text = "Select a picture ..."
		--title.x = centerX
		--title.y = centerY
		
		--media.capturePhoto( {listener = capturePrintHandler, destination = {baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" } } )
	media.capturePhoto( {listener = capturePrintHandler}  )
end





local throwButtonHandler = function( event )
	title.text = ""
	throwButton.isVisible = false
	reminderButton.isVisible = false
	servicesButton.isVisible = false
	
	composer.gotoScene( "view1", options )

end



local reminderButtonHandler = function( event )
	
	title.text = ""
	throwButton.isVisible = false
	reminderButton.isVisible = false
	servicesButton.isVisible = false
	fbButton.isVisible = false
	pickButton.isVisible = false
	printsButton.isVisible = false
	confirm.text = ""

	composer.gotoScene( "view2", options )

end



local servicesButtonHandler = function( event )
	
	title.text = ""
	throwButton.isVisible = false
	reminderButton.isVisible = false
	servicesButton.isVisible = false
	fbButton.isVisible = false
	pickButton.isVisible = false
	printsButton.isVisible = false
	confirm.text = ""

	composer.gotoScene( "view3", options )

end



-- Called when the scene's view does not exist:
function scene:create( event )
	local sceneGroup = self.view
	
	display.setStatusBar( display.HiddenStatusBar )

	title = display.newText( "#TBT", 0, 0, native.systemFont, 36 )
	title:setFillColor( .8, .4,.1 )	-- black
	title.x = display.contentWidth * 0.5
	title.y = 25
	
	throwButton = widget.newButton
	{
		id = "throwButton",
		label = "Throw it Back!",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 14,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .25, .5, .5, 1 }, over={ .25, 0.1, 0.1, 0.4 } },
		onRelease = throwButtonHandler
	}

	throwButton.x = display.contentCenterX; throwButton.y = 322

	fbButton = widget.newButton
	{
		defaultFile = "fbButton184.png",
		overFile = "fbButtonOver184.png",
		label = "Random Throwback",
		font = native.systemFontBold,
		fontSize=11,
		labelColor = 
		{ 
			default = { 255, 255, 255 }, 
		},
		onRelease = fBookGet
	}
	fbButton.x = display.contentCenterX; fbButton.y = 272
	
	fbButton.isVisible=true

		pickButton = widget.newButton
	{
		id="pickButton",
		label="Phone Throwback",
		font = native.systemFontBold,
		height = 35,
		width = 110,
		fontSize = 10,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .25, .5, .5, 1 }, over={ .25, 0.1, 0.1, 0.4 } },
		onRelease = pickPhoto	
	}

	pickButton.x = display.contentCenterX-65; pickButton.y = 322
	--pickButton:addEventListener("tap", pickPhoto )
	pickButton.isVisible=true

	printsButton = widget.newButton
	{
		id="printsButton",
		label="Printed Throwback",
		font = native.systemFontBold,
		height = 35,
		width = 110,
		fontSize = 11,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .95, .8, 0, 1 }, over={ .95, 0.1, 0.8, 0.4 } },
		onRelease = gotPrints

	}

	printsButton.x = display.contentCenterX+65; printsButton.y = 322
	printsButton.isVisible=true

	postButton = widget.newButton
	{
		id="postButton",
		label="Throw It Back",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 14,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
		onRelease = postPhoto	
	}

	postButton.x = display.contentCenterX; postButton.y = 372
	postButton.isVisible=false

	postButtonPrint = widget.newButton
	{
		id="postButtonPrint",
		label="Throw It Back",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 14,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
		onRelease = postPhotoPrint	
	}

	postButtonPrint.x = display.contentCenterX; postButtonPrint.y = 372
	postButtonPrint.isVisible=false


	reminderButton = widget.newButton
	{
		id = "reminderButton",
		label = "Set a Reminder",
		font = native.systemFontBold,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		fontSize = 14,
		height = 40,
		width = 200,
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
		onRelease = reminderButtonHandler
	}

	reminderButton.x = display.contentCenterX; reminderButton.y = 372

	if ( system.getInfo( "platformName" ) == "Android" ) then
		ads.show( "banner", { x=0, y=472 } )
	--else
	--	ads.show( "banner", { x=0, y=442 } )
	end
	
	
	
	servicesButton = widget.newButton
	{
		id = "servicesButton",
		label = "Add Services",
		font = native.systemFontBold,
		fontSize = 14,
		emboss = true,
		height = 40,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		width = 200,
		shape="roundedRect",
		fillColor = { default={ .95, .8, 0, 1 }, over={ .95, 0.1, 0.8, 0.4 } },
		onRelease = servicesButtonHandler
	}

	servicesButton.x = display.contentCenterX; servicesButton.y = 422

		buttonCancel = widget.newButton
	{
		id="buttonCancel",
		label="Cancel",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 14,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .95, .8, 0, 1 }, over={ .95, 0.1, 0.8, 0.4 } },
		onRelease = cancelHandler

	}

	buttonCancel.x = display.contentCenterX; buttonCancel.y = 422
	buttonCancel.isVisible=false

end

function scene:show( event )
	
	local phase = event.phase

	--print ("menu: show")
	
	if "did" == phase then
	
		--print( "previous: show event, phase did" )
	
		-- remove previous scene's view
	
		-- Update Lua memory text display
	title.text = "#TBT"
	title:setFillColor( .25, .5, .5)
	throwButton.isVisible = false
	reminderButton.isVisible = true
	servicesButton.isVisible = true
	fbButton.isVisible = true
	pickButton.isVisible = true
	printsButton.isVisible = true
	--composer.gotoScene( "view1", options )
	
	end
	
end



-- Listener setup
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene