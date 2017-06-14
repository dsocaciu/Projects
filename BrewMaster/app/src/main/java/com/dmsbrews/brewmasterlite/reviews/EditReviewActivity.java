package com.dmsbrews.brewmasterlite.reviews;

import com.dmsbrews.brewmasterlite.BrewReviewData;
import com.dmsbrews.brewmasterlite.BrewSessionData;
import com.dmsbrews.brewmasterlite.R;

import com.dmsbrews.brewmasterlite.logs.EditLogActivity;

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
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EditReviewActivity extends Activity {
	
	protected Spinner spinner;
	final Context context = this;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewedit);
        
        
        
        
        spinner = (Spinner) findViewById(R.id.previous_brew);
        
        final BrewReviewData reviewData;
        final EditText nameField = (EditText) findViewById(R.id.name_field);
        final EditText appearanceField = (EditText) findViewById(R.id.appearance_field);
        final EditText smellField = (EditText) findViewById(R.id.smell_field);
        final EditText tasteField = (EditText) findViewById(R.id.taste_field);
        final EditText mouthField = (EditText) findViewById(R.id.mouth_field);
        final EditText overallField = (EditText) findViewById(R.id.overall_field);
        final RatingBar overallRating = (RatingBar) findViewById(R.id.ratingBar1);
        
        reviewData = new BrewReviewData(this);
        
        
        Cursor cursor = reviewData.all(this);
        
        SimpleCursorAdapter reviewCursorAdapter = new SimpleCursorAdapter(this,
        		android.R.layout.simple_spinner_item,
        		cursor, 
        		new String[] {BrewReviewData.NAME},
        		new int[] {android.R.id.text1}
        	);
        
        spinner.setAdapter(reviewCursorAdapter);
        reviewCursorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				Cursor cursor = (Cursor) spinner.getSelectedItem();
				
				nameField.setText(cursor.getString(1));
		        appearanceField.setText(cursor.getString(2));
		        smellField.setText(cursor.getString(3));
		        tasteField.setText(cursor.getString(4));
		        mouthField.setText(cursor.getString(5));
		        overallField.setText(cursor.getString(6));
		        overallRating.setRating(Float.parseFloat(cursor.getString(7)));
		        //TODO populate Spinner 
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				

			}

        });
        
        Button addButton = (Button) findViewById(R.id.add_review);
        addButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setTitle("Update Brew Log");
				Cursor cursor = (Cursor) spinner.getSelectedItem();
				if(reviewData.update(cursor.getInt(0),nameField.getText().toString(), appearanceField.getText().toString(), smellField.getText().toString(), 
						tasteField.getText().toString(), mouthField.getText().toString(), overallField.getText().toString(), overallRating.getRating())==1)
				{
					alertDialogBuilder.setMessage("Review Updated Successfully");
						
				}
				else
				{
					alertDialogBuilder.setMessage("Error Updating Review");
				}
				
				alertDialogBuilder.setCancelable(false);
				alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						EditReviewActivity.this.finish();
						
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
