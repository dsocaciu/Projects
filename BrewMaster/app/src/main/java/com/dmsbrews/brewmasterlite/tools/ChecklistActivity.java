package com.dmsbrews.brewmasterlite.tools;


import com.dmsbrews.brewmasterlite.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ChecklistActivity extends Activity {
	
	protected LinearLayout allGrain;
	protected LinearLayout extract;
	protected LinearLayout partialMash;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist);
        
        allGrain = (LinearLayout) findViewById(R.id.allgrain_layout);
        //pauseLine.setVisibility(View.GONE);
        allGrain.setVisibility(View.GONE);
        
        extract = (LinearLayout) findViewById(R.id.extract_layout);
        extract.setVisibility(View.GONE);
        
        partialMash = (LinearLayout) findViewById(R.id.partial_layout);
        partialMash.setVisibility(View.GONE);
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.brew_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if ( arg2 == 0)
				{
					allGrain.setVisibility(View.VISIBLE);
					extract.setVisibility(View.GONE);
					partialMash.setVisibility(View.GONE);
					
				}
				else if (arg2 == 1)
				{
					allGrain.setVisibility(View.GONE);
					extract.setVisibility(View.VISIBLE);
					partialMash.setVisibility(View.GONE);
				}
				else
				{
					allGrain.setVisibility(View.GONE);
					extract.setVisibility(View.GONE);
					partialMash.setVisibility(View.VISIBLE);
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				allGrain.setVisibility(View.GONE);
				extract.setVisibility(View.GONE);
				partialMash.setVisibility(View.GONE);
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
