package com.dmsbrews.brewmasterlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dmsbrews.brewmasterlite.categories.MainCategoryActivity;
import com.dmsbrews.brewmasterlite.logs.MainLogActivity;
import com.dmsbrews.brewmasterlite.reviews.MainReviewActivity;
import com.dmsbrews.brewmasterlite.tools.MainBrewToolsActivity;
//import com.google.ads.AdRequest;
//import com.google.ads.AdSize;
//import com.google.ads.AdView;
//import com.google.android.gms.ads.AdActivity;


public class BrewMasterActivity extends Activity {
	
	//private AdView adView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brewmaster);
        
        //adView = new AdView(this, AdSize.BANNER, "a1509d069c7516b");
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.brewmaster);
        
       // layout.addView(adView);
       // adView.setGravity(Gravity.BOTTOM);
        
       // adView.loadAd(new AdRequest());
        
        Button calculator = (Button) findViewById(R.id.brew_calc);
        calculator.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MainBrewToolsActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button logs = (Button) findViewById(R.id.brew_log);
        logs.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MainLogActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button category = (Button) findViewById(R.id.brew_category);
        category.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MainCategoryActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});
        
        Button review = (Button) findViewById(R.id.brew_review);
        review.setOnClickListener( new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MainReviewActivity.class ); 
				startActivityForResult(myIntent,0);
				
			}
		});


    }
    
    @Override
    public void onDestroy() {
     // if (adView != null) {
     //   adView.destroy();
     // }
      super.onDestroy();
    }
    
}