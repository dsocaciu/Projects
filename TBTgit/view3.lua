-----------------------------------------------------------------------------------------
--
-- view1.lua
--
-----------------------------------------------------------------------------------------



-- show default status bar (iOS)
display.setStatusBar( display.DefaultStatusBar )

-- include Corona's "widget" library
local widget = require "widget"
local composer = require "composer"

local tbt_twitter = require("tbt_twitter")

local twitterText = tbt_twitter.load()

local scene = composer.newScene()

local checkboxTwitter

local title

--print ("twitter .. "..twitterText)

local tw = require( "twitterfacade" )
local consumer_key = "removed" -- key string goes here
local consumer_secret = "removed" -- secret string goes here
local webURL = "http://www.tbtapp.com"
--tw.init(consumer_key,consumer_secret,webURL)

local twitterTitle = display.newText( "Twitter", 0, 0, native.systemFont, 22 )
twitterTitle:setFillColor( .25,.5,.5 )	-- black
twitterTitle.x = 125
twitterTitle.y = 215

display.setStatusBar( display.HiddenStatusBar )

function scene:create(event)

	title = display.newText( "Add Services", 0, 0, native.systemFont, 32 )
	title:setFillColor( .95,.8,0 )	-- black
	title.x = display.contentWidth * 0.5
	title.y = 25


	local buttonHandler1 = function( event )
		
		title.text = ""
		twitterTitle.text = ""
		button1.isVisible = false
		checkboxTwitter.isVisible=false
		composer.removeScene( "view3", true )
		composer.gotoScene( "menu", options )

	end

	button1 = widget.newButton
	{
		id = "button1",
		label = "Back",
		font = native.systemFontBold,
		fontSize = 14,
		emboss = true,
		height = 40,
		labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
		width = 200,
		shape="roundedRect",
		fillColor = { default={ .95, .8, 0, 1 }, over={ .95, 0.1, 0.8, 0.4 } },
		onRelease = buttonHandler1
	}

	button1.x = display.contentCenterX; button1.y = 422

	local function onSwitchTwitter( event )
	    local switch = event.target
	    print( "Switch with ID '"..switch.id.."' is on: "..tostring(switch.isOn) )
	    --sertwitter = switch.isOn
	    if(switch.isOn) then
	    	tbt_twitter.set(1)
	    	tbt_twitter.save()
	    	tw.init(consumer_key,consumer_secret,webURL)
	    	twitterText = tbt_twitter.load()
	    	print("on "..twitterText)
	    else
	    	tbt_twitter.set(0)
	    	tbt_twitter.save()
	    	twitterText = tbt_twitter.load()
	    	print ("off" .. twitterText)
	    end
	    --print (services.twitter)
	end

	-- Create the widget
	if(twitterText == 1) then

		checkboxTwitter = widget.newSwitch
		{
		    left = 50,
		    top = 200,
		    style = "checkbox",
		    id = "CheckboxTwitter",
		    initialSwitchState = true,
		    onPress = onSwitchTwitter
		}
	else
		checkboxTwitter = widget.newSwitch
		{
		    left = 50,
		    top = 200,
		    style = "checkbox",
		    id = "CheckboxTwitter",
		    initialSwitchState = false,
		    onPress = onSwitchTwitter
		}
	end
end

function scene:show( event )
	composer.removeScene( "menu" )
	title.text = "Add Services"
	twitterTitle.text = "Twitter"
	button1.isVisible=true
	checkboxTwitter.isVisible=true
	twitterTitle.isVisible=true
	if(twitterText == 1) then
		checkboxTwitter.isOn = true
	end

	--print ("twitter"..twitter)
	--if(services.twitter) then
	--checkboxTwitter.isOn=true
	--end

end

-- Listener setup
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )

return scene