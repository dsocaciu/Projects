-----------------------------------------------------------------------------------------
--
-- view1.lua
--
-----------------------------------------------------------------------------------------



-- show default status bar (iOS)
display.setStatusBar( display.DefaultStatusBar )
display.setStatusBar( display.HiddenStatusBar )
display.setDefault( "background", 1, 1, 1 )

-- include Corona's "widget" library
local widget = require "widget"
local composer = require "composer"
local lfs = require "lfs"

local tbt_twitter = require("tbt_twitter")
local tbt_facebook = require("tbt_facebook")

local twitterText = tbt_twitter.load()

local facebookText = tbt_facebook.load()


local confirm = display.newText( "", 0, 0, native.systemFont, 14 )
local scene = composer.newScene()

local myPhoto = require("myPhoto")	-- holds the myPhoto.photo object
local PHOTO_FUNCTION = media.PhotoLibrary 		-- or media.SavedPhotosAlbum

local centerX = display.contentCenterX
local centerY = display.contentCenterY
local _W = display.contentWidth
local _H = display.contentHeight

local facebook = require "facebook"

local appId = "removed"

local messageText = ""

local pickButton,backButton,postButton,fbButton

local tw = require( "twitterfacade" )
local consumer_key = "removed" -- key string goes here
local consumer_secret = "removed" -- secret string goes here
local webURL = "http://www.tbtapp.com"
tw.init(consumer_key,consumer_secret,webURL)

local callback = {}

local title = display.newText( "#TBT", 0, 0, native.systemFont, 32 )
title:setFillColor( .25, .5, .5 )	-- black
title.x = display.contentWidth * 0.5
title.y = 25





