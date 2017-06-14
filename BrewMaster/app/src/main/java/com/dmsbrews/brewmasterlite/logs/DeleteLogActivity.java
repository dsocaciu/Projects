package com.dmsbrews.brewmasterlite.logs;


import com.dmsbrews.brewmasterlite.*;

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

public class DeleteLogActivity extends Activity {
	
	final Context context = this;
	
    protected Spinner brewSpinner;
    protected BrewSessionData brewData;
    protected TextView brewView;
    protected int deleteId;

    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logdelete);
        
        brewData = new BrewSessionData(this);
        brewSpinner = (Spinner) findViewById(R.id.previous_brew);
        brewView = (TextView) findViewById(R.id.brew_view);
        
        
        
   
        Cursor cursor = brewData.all(this);
        
        SimpleCursorAdapter brewCursorAdapter = new SimpleCursorAdapter(this,
        		android.R.layout.simple_spinner_item,
        		cursor, 
        		new String[] {BrewSessionData.NAME},
        		new int[] {android.R.id.text1}
        	);
        
        brewSpinner.setAdapter(brewCursorAdapter);
        brewCursorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        brewSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				Cursor cursor1 = (Cursor) brewSpinner.getSelectedItem();
				
				deleteId = cursor1.getInt(0);
				
				String brewType;
				String OG;
				String FG;
				if(cursor1.getString(4)!=null)
				{
					brewType = cursor1.getString(4);
				}
				else
				{
					brewType ="";
				}
				
				if(cursor1.getString(5)!=null)
				{
					OG  = "1." + cursor1.getString(5);
				}
				else
				{
					OG = "";
				}
				
				if(cursor1.getString(6)!=null)
				{
					FG = "1." + cursor1.getString(6);
				}
				else
				{
					FG = "";
				}
				
				brewView.setText("Brew Date: " + cursor1.getString(2) 
						+ "\nBrew Style: " + cursor1.getString(3)
						+ "\nBrew Type: " + brewType 
						+ "\nStarting Gravity: " + OG
						+ "\nFinal Gravity: " + FG);
				
			
				
		}

			public void onNothingSelected(AdapterView<?> arg0) {


			}

        });
        
    	
    	
        Button deleteButton = (Button) findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setTitle("Delete Brew Log");
				if(brewData.deleteLog(deleteId)==1)
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
						brewData.close();
						DeleteLogActivity.this.finish();
						
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
