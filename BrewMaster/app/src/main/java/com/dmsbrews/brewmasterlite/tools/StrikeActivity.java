package com.dmsbrews.brewmasterlite.tools;

import java.text.DecimalFormat;

import com.dmsbrews.brewmasterlite.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StrikeActivity extends Activity{
	
	double batch;
    double grain;
    double thick;
    double grainTemp;
    double target;
    
    protected TextView strikeResult;
    
    DecimalFormat mashFormat = new DecimalFormat("0.00");
    DecimalFormat strikeFormat = new DecimalFormat("0.0");
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strike);
        
        strikeResult = (TextView) findViewById(R.id.resultLabel);        
        
 //       final EditText batchField = (EditText)findViewById(R.id.batch_field);
        final EditText grainField = (EditText)findViewById(R.id.grain_field);
        final EditText thickField = (EditText)findViewById(R.id.thick_field);
        final EditText grainTempField = (EditText)findViewById(R.id.graintemp_field);
        final EditText targetField = (EditText)findViewById(R.id.target_field);        
        
        
        Button calculateButton = (Button) findViewById(R.id.strike_calc);
        calculateButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				if(!batchField.getText().toString().equals(null))
//				{
//					
//					batch = Double.parseDouble(batchField.getText().toString());
//				}
				if(!grainField.getText().toString().equals(""))
				{
					//B4
					grain = Double.parseDouble(grainField.getText().toString());
				}
				else
		        {
					strikeResult.setText("Enter in Grain lbs.");
		        	return;
		        }
				if(!thickField.getText().toString().equals(""))
				{
					thick = Double.parseDouble(thickField.getText().toString());
				}
				else
		        {
					strikeResult.setText("Enter in Thickness.");
		        	return;
		        }
				if(!grainTempField.getText().toString().equals(""))
				{
					//B6
					grainTemp = Double.parseDouble(grainTempField.getText().toString());
				}
				else
		        {
					strikeResult.setText("Enter in Grain Temp.");
		        	return;
		        }
				if(!targetField.getText().toString().equals(""))
				{
					//B7
					target = Double.parseDouble(targetField.getText().toString());
				}
				else
		        {
					strikeResult.setText("Enter in Target Strike.");
		        	return;
		        }
				
				//B12				
				double mashVol = (thick*grain)/4;
				//double strike1 = (((grain*0.05)+mashVol)*target);
				//double strike2 = (((grain*0.05)*grainTemp)/mashVol);
				double strikeTemp =   ((((grain*0.05)+mashVol)*target)-((grain*0.05)*grainTemp))/mashVol;
        		//double strike = (((grain*0.05)+mashVol)*target)-((grain*0.05)*grainTemp);
				
				String mashDisplay  = mashFormat.format(mashVol);
				String strikeDisplay  = strikeFormat.format(strikeTemp);
				
				//String strike1String = strikeFormat.format(strike1);
				//String strike2String = strikeFormat.format(strike2);
				
				
				
				strikeResult.setText("Mash Vol: " + mashDisplay + "\nStrike Temp: " + strikeDisplay + " F");
				//strikeResult.setText("Strike Temp: " + strikeDisplay + " F");
								
				
			}
		});
        
        
        Button mainButton = (Button) findViewById(R.id.brew_calc);
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
