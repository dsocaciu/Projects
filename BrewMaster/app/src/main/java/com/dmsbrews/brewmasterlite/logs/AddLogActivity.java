package com.dmsbrews.brewmasterlite.logs;

import com.dmsbrews.brewmasterlite.BrewSessionData;
import com.dmsbrews.brewmasterlite.R;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class AddLogActivity extends Activity {
    /** Called when the activity is first created. */
	
	final Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logadd);
        


    	final BrewSessionData brewData;
    	
    	final EditText brewNameField = (EditText)findViewById(R.id.brewname_field);
    	final EditText brewDateField = (EditText)findViewById(R.id.brewdate_field);
    	
    	final Spinner spinner = (Spinner) findViewById(R.id.brewtype_field);
    	final Spinner brewApeField = (Spinner)findViewById(R.id.brewape_field);
        
    	final EditText brewOG = (EditText)findViewById(R.id.og_field);
    	final EditText brewFG = (EditText)findViewById(R.id.fg_field);
    	
        //final AlertDialog.Builder successAlert=new AlertDialog.Builder(this);
        //successAlert.setTitle("New Brew Logs");
        //successAlert.setMessage("Session added successfully");
        //successAlert.setIcon(android.R.drawable.ic_dialog_alert);
        
         brewData = new BrewSessionData(this);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.beer_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.brew_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brewApeField.setAdapter(adapter1);
        
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}

        });
        
        
        
        
        Button addButton = (Button) findViewById(R.id.add_log);
        addButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {


				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setTitle("Add Brew Log");
				if(brewData.insert(brewNameField.getText().toString(), brewDateField.getText().toString(),spinner.getSelectedItem().toString(),
						brewApeField.getSelectedItem().toString(), brewOG.getText().toString(), brewFG.getText().toString())!=-1)
				{
					alertDialogBuilder.setMessage("New Log Added");
						
				}
				else
				{
					alertDialogBuilder.setMessage("Error Adding Log");
				}
				
				alertDialogBuilder.setCancelable(false);
				alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						brewData.close();
						AddLogActivity.this.finish();
						
					}
				});
				
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
				
				//	successAlert.show();
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
