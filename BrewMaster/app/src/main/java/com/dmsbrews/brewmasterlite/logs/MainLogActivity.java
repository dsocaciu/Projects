package com.dmsbrews.brewmasterlite.logs;



import com.dmsbrews.brewmasterlite.R;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainLogActivity extends Activity {
    /** Called when the activity is first created. */
	
	private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
        
        adView = new AdView(this, AdSize.BANNER, "removed");
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.brewlogs);
        
        layout.addView(adView);
        adView.setGravity(Gravity.BOTTOM);
        
        adView.loadAd(new AdRequest());
        
        Button addButton = (Button) findViewById(R.id.add_log);
        addButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), AddLogActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button viewButton = (Button) findViewById(R.id.view_log);
        viewButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), ViewLogActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button editButton = (Button) findViewById(R.id.edit_log);
        editButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), EditLogActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button deleteButton = (Button) findViewById(R.id.delete_log);
        deleteButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), DeleteLogActivity.class ); 
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
