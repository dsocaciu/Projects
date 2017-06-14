package com.dmsbrews.brewmasterlite.reviews;

import com.dmsbrews.brewmasterlite.BrewReviewData;
import com.dmsbrews.brewmasterlite.R;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class AddReviewActivity extends Activity {
	
	final Context context = this;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewadd);
        
        
        final BrewReviewData reviewData;
        
        final EditText nameField = (EditText) findViewById(R.id.name_field);
        final EditText appearanceField = (EditText) findViewById(R.id.appearance_field);
        final EditText smellField = (EditText) findViewById(R.id.smell_field);
        final EditText tasteField = (EditText) findViewById(R.id.taste_field);
        final EditText mouthField = (EditText) findViewById(R.id.mouth_field);
        final EditText overallField = (EditText) findViewById(R.id.overall_field);
        
        final RatingBar overallRating = (RatingBar) findViewById(R.id.ratingBar1);
        
        reviewData = new BrewReviewData(this);
        
        Button addButton = (Button) findViewById(R.id.add_review);
        addButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setTitle("Add Beer Review");
				if(reviewData.insert(nameField.getText().toString(), appearanceField.getText().toString(), smellField.getText().toString(), 
						tasteField.getText().toString(), mouthField.getText().toString(), overallField.getText().toString(), overallRating.getRating())!=-1)
				{
					alertDialogBuilder.setMessage("Add Review Successful");
						
				}
				else
				{
					alertDialogBuilder.setMessage("Error Add Review");
				}
				
				alertDialogBuilder.setCancelable(false);
				alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						AddReviewActivity.this.finish();
						
					}
				});
				
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
		});
        
        
        Button mainButton = (Button) findViewById(R.id.main_menu);
        mainButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});
        
	}
}
