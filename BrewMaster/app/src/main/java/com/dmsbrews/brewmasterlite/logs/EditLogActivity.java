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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EditLogActivity extends Activity {
	
    protected Spinner spinner;
    protected Spinner brewSpinner;
    protected Spinner apeSpinner;
    protected BrewSessionData brewData;
    protected LinearLayout brewNameLayout;
    protected LinearLayout brewDateLayout;
    protected LinearLayout brewTypeLayout;
    protected LinearLayout editButtonLayout;
    
    final Context context = this;
    
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logedit);
        
    	//final EditText brewNameField = (EditText)findViewById(R.id.brewname_field);
    	final EditText brewDateField = (EditText)findViewById(R.id.brewdate_field);
    	final EditText brewOgField = (EditText)findViewById(R.id.brewog_field);
    	final EditText brewFgField = (EditText)findViewById(R.id.brewfg_field);
        
        brewData = new BrewSessionData(this);
        spinner = (Spinner) findViewById(R.id.brewtype_field);
        apeSpinner = (Spinner) findViewById(R.id.brewape_field);
        brewSpinner = (Spinner) findViewById(R.id.previous_brew);
        
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
				
				Cursor cursor = (Cursor) brewSpinner.getSelectedItem();
				
				//brewNameField.setText(cursor.getString(1));
		        brewDateField.setText(cursor.getString(2));
		        
		        String typeString = cursor.getString(3); //the value you want the position for
		        ArrayAdapter myAdap = (ArrayAdapter) spinner.getAdapter(); //cast to an ArrayAdapter
		        int spinnerPosition = myAdap.getPosition(typeString);
		        //set the default according to value
		        spinner.setSelection(spinnerPosition);
		        
		        System.out.println(cursor.getString(4));
		        String styleString = cursor.getString(4); //the value you want the position for
		        ArrayAdapter myAdap1 = (ArrayAdapter) apeSpinner.getAdapter(); //cast to an ArrayAdapter
		        int apeSpinnerPosition = myAdap1.getPosition(styleString);
		        //set the default according to value
		        apeSpinner.setSelection(apeSpinnerPosition);
		        
		        brewOgField.setText(cursor.getString(5));
		        brewFgField.setText(cursor.getString(6)); 
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				

			}

        });
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.beer_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.brew_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        apeSpinner.setAdapter(adapter1);
        
        
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}

        });
        
        Button addButton = (Button) findViewById(R.id.add_log);
        addButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view){
					
					Cursor cursor = (Cursor) brewSpinner.getSelectedItem();
					
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
					alertDialogBuilder.setTitle("Update Brew Log");
					if(brewData.update(cursor.getInt(0), cursor.getString(1), brewDateField.getText().toString(),spinner.getSelectedItem().toString(),apeSpinner.getSelectedItem().toString(),brewOgField.getText().toString(),brewFgField.getText().toString())==1)
					{
						alertDialogBuilder.setMessage("Log Updated Successfully");
							
					}
					else
					{
						alertDialogBuilder.setMessage("Error Updating Log");
					}
					
					alertDialogBuilder.setCancelable(false);
					alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							brewData.close();
							EditLogActivity.this.finish();
							
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
