package com.dmsbrews.brewmasterlite.reviews;


import com.dmsbrews.brewmasterlite.R;
import com.dmsbrews.brewmasterlite.logs.AddLogActivity;
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

public class MainReviewActivity extends Activity {
    /** Called when the activity is first created. */
	
	private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        
        adView = new AdView(this, AdSize.BANNER, "removed");
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.reviewmain);
        
        layout.addView(adView);
        adView.setGravity(Gravity.BOTTOM);
        
        adView.loadAd(new AdRequest());
        
        Button addButton = (Button) findViewById(R.id.add_review);
        addButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), AddReviewActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button viewButton = (Button) findViewById(R.id.view_review);
        viewButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), ViewReviewActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button editButton = (Button) findViewById(R.id.edit_review);
        editButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), EditReviewActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button deleteButton = (Button) findViewById(R.id.delete_review);
        deleteButton.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), DeleteReviewActivity.class ); 
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
