-----------------------------------------------------------------------------------------
--
-- view1.lua
--
-----------------------------------------------------------------------------------------



-- show default status bar (iOS)
display.setStatusBar( display.DefaultStatusBar )

-- include Corona's "widget" library
local widget = require("widget")
local composer = require("composer")
local scene = composer.newScene()

local tbt_reminder = require("tbt_reminder")
local notifications = require( "plugin.notifications" )

local reminderText = tbt_reminder.load()


local confirm = display.newText( "", 0, 0, native.systemFont, 14 )

confirm.x = display.contentWidth * 0.5
confirm.y = 322

local notificationId

native.setProperty( "applicationIconBadgeNumber", 0 )


display.setStatusBar( display.HiddenStatusBar )
display.setDefault( "background", 1, 1, 1 )

local title = display.newText( "Set Reminder", 0, 0, native.systemFont, 36 )
title:setFillColor( .8,.4,.1 )	
title.x = display.contentWidth * 0.5
title.y = 25


function scene:create( event )

	local sceneGroup = self.view

	if (reminderText > 0 ) then
		confirm.text = "Reminder set for "..reminderText
	end
	



	-- Set up the picker column data
	local days = {}
	local years = {"00","01","02","03","04","05","06","07","08","09",
 		"10", "11","12","13","14","15","16","17","18","19",
 		"20", "21","22","23","24","25","26","27","28","29",
 		"30", "31","32","33","34","35","36","37","38","39",
 		"40", "41","42","43","44","45","46","47","48","49",
 		"50", "51","52","53","54","55","56","57","58","59"}
	
	for i = 1,12 do days[i] = i end
	--for j = 0,59 do years[j] = j end


	local columnData = { 
		{
			align = "center",
			width = 70,
			startIndex = 7,
			labels = days,
		},
		{
			align = "center",
			width = 65,
			startIndex = 14,
			labels = years,
		},
		{
			align = "right",
			width = 125,
			startIndex = 1,
			labels = {
				"AM","PM" 
			},
		}
	}
		
	-- Create a new Picker Wheel
	local pickerWheel = widget.newPickerWheel {
		top = 60,
		columns = columnData
	}

		--checkboxWeekly = widget.newSwitch
		--{
		--    left = 10,
		--    top = 290,
		--    style = "checkbox",
		--    id = "CheckboxWeekly",
		--    initialSwitchState = false,
		--    onPress = onSwitchWeekly
		--}

		--checkboxMonthly = widget.newSwitch
		--{
		--    left = display.contentWidth/2-20,
		--    top = 290,
		--    style = "checkbox",
		--    id = "CheckboxMonthly",
		--    initialSwitchState = false,
		--    onPress = onSwitchMonthly
		--}

		--checkboxYearly = widget.newSwitch
		--{
		--    left = display.contentWidth-60,
		--    top = 290,
		--    style = "checkbox",
		--    id = "CheckboxYearly",
		--    initialSwitchState = false,
		--    onPress = onSwitchYearly
		--}




		--display.contentWidth



	sceneGroup:insert( pickerWheel )

	local buttonHandler1 = function( event )
		
		title.text = ""
		button1.isVisible = false
		button2.isVisible = false
		button3.isVisible = false
		confirm.text = ""
		composer.removeScene( "view2", true )
		composer.gotoScene( "menu", options )

	end

	local setCancelHandler = function(event)
		tbt_reminder.set(0)
		tbt_reminder.save()
		reminderText = tbt_reminder.load()
		notifications.cancelNotification( notificationId )
		--system.cancelNotification( )
		button2.isVisible = true
		button3.isVisible =  false

		confirm.text = "Reminder Canceled"
		confirm.alpha = 1
		transition.fadeOut( confirm, {time = 4000} )

	end

	local setReminderHandler = function(event)
		--print( os.date( "%c" )) 
		--:print( os.date( "%A"))
		local secondsTilThursday
		local secondsInDay = 60*60*24
		local day = os.date("%A")
--		print (day)

		local secondsTilNotification



--		print(os.date("%H").."\n")

		local time = os.date("*t")
		local min = time.min
		local sec = time.sec
		local hour = os.date("%H")
		local values = pickerWheel:getValues()
		


		-- Update the status box text
		print("\nColumn 1 Value: " .. values[1].value .. "\nColumn 2 Value: " .. values[2].value .. "\nColumn 3 Value: " .. values[3].value)
