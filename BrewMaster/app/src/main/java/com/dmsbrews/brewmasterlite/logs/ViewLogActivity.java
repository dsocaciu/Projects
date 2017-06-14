package com.dmsbrews.brewmasterlite.logs;


import com.dmsbrews.brewmasterlite.*;

import android.app.Activity;
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

public class ViewLogActivity extends Activity {
	
    protected Spinner brewSpinner;
    protected BrewSessionData brewData;
    protected TextView brewView;

    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logview);
        
        brewData = new BrewSessionData(this);
        brewSpinner = (Spinner) findViewById(R.id.brew_spinner);
        brewView = (TextView) findViewById(R.id.brew_view);
        
        
        //for testing
        if(brewData.count() == 0)
        {
        	//public long insert(String name, String brewDate, String brewType, 
        	//String brewApe, String brewOg, String brewFg )
        	brewData.insert("Brew1", "1/7", "Light Lager","Extract","1.040","1.010");
        	//brewData.insert("Brew2", "5/23", "Stout","All Grain","1.056","1.024");
        }
        
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
				
				//System.out.println(cursor1.getColumnCount());
				
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
				
				if(cursor1.getString(5)!=null &&  cursor1.getString(5)!="" && cursor1.getString(5)!=" " )
				{
					OG  = "1." + cursor1.getString(5);
				}
				else
				{
					OG = "";
				}
				
				if(cursor1.getString(6)!=null && cursor1.getString(6)!="" && cursor1.getString(6)!=" ")
				{
					FG = "1." + cursor1.getString(6);
				}
				else
				{
					FG = "";
				}
				
//				brewView.setText("0: " + cursor1.getString(0) 
//						+ "\n1: " + cursor1.getString(1)
//						+ "\n2: " + cursor1.getString(2) 
//						+ "\n3: " + cursor1.getString(3)
//						+ "\n4: " + cursor1.getString(4)
//						+ "\n5: " + cursor1.getString(5)
//						+ "\n6: " + cursor1.getString(6));
				
				brewView.setText("Brew Date: " + cursor1.getString(2) 
								+ "\nBrew Style: " + cursor1.getString(3)
								+ "\nBrew Type: " + brewType 
								+ "\nStarting Gravity: " + OG
								+ "\nFinal Gravity: " + FG);
				
				brewData.close();
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

    }
	

}
