package com.dmsbrews.brewmasterlite.tools;



import com.dmsbrews.brewmasterlite.R;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



public class TimerActivity extends Activity implements OnClickListener{
	
	protected Button startTimer;
	protected Button resumeTimer;
	protected Button pauseTimer;
	
	protected TextView brewTimeLabel;
	protected LinearLayout inputField;
	protected LinearLayout pauseLine;
	protected LinearLayout remainingInfo;
	
	protected Integer brewTime = 60; //default brew time 
	protected CountDownTimer brewCountDownTimer;
	protected boolean isBrewing = false;
	

	protected long milli;
	
	//Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
	//Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        final EditText additions = new EditText(this);
    	additions.setInputType(2); //TYPE_CLASS_NUMBER;
    	
        
        brewTimeLabel = (TextView) findViewById(R.id.brew_time);
        
        inputField = (LinearLayout) findViewById(R.id.input_field);
        pauseLine = (LinearLayout) findViewById(R.id.pause_line);
        remainingInfo = (LinearLayout) findViewById(R.id.remaining_line);
        
        pauseLine.setVisibility(View.GONE);
        remainingInfo.setVisibility(View.GONE);
        


        Button mainButton = (Button) findViewById(R.id.brew_calc);
        mainButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});
        
        startTimer = (Button) findViewById(R.id.brew_start);
        startTimer.setOnClickListener(this);
        
        resumeTimer = (Button) findViewById(R.id.brew_resume);
        resumeTimer.setOnClickListener(this);
        
        pauseTimer = (Button) findViewById(R.id.brew_pause);
        pauseTimer.setOnClickListener(this);

    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if ( v == startTimer)
		{
			if(isBrewing)
			{
				stopBrew();
			}
			else
				startBrew();
		}
		else if( v == resumeTimer)
		{
			resumeBrew();
		}
		else if (v == pauseTimer){
			try {
				pauseBrew();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
	  /**
	* Start the brew timer
	*/
	  public void startBrew() {
	    // Create a new CountDownTimer to track the brew time
		  TextView brew =  (TextView) findViewById(R.id.timer_status);
		  try {
			    brewTime = Integer.parseInt(brew.getText().toString()); 
			    //brewTime = Integer.parseInt((String)brew.getText());
			    
			} catch(NumberFormatException nfe) {
			   System.out.println("Could not parse " + nfe);
		  } 
			
		  inputField.setVisibility(View.GONE);
		  pauseLine.setVisibility(View.VISIBLE);
		  remainingInfo.setVisibility(View.VISIBLE);
		 
		  brewCountDownTimer = new CountDownTimer(brewTime * 60 * 1000, 1000) {
	      @Override
	      public void onTick(long millisUntilFinished) {
	    	  milli = millisUntilFinished;
	    	  long hours = millisUntilFinished / 3600 / 1000;
	    	  long minutes = millisUntilFinished  / 60 / 1000;
	    	  long seconds = (millisUntilFinished / 1000) % 60;
	    	  
	    	  String hourString = String.valueOf(hours);
	    	  String minuteString = String.valueOf(minutes);
	    	  String secondString = String.valueOf(seconds); 
	    	  
	    	  if(minutes < 10)
	    	  {
	    		  minuteString = "0"+ minuteString;
	    	  }
	    	  if(seconds < 10)
	    	  {
	    		  secondString = "0"+ secondString;
	    	  }
	    	  
	    	  
    		  brewTimeLabel.setText(hourString+":"+minuteString+":"+secondString);
	      }
	      

	      
	      @Override
	      public void onFinish() {
	        isBrewing = false;
	        
	        brewTimeLabel.setText("Brew Up!");
	        startTimer.setText("Start");
	      }
	    };
	    
	    brewCountDownTimer.start();
	    startTimer.setText("Stop");
	    isBrewing = true;
	  }
	  
      public void resumeBrew(){
    	  
    	  inputField.setVisibility(View.GONE);
    	  resumeTimer.setVisibility(View.GONE);
    	  pauseTimer.setVisibility(View.VISIBLE);
		  pauseLine.setVisibility(View.VISIBLE);
		  remainingInfo.setVisibility(View.VISIBLE);
		 
		  brewCountDownTimer = new CountDownTimer(milli, 1000) {
	      @Override
	      public void onTick(long millisUntilFinished) {
	    	  milli = millisUntilFinished;
	    	  long hours = millisUntilFinished / 3600 / 1000;
	    	  long minutes = millisUntilFinished  / 60 / 1000;
	    	  long seconds = (millisUntilFinished / 1000) % 60;
	    	  
	    	  String hourString = String.valueOf(hours);
	    	  String minuteString = String.valueOf(minutes);
	    	  String secondString = String.valueOf(seconds); 
	    	  
	    	  if(minutes < 10)
	    	  {
	    		  minuteString = "0"+ minuteString;
	    	  }
	    	  if(seconds < 10)
	    	  {
	    		  secondString = "0"+ secondString;
	    	  }
	    	  
	    	  
    		  brewTimeLabel.setText(hourString+":"+minuteString+":"+secondString);
	      }

		@Override
	      public void onFinish() {
	        isBrewing = false;
	        
	        brewTimeLabel.setText("Brew Up!");
	        startTimer.setText("Start");
	        
	       // r.play();
	      }
	      };
      }
	  
	  /**
	* Stop the brew timer
	*/
	  public void stopBrew() {
	    if(brewCountDownTimer != null)
	      brewCountDownTimer.cancel();
	    
	    isBrewing = false;
	    startTimer.setText("Start");
	    inputField.setVisibility(View.VISIBLE);
	    pauseLine.setVisibility(View.GONE);
	    remainingInfo.setVisibility(View.GONE);
	  }
	  
	  public void pauseBrew() throws InterruptedException{
		  if(brewCountDownTimer != null)
		      brewCountDownTimer.cancel();
		  
		 // brewTimeLabel.setText(hours+":"+minuteString+":"+secondString);
		  
		    inputField.setVisibility(View.GONE);
		    resumeTimer.setVisibility(View.VISIBLE);
		    pauseTimer.setVisibility(View.GONE);
		    pauseLine.setVisibility(View.VISIBLE);
		    
		    remainingInfo.setVisibility(View.VISIBLE);
		  
		  
	  }
	
	public void setBrewTime (int minutes){
		if(isBrewing)
			return;
		
		brewTime = minutes;
		
		if(brewTime < 1)
			brewTime = 1;
		
		brewTimeLabel.setText(String.valueOf(brewTime)+ " min");
	}
}