package com.dmsbrews.brewmasterlite.reviews;


import com.dmsbrews.brewmasterlite.*;
import com.dmsbrews.brewmasterlite.logs.DeleteLogActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class DeleteReviewActivity extends Activity {
	
    protected Spinner reviewSpinner;
    protected BrewReviewData reviewData;
    protected TextView reviewView;
    
    protected int deleteId;

    final Context context = this;
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewdelete);
        
        reviewData = new BrewReviewData(this);
        reviewSpinner = (Spinner) findViewById(R.id.review_spinner);
        reviewView = (TextView) findViewById(R.id.review_view);
        
        
        //for testing
        if(reviewData.count() == 0)
        {
        	reviewData.insert("Harpoon Summer Beer", "Bright Golden Color", "Citrus/Wheat","Citrus","Light bodied, smooth","Fantastic summer beer",(float)9.5);
        	
        }
        
        Cursor cursor = reviewData.all(this);
        
        SimpleCursorAdapter brewCursorAdapter = new SimpleCursorAdapter(this,
        		android.R.layout.simple_spinner_item,
        		cursor, 
        		new String[] {BrewReviewData.NAME},
        		new int[] {android.R.id.text1}
        	);
        
        reviewSpinner.setAdapter(brewCursorAdapter);
        brewCursorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        reviewSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				Cursor cursor = (Cursor) reviewSpinner.getSelectedItem();
				
				
				reviewView.setText("Appearance: " + cursor.getString(2) + " \nSmell: " + cursor.getString(3) + 
								   " \nTaste: " + cursor.getString(4) + " \nMouthfeel: " + cursor.getString(5) +
								   " \nOverall: " + cursor.getString(6) + " \nRating: " + cursor.getString(7));
				
				deleteId = cursor.getInt(0);
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {


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
        
        Button deleteButton = (Button) findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setTitle("Delete Brew Log");
				if(reviewData.deleteReview(deleteId)==1)
				{
					alertDialogBuilder.setMessage("Delete Log Successful");
						
				}
				else
				{
					alertDialogBuilder.setMessage("Error Deleting Log");
				}
				
				alertDialogBuilder.setCancelable(false);
				alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						DeleteReviewActivity.this.finish();
						
					}
				});
				
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
		});

    }
	

}
