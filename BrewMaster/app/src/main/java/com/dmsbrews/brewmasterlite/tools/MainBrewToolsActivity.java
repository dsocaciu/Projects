package com.dmsbrews.brewmasterlite.tools;


import com.dmsbrews.brewmasterlite.R;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;


public class MainBrewToolsActivity extends Activity {
    /** Called when the activity is first created. */
	
	private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brewtools);
        
        adView = new AdView(this, AdSize.BANNER, "removed");
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.brewtools);
        
        layout.addView(adView);
        adView.setGravity(Gravity.BOTTOM);
        
        adView.loadAd(new AdRequest());
        
 /*       Button timer = (Button) findViewById(R.id.brew_timer);
        timer.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), TimerActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});*/
        
        Button abv_calculator = (Button) findViewById(R.id.abv_calc);
        abv_calculator.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), ABVActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button strike_calculator = (Button) findViewById(R.id.strike_temp);
        strike_calculator.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), StrikeActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button checklist = (Button) findViewById(R.id.checklist);
        checklist.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), ChecklistActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button mainButton = (Button) findViewById(R.id.main_menu);
        mainButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});

    }
}
