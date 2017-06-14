package com.dmsbrews.brewmasterlite.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

import com.dmsbrews.brewmasterlite.R;



public class ABVActivity extends Activity {
	
	protected TextView abvResult;
	
	double og;
	double fg;
	
	double abv;
	
	DecimalFormat abvFormat = new DecimalFormat("0.0");
	
		
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abv);
        
        abvResult = (TextView) findViewById(R.id.resultLabel);
        
        final EditText ogField = (EditText)findViewById(R.id.og_field);
        final EditText fgField = (EditText)findViewById(R.id.fg_field);

        
        
        
        Button calculate = (Button) findViewById(R.id.abv_calc);
        calculate.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				if(!ogField.getText().toString().matches(""))
		        {
		        	og = Double.parseDouble(ogField.getText().toString());
		        	og = 1 + og/1000;
		        }
		        else
		        {
		        	abvResult.setText("Enter in OG");
		        	return;
		        }
		        
		        if(!fgField.getText().toString().matches(""))
		        {
		        	fg = Double.parseDouble(fgField.getText().toString());
		        	fg = 1 + fg/1000;
		        }
		        else
		        {
		        	abvResult.setText("Enter in FG");
		        	return;
		        }
		        
		        abv = (76.08 * (og-fg) / (1.775-og)) * (fg / 0.794);
		        String abvDisplay  = abvFormat.format(abv);
		        
				abvResult.setText(abvDisplay + "% ABV");
			}
		});
        
        
        Button mainButton = (Button) findViewById(R.id.brew_calc);
        mainButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});
        
        
    }

}