-- Called when the scene's view does not exist:
function scene:create( event )
	local sceneGroup = self.view



	local cancelHandler = function( event )
		
		title.text = "Throw it Back"
		display.remove( myPhoto.photo )
		myPhoto.photo.isVisible = false
		backButton.isVisible = true
		pickButton.isVisible = true
		printsButton.isVisible=true
		postButton.isVisible = false
		
		fbButton.isVisible=true
		postButtonPrint.isVisible = false
		buttonCancel.isVisible = false
		messageText = ""

		--composer.removeScene( "view1", true )
		--composer.gotoScene( "menu", options )

	end

	local backButtonHandler = function( event )
		
		title.text = ""
		confirm.text = ""
		display.remove( myPhoto.photo )
		backButton.isVisible = false
		pickButton.isVisible = false
		printsButton.isVisible=false
		postButton.isVisible = false
		fbButton.isVisible=false
		postButtonPrint.isVisible = false
		composer.removeScene( "view1", true )
		composer.gotoScene( "menu", options )

	end

	local capturePrintHandler = function(event)

		if (event.completed) then
			myPhoto.photo = event.target

			
			--print (myPhoto.photo)
			--print (myPhoto.photo.name)
			if myPhoto.photo then

				--if myPhoto.photo.width > myPhoto.photo.height then
				--	myPhoto.photo:rotate( -90 )			-- rotate for landscape
				--	print( "Rotated" )
				--end

				--save to temporary location
				--local baseDir = system.DocumentsDirectory
				--
				local scaleFactor = 1

				--save to temporary location
				--local baseDir = system.DocumentsDirectory

				if myPhoto.photo.width > myPhoto.photo.height then
					scaleFactor = 250 / myPhoto.photo.width

				else

				scaleFactor = 200 / myPhoto.photo.height
				print ("height greater  "..myPhoto.photo.height..scaleFactor) 
				end
				
				-- Scale image to fit content scaled screen
				local xScale = _W / myPhoto.photo.width
				local yScale = _H / myPhoto.photo.height
				local scale = math.min( xScale, yScale ) * scaleFactor

				print( "pre scale myPhoto.photo w,h = " .. myPhoto.photo.width .. "," .. myPhoto.photo.height, xScale, yScale, scale )
	

				myPhoto.photo:scale( scaleFactor, scaleFactor )
				
				display.save( myPhoto.photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})
				
				print( "pre 2nd scale myPhoto.photo w,h = " .. myPhoto.photo.width .. "," .. myPhoto.photo.height, xScale, yScale, scale )

				--myPhoto.photo:scale( scale * .4, scale * .4)
				--pickButton actions
				backButton.isVisible=true
				myPhoto.photo.x = centerX
				myPhoto.photo.y = centerY-50
				pickButton.isVisible=false
				printsButton.isVisible=false
		--		button3.isVisible=false
				postButtonPrint.isVisible=true
				buttonCancel.isVisible=true
				fbButton.isVisible=false
				title.text = "Review Upload"
				print( "post final scale myPhoto.photo w,h = " .. myPhoto.photo.width .. "," .. myPhoto.photo.height, xScale, yScale, scale )

			else
				title.text = "No Image Selected"
				title.x = display.contentCenterX
				title.y = display.contentCenterY
				print( "No Image Selected" )
			end
		end
	end

	local gotPrints = function(event)
		display.remove( myPhoto.photo )		-- remove the previous myPhoto.photo object
		--title.text = "Select a picture ..."
		--title.x = centerX
		--title.y = centerY
		
		--media.capturePhoto( {listener = capturePrintHandler, destination = {baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" } } )
		media.capturePhoto( {listener = capturePrintHandler}  )

	end

	local fBookGet = function(event)
		display.remove( myPhoto.photo )
		tbt_facebook.set("GET_PHOTOS")
		tbt_facebook.save()
		facebookText = tbt_facebook.load()
		--print(facebookText)
		backButton.isVisible=true
		pickButton.isVisible=false
		fbButton.isVisible=false
		postButton.isVisible=true
		printsButton.isVisible=false
		buttonCancel.isVisible=true
		title.text = "Review Upload"
		facebook.request( "me/photos","GET", {limit=500})


		--tbt_twitter.set(0)
	    --tbt_twitter.save()
	    --twitterText = tbt_twitter.load()
	end


	local sessionComplete = function(event)
		myPhoto.photo = event.target
		--print (myPhoto.photo)
		print (myPhoto.photo.name)
		if myPhoto.photo then

			local scaleFactor = 1

			--save to temporary location
			--local baseDir = system.DocumentsDirectory

			if myPhoto.photo.width > myPhoto.photo.height then
					scaleFactor =  250 / myPhoto.photo.width

			else

				scaleFactor = 200 / myPhoto.photo.height
				print ("height greater  "..myPhoto.photo.height..scaleFactor) 
			end
			
			
			-- Scale image to fit content scaled screen
			local xScale = _W / myPhoto.photo.width
			local yScale = _H / myPhoto.photo.height
			local scale = math.max( xScale, yScale ) 

			print( "pre scale myPhoto.photo w,h = " .. myPhoto.photo.width .. "," .. myPhoto.photo.height, xScale, yScale, scale, scaleFactor )


			myPhoto.photo:scale( scaleFactor, scaleFactor )
			
			display.save( myPhoto.photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})
			
			print( "pre 2nd scale myPhoto.photo w,h = " .. myPhoto.photo.width .. "," .. myPhoto.photo.height, xScale, yScale, scale )

			--myPhoto.photo:scale( scale * .4 , scale * .4)
			--pickButton actions
			myPhoto.photo.x = centerX
			myPhoto.photo.y = centerY-50
			backButton.isVisible=true
			pickButton.isVisible=false
			fbButton.isVisible=false
	--		button3.isVisible=false
			postButton.isVisible=true
			printsButton.isVisible=false
			buttonCancel.isVisible=true
			title.text = "Review Upload"
			print( "myPhoto.photo w,h = " .. myPhoto.photo.width .. "," .. myPhoto.photo.height, xScale, yScale, scale )

		else
			title.text = "No Image Selected"
			title.x = display.contentCenterX
			title.y = display.contentCenterY
			print( "No Image Selected" )
		end
	end




	-- Button tap listener
	local function pickPhoto( event )
		display.remove( myPhoto.photo )		-- remove the previous myPhoto.photo object
		--title.text = "Select a picture ..."
		--title.x = centerX
		--title.y = centerY
		
		-- Delay some to allow the display to refresh before calling the Photo Picker
		timer.performWithDelay( 100, function() media.selectPhoto( { listener = sessionComplete, mediaSource = PHOTO_FUNCTION } ) 
		end )
		return true
	end


	local function postPhoto(event)
	    local attachment = {
	        message = "#tbt #tbtapp ",
	    --    source = myPhoto.photo
	    --}

	    source = { baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" }
	    }


	    tbt_facebook.set("0")
		tbt_facebook.save()
		facebookText = tbt_facebook.load()

	    facebook.request( "me/photos", "POST", attachment )
	    print("postPhoto twitter")
	    if(twitterText == 1) then
	    	tw.tweet( "#tbt #tbtapp", "tbttemp.jpg" )
		end

	    --remove temporary file
	    local destDir = system.DocumentsDirectory  -- where the file is stored
		local results, reason = os.remove( system.pathForFile( "tbttemp.jpg", destDir  ) )

		confirm.text = "Upload Completed"
		confirm:setFillColor( 0 )	-- black
		confirm.x = display.contentWidth * 0.5
		confirm.y = 222

		title.text = "Throw it Back"


		myPhoto.photo.isVisible=false
		display.remove( myPhoto.photo )	
		
		fbButton.isVisible = true
		pickButton.isVisible=true
		postButton.isVisible=false
		buttonCancel.isVisible=false
	    printsButton.isVisible=true
	    --facebook.request( "me/myPhoto.photos", "POST", attachment )
	end

	local postMsg_onRelease

	local function postPhotoPrint(event)

		display.save( myPhoto.photo, {filename="tbttemp.jpg", baseDir=system.DocumentsDirectory , isFullResolution=true, jpegQuality=1})


	    local attachment = {
	        message = "#tbt #tbtapp #gotprints",
	    --    source = myPhoto.photo
	    --}

	    source = { baseDir=system.DocumentsDirectory, filename="tbttemp.jpg", type="image" }
	    }

	    tbt_facebook.set("0")
		tbt_facebook.save()
		facebookText = tbt_facebook.load()
	    
	    facebook.request( "me/photos", "POST", attachment )
	    if(twitterText == 1) then
	    	tw.tweet( "#tbt #tbtapp #gotprints", "tbttemp.jpg" )
		end


		confirm.text = "Upload Completed"
		confirm:setFillColor( 0 )	-- black
		confirm.x = display.contentWidth * 0.5
		confirm.y = 222

		title.text = "Throw it Back"

	    --remove temporary file
	    --local destDir = system.DocumentsDirectory  -- where the file is stored
		--local results, reason = os.remove( system.pathForFile( "tbttemp.jpg", destDir  ) )


		myPhoto.photo.isVisible=false
		display.remove( myPhoto.photo )	
		pickButton.isVisible=true
		postButtonPrint.isVisible=false
	    printsButton.isVisible=true
	    --facebook.request( "me/myPhoto.photos", "POST", attachment )
	end

	--print("twitter on "..services.twitter)
	
	--local pickButton = display.newRect(120,240,80,70)
	pickButton = widget.newButton
	{
		id="pickButton",
		label="Select Photo",
		font = native.systemFontBold,
		height = 40,
		width = 60,
		fontSize = 22,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .25, .5, .5, 1 }, over={ .25, 0.1, 0.1, 0.4 } },
		onRelease = pickPhoto	
	}

	pickButton.x = display.contentCenterX; pickButton.y = 322
	--pickButton:addEventListener("tap", pickPhoto )
	pickButton.isVisible=true

	printsButton = widget.newButton
	{
		id="printsButton",
		label="Got Prints?",
		font = native.systemFontBold,
		height = 40,
		width = 60,
		fontSize = 22,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
		onRelease = gotPrints

	}

	printsButton.x = display.contentCenterX+60 ; printsButton.y = 372
	printsButton.isVisible=true

	buttonCancel = widget.newButton
	{
		id="buttonCancel",
		label="Cancel",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 22,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
		onRelease = cancelHandler

	}

	buttonCancel.x = display.contentCenterX; buttonCancel.y = 372
	buttonCancel.isVisible=false




	backButton = widget.newButton
	{
		id = "backButton",
		label = "Back",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 22,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .95, .8, 0, 1 }, over={ .95, 0, 0.8, 0.4 } },
		onRelease = backButtonHandler
	}

	backButton.x = display.contentCenterX; backButton.y = 422
	
		--local pickButton = display.newRect(120,240,80,70)
	postButton = widget.newButton
	{
		id="postButton",
		label="Throw It Back",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 22,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .25, .5, .5, 1 }, over={ .25, 0.1, 0.1, 0.4 } },
		onRelease = postPhoto	
	}

	postButton.x = display.contentCenterX; postButton.y = 322
	postButton.isVisible=false
	--pickButton:addEventListener("tap", pickPhoto )

	postButtonPrint = widget.newButton
	{
		id="postButtonPrint",
		label="Throw It Back",
		font = native.systemFontBold,
		height = 40,
		width = 200,
		fontSize = 22,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		emboss = true,
		shape="roundedRect",
		fillColor = { default={ .25, .5, .5, 1 }, over={ .25, 0.1, 0.1, 0.4 } },
		onRelease = postPhotoPrint	
	}

	postButtonPrint.x = display.contentCenterX; postButtonPrint.y = 322
	postButtonPrint.isVisible=false

	fbButton = widget.newButton
	{
		defaultFile = "fbButton184.png",
		overFile = "fbButtonOver184.png",
		label = "Facebook Photo",
		labelColor = 
		{ 
			default = { 255, 255, 255 }, 
		},
		onRelease = fBookGet
	}
	fbButton.x = display.contentCenterX; fbButton.y = 272
	
	fbButton.isVisible=true
	



end 

function scene:show( event )
	composer.removeScene( "menu" )
	display.remove( myPhoto.photo )
	title.text = "Throw it Back"
	pickButton.isVisible=true
	backButton.isVisible=true
	postButton.isVisible=false
	
	fbButton.isVisible=true
	printsButton.isVisible=true
	postButtonPrint.isVisible=false
	buttonCancel.isVisible=false

end

-- Listener setup
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )

return scene