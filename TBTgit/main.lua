-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- show default status bar (iOS)
display.setStatusBar( display.DefaultStatusBar )
display.setDefault( "background", 1, 1, 1 )

-- include Corona's "widget" library
local widget = require "widget"
local composer = require "composer"
local tbt_facebook = require("tbt_facebook")
local tbt_twitter = require("tbt_twitter")
local tbt_reminder = require("tbt_reminder")
local tbt_doubletap = require("tbt_doubletap")
local fbButton5
local title

title = display.newText( "#TBT", 0, 0, native.systemFont, 36 )
title:setFillColor( .8, .4,.1 )  -- black
title.x = display.contentWidth * 0.5
title.y = 25

local scene = composer.newScene()

local facebookText = tbt_facebook.init({
   fontSize = 20,
   font = "Helvetica",
   x = display.contentCenterX,
   y = 20,
   maxDigits = 7,
   leadingZeros = true,
   filename = "facebook.txt",
})

local twitterText = tbt_twitter.init({
   fontSize = 20,
   font = "Helvetica",
   x = display.contentCenterX,
   y = 20,
   maxDigits = 7,
   leadingZeros = true,
   filename = "twitter.txt",
})

local doubleTapText = tbt_doubletap.init({
   fontSize = 20,
   font = "Helvetica",
   x = display.contentCenterX,
   y = 20,
   maxDigits = 7,
   leadingZeros = true,
   filename = "doubletap.txt",
})

local reminderText = tbt_reminder.init({
   fontSize = 20,
   font = "Helvetica",
   x = display.contentCenterX,
   y = 20,
   maxDigits = 7,
   leadingZeros = true,
   filename = "reminder.txt",
})

local function logOut_onRelease( event )
      -- call the login method of the FB session object, passing in a handler
      -- to be called upon successful login.
      --fbCommand = LOGOUT
      --facebook.logout()
      title.text = ""
      fbButton5.isVisible = false
      composer.gotoScene( "menu", "fade", 400 )

end

--native.setProperty( "applicationIconBadgeNumber", 0 )

composer.gotoScene( "menu" , "fade", 400)
title.text = ""

 --  fbButton5 = widget.newButton
 --  {
 --     defaultFile = "fbButtonL184.png",
 --     overFile = "fbButtonOverL184.png",
 --     label = "Login to FB",
 --     labelColor = 
 --     { 
 --        default = { 255, 255, 255 }, 
 --     },
 --     onRelease = logOut_onRelease,
 --  }
 --  fbButton5.x = 160
 --  fbButton5.y = 422