--		print (statusText.text)


		local reminderTime = values[1].value * 60 * 60 + values[2].value * 60 

		if values[3].value== "PM" then
			reminderTime = reminderTime + 720*60
		end

		local nowTime = hour *60 * 60 + min * 60 + sec

		print("reminderTime: "..reminderTime.." h:"..values[1].value .. " m:" .. values[2].value .. " s:" .. values[3].value)
		print("nowTime: " .. nowTime .. " h:"..hour .. " m: "..min .. " s:"..sec)

		if  nowTime < reminderTime then
			print "before"
			confirm.text = "Reminder set for Thursday"
			confirm.alpha = 1
			transition.fadeOut( confirm, {time = 4000} )
			secondsTilNotification =  reminderTime-nowTime
			print (secondsTilNotification)
		else 
			confirm.text = "Reminder set for next Thursday"
			confirm.alpha =1 
			transition.fadeOut( confirm, {time = 4000} )
			secondsTilNotification = nowTime-reminderTime
			print (secondsTilNotification)
		end


		if day =="Friday" then
			secondsTilThursday = 6 * secondsInDay + secondsTilNotification
		elseif day =="Saturday" then
			secondsTilThursday = 5 * secondsInDay + secondsTilNotification
		elseif day =="Sunday" then
			secondsTilThursday = 4 * secondsInDay + secondsTilNotification
		elseif day =="Monday" then
			secondsTilThursday = 3 * secondsInDay + secondsTilNotification
		elseif day =="Tuesday" then
			secondsTilThursday = 2 * secondsInDay + secondsTilNotification
		elseif day =="Wednesday" then
			secondsTilThursday = 1 * secondsInDay + secondsTilNotification
		elseif day =="Thursday" then
			if secondsTilNotification > 0 then
				secondsTilThursday = secondsTilNotification
			else 
				secondsTilThursday = 7 * secondsInDay + secondsTilNotification
			end
		end


		-- Set up notification options.
		local options = {
    		alert = "Time to Throw It Back!",
    		badge = 2
    		--sound = "alarm.caf",
    		--custom = { foo = "bar" }
		}

		notificationId = notifications.scheduleNotification( secondsTilThursday, options )
--		local notificationId = system.scheduleNotification( secondsTilThursday, options )

		--confirm.text = "Reminder set for next Thursday"
		confirm:setFillColor( 0 )	-- black
		confirm.x = display.contentWidth * 0.5
		confirm.y = 322

		if(values[3].value == "PM") then
			tbt_reminder.set((values[1].value+12) * 100 + values[2].value)
		else
			tbt_reminder.set( values[1].value * 100 + values[2].value)
		end
		tbt_reminder.save()
		reminderText = tbt_reminder.load()
		print(reminderText)

		button2.isVisible = false
		button3.isVisible = true
		--print(notificationId)
	
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



		button2 = widget.newButton
		{
			id="button2",
			label="Set Reminder",
			font = native.systemFontBold,
			height = 40,
			width = 200,
			fontSize = 14,
			labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
			emboss = true,
			shape="roundedRect",
			fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
			onRelease = setReminderHandler
		}

			button2.x = display.contentCenterX; button2.y = 372
			button2.isVisible=true

	button3 = widget.newButton
		{
			id="button2",
			label="Cancel Reminder",
			font = native.systemFontBold,
			height = 40,
			width = 200,
			fontSize = 14,
			labelColor = {default={ 1, 1, 1 }, over={ 0, 0, 0, 0.5 }},
			emboss = true,
			shape="roundedRect",
			fillColor = { default={ .8, .4, .1, 1 }, over={ .8, 0.1, 0.4, 0.4 } },
			onRelease = setCancelHandler
		}

		button3.x = display.contentCenterX; button3.y = 372
		button3.isVisible=false




end
-- Get the table of current values for all columns
-- This can be performed on a button tap, timer execution, or other event
--local values = pickerWheel:getValues()

function scene:show( event )
	composer.removeScene( "menu" )
	--display.remove( photo )
	title.text ="Set Reminder"
	--button.isVisible=true
	button1.isVisible=true
	--print(reminderText)
	--button3.isVisible=true
	if(reminderText==0) then
		print ("Initial show")
		button2.isVisible = true
		button3.isVisible = false
		confirm.text = ""

	else
		button2.isVisible = false
		button3.isVisible = true
		confirm.text = "Reminder set for "..reminderText

	end


end


-- Listener setup
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )

return scene