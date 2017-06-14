package com.dmsbrews.brewmasterlite.categories;



import com.dmsbrews.brewmasterlite.R;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainCategoryActivity extends  Activity {
    /** Called when the activity is first created. */
	
	
	private AdView adView;
    // All static variables
    static final String URL = "www.bjcp.org/styles04/xml/styleguide.xml";
    
    private BeerExpandAdapter Adapter1;
    private ArrayList<BeerGroup> List1Items;
    private ExpandableListView List1;
        
    private BeerExpandAdapter Adapter2;
    private ArrayList<BeerGroup> List2Items;
    private ExpandableListView List2;
    
    private BeerExpandAdapter Adapter3;
    private ArrayList<BeerGroup> List3Items;
    private ExpandableListView List3;
    
    private BeerExpandAdapter Adapter4;
    private ArrayList<BeerGroup> List4Items;
    private ExpandableListView List4;
    
    private BeerExpandAdapter Adapter5;
    private ArrayList<BeerGroup> List5Items;
    private ExpandableListView List5;
    
    private BeerExpandAdapter Adapter6;
    private ArrayList<BeerGroup> List6Items;
    private ExpandableListView List6;
    
    private BeerExpandAdapter Adapter7;
    private ArrayList<BeerGroup> List7Items;
    private ExpandableListView List7;
    
    private BeerExpandAdapter Adapter8;
    private ArrayList<BeerGroup> List8Items;
    private ExpandableListView List8;
    
    private BeerExpandAdapter Adapter9;
    private ArrayList<BeerGroup> List9Items;
    private ExpandableListView List9;
    
    private BeerExpandAdapter Adapter10;
    private ArrayList<BeerGroup> List10Items;
    private ExpandableListView List10;
    
    
    private BeerExpandAdapter Adapter11;
    private ArrayList<BeerGroup> List11Items;
    private ExpandableListView List11;
    
    private BeerExpandAdapter Adapter12;
    private ArrayList<BeerGroup> List12Items;
    private ExpandableListView List12;
    
    private BeerExpandAdapter Adapter13;
    private ArrayList<BeerGroup> List13Items;
    private ExpandableListView List13;
    
    private BeerExpandAdapter Adapter14;
    private ArrayList<BeerGroup> List14Items;
    private ExpandableListView List14;
    
    private BeerExpandAdapter Adapter15;
    private ArrayList<BeerGroup> List15Items;
    private ExpandableListView List15;
    
    private BeerExpandAdapter Adapter16;
    private ArrayList<BeerGroup> List16Items;
    private ExpandableListView List16;
    
    private BeerExpandAdapter Adapter17;
    private ArrayList<BeerGroup> List17Items;
    private ExpandableListView List17;
    
    private BeerExpandAdapter Adapter18;
    private ArrayList<BeerGroup> List18Items;
    private ExpandableListView List18;
    
    private BeerExpandAdapter Adapter19;
    private ArrayList<BeerGroup> List19Items;
    private ExpandableListView List19;
    
    private BeerExpandAdapter Adapter20;
    private ArrayList<BeerGroup> List20Items;
    private ExpandableListView List20;
    
    private BeerExpandAdapter Adapter21;
    private ArrayList<BeerGroup> List21Items;
    private ExpandableListView List21;
    
    private BeerExpandAdapter Adapter22;
    private ArrayList<BeerGroup> List22Items;
    private ExpandableListView List22;    
    
    private BeerExpandAdapter Adapter23;
    private ArrayList<BeerGroup> List23Items;
    private ExpandableListView List23;
    
    
    protected LinearLayout category1;
	protected LinearLayout category2;
	protected LinearLayout category3;
	protected LinearLayout category4;
	protected LinearLayout category5;
	protected LinearLayout category6;
	protected LinearLayout category7;
	protected LinearLayout category8;
	protected LinearLayout category9;
	protected LinearLayout category10;
	protected LinearLayout category11;
	protected LinearLayout category12;
	protected LinearLayout category13;
	protected LinearLayout category14;
	protected LinearLayout category15;
	protected LinearLayout category16;
	protected LinearLayout category17;
	protected LinearLayout category18;
	protected LinearLayout category19;
	protected LinearLayout category20;
	protected LinearLayout category21;
	protected LinearLayout category22;
	protected LinearLayout category23;
	

	
	

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        
        adView = new AdView(this, AdSize.BANNER, "removed");
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.categorymain);
        
        layout.addView(adView);
        adView.setGravity(Gravity.BOTTOM);
        
        adView.loadAd(new AdRequest());
        
        List1 = (ExpandableListView) findViewById(R.id.expand1);
        List1Items = Group1();
        Adapter1 = new BeerExpandAdapter(MainCategoryActivity.this, List1Items);
       	List1.setAdapter(Adapter1);
       	
       	List2 = (ExpandableListView) findViewById(R.id.expand2);
       	List2Items = Group2();
       	Adapter2 = new BeerExpandAdapter(MainCategoryActivity.this,List2Items);
       	List2.setAdapter(Adapter2);
       	
       	List3 = (ExpandableListView) findViewById(R.id.expand3);
       	List3Items = Group3();
       	Adapter3 = new BeerExpandAdapter(MainCategoryActivity.this,List3Items);
       	List3.setAdapter(Adapter3);
       	       	
       	List4 = (ExpandableListView) findViewById(R.id.expand4);
       	List4Items = Group4();
       	Adapter4 = new BeerExpandAdapter(MainCategoryActivity.this,List4Items);
       	List4.setAdapter(Adapter4);
       	
       	List5 = (ExpandableListView) findViewById(R.id.expand5);
       	List5Items = Group5();
       	Adapter5 = new BeerExpandAdapter(MainCategoryActivity.this,List5Items);
       	List5.setAdapter(Adapter5);
       	
       	List6 = (ExpandableListView) findViewById(R.id.expand6);
       	List6Items = Group6();
       	Adapter6 = new BeerExpandAdapter(MainCategoryActivity.this,List6Items);
       	List6.setAdapter(Adapter6);
       	
       	List7 = (ExpandableListView) findViewById(R.id.expand7);
       	List7Items = Group7();
       	Adapter7 = new BeerExpandAdapter(MainCategoryActivity.this,List7Items);
       	List7.setAdapter(Adapter7);
       	
       	List8 = (ExpandableListView) findViewById(R.id.expand8);
       	List8Items = Group8();
       	Adapter8 = new BeerExpandAdapter(MainCategoryActivity.this,List8Items);
       	List8.setAdapter(Adapter8);
       	
       	List9 = (ExpandableListView) findViewById(R.id.expand9);
       	List9Items = Group9();
       	Adapter9 = new BeerExpandAdapter(MainCategoryActivity.this,List9Items);
       	List9.setAdapter(Adapter9);
       	
       	List10 = (ExpandableListView) findViewById(R.id.expand10);
       	List10Items = Group10();
       	Adapter10 = new BeerExpandAdapter(MainCategoryActivity.this,List10Items);
       	List10.setAdapter(Adapter10);
       	
       	List11 = (ExpandableListView) findViewById(R.id.expand11);
       	List11Items = Group11();
       	Adapter11 = new BeerExpandAdapter(MainCategoryActivity.this,List11Items);
       	List11.setAdapter(Adapter11);
       	
       	List12 = (ExpandableListView) findViewById(R.id.expand12);
       	List12Items = Group12();
       	Adapter12 = new BeerExpandAdapter(MainCategoryActivity.this,List12Items);
       	List12.setAdapter(Adapter12);
       	
       	List13 = (ExpandableListView) findViewById(R.id.expand13);
       	List13Items = Group13();
       	Adapter13 = new BeerExpandAdapter(MainCategoryActivity.this,List13Items);
       	List13.setAdapter(Adapter13);
        
       	List14 = (ExpandableListView) findViewById(R.id.expand14);
       	List14Items = Group14();
       	Adapter14 = new BeerExpandAdapter(MainCategoryActivity.this,List14Items);
       	List14.setAdapter(Adapter14);
       	
       	List15 = (ExpandableListView) findViewById(R.id.expand15);
       	List15Items = Group15();
       	Adapter15 = new BeerExpandAdapter(MainCategoryActivity.this,List15Items);
       	List15.setAdapter(Adapter15);
       	
       	List16 = (ExpandableListView) findViewById(R.id.expand16);
       	List16Items = Group16();
       	Adapter16 = new BeerExpandAdapter(MainCategoryActivity.this,List16Items);
       	List16.setAdapter(Adapter16);
       	
       	List17 = (ExpandableListView) findViewById(R.id.expand17);
       	List17Items = Group17();
       	Adapter17 = new BeerExpandAdapter(MainCategoryActivity.this,List17Items);
       	List17.setAdapter(Adapter17);
       	
       	List18 = (ExpandableListView) findViewById(R.id.expand18);
       	List18Items = Group18();
       	Adapter18 = new BeerExpandAdapter(MainCategoryActivity.this,List18Items);
       	List18.setAdapter(Adapter18);
       	
       	List19 = (ExpandableListView) findViewById(R.id.expand19);
       	List19Items = Group19();
       	Adapter19 = new BeerExpandAdapter(MainCategoryActivity.this,List19Items);
       	List19.setAdapter(Adapter19);
       	
       	List20 = (ExpandableListView) findViewById(R.id.expand20);
       	List20Items = Group20();
       	Adapter20 = new BeerExpandAdapter(MainCategoryActivity.this,List20Items);
       	List20.setAdapter(Adapter20);
       	
       	List21 = (ExpandableListView) findViewById(R.id.expand21);
       	List21Items = Group21();
       	Adapter21 = new BeerExpandAdapter(MainCategoryActivity.this,List21Items);
       	List21.setAdapter(Adapter21);
       	
       	List22 = (ExpandableListView) findViewById(R.id.expand22);
       	List22Items = Group22();
       	Adapter22 = new BeerExpandAdapter(MainCategoryActivity.this,List22Items);
       	List22.setAdapter(Adapter22);
       	
       	List23 = (ExpandableListView) findViewById(R.id.expand23);
       	List23Items = Group23();
       	Adapter23 = new BeerExpandAdapter(MainCategoryActivity.this,List23Items);
       	List23.setAdapter(Adapter23);

        
        category1 = (LinearLayout) findViewById(R.id.category1);
        category2 = (LinearLayout) findViewById(R.id.category2);
        category3 = (LinearLayout) findViewById(R.id.category3);
        category4 = (LinearLayout) findViewById(R.id.category4);
        category5 = (LinearLayout) findViewById(R.id.category5);
        category6 = (LinearLayout) findViewById(R.id.category6);
        category7 = (LinearLayout) findViewById(R.id.category7);
        category8 = (LinearLayout) findViewById(R.id.category8);
        category9 = (LinearLayout) findViewById(R.id.category9);
        category10 = (LinearLayout) findViewById(R.id.category10);
        category11 = (LinearLayout) findViewById(R.id.category11);
        category12 = (LinearLayout) findViewById(R.id.category12);
        category13 = (LinearLayout) findViewById(R.id.category13);
        category14 = (LinearLayout) findViewById(R.id.category14);
        category15 = (LinearLayout) findViewById(R.id.category15);
        category16 = (LinearLayout) findViewById(R.id.category16);
        category17 = (LinearLayout) findViewById(R.id.category17);
        category18 = (LinearLayout) findViewById(R.id.category18);
        category19 = (LinearLayout) findViewById(R.id.category19);
        category20 = (LinearLayout) findViewById(R.id.category20);
        category21 = (LinearLayout) findViewById(R.id.category21);
        category22 = (LinearLayout) findViewById(R.id.category22);
        category23 = (LinearLayout) findViewById(R.id.category23);
        


        Button mainButton = (Button) findViewById(R.id.main_menu);
        mainButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});
        
        
        // First build, pre XML
       Spinner spinner = (Spinner) findViewById(R.id.spinner);
       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
               this, R.array.beer_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if ( arg2 == 0)
				{
					category1.setVisibility(View.VISIBLE);
					category2.setVisibility(View.GONE);	
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
					

				}
				else if (arg2 == 1)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.VISIBLE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 2)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.VISIBLE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 3)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.VISIBLE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 4)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.VISIBLE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 5)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.VISIBLE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 6)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.VISIBLE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 7)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.VISIBLE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 8)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.VISIBLE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 9)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.VISIBLE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 10)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.VISIBLE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 11)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.VISIBLE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 12)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.VISIBLE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 13)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.VISIBLE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 14)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.VISIBLE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 15)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.VISIBLE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 16)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.VISIBLE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 17)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.VISIBLE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 18)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.VISIBLE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 19)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.VISIBLE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 20)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.VISIBLE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 21)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.VISIBLE);
					category23.setVisibility(View.GONE);
		
				}
				else if (arg2 == 22)
				{
					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.VISIBLE);
		
				}
				else
				{

					category1.setVisibility(View.GONE);
					category2.setVisibility(View.GONE);	
					category3.setVisibility(View.GONE);	
					category4.setVisibility(View.GONE);	
					category5.setVisibility(View.GONE);	
					category6.setVisibility(View.GONE);	
					category7.setVisibility(View.GONE);	
					category8.setVisibility(View.GONE);	
					category9.setVisibility(View.GONE);	
					category10.setVisibility(View.GONE);	
					category11.setVisibility(View.GONE);	
					category12.setVisibility(View.GONE);	
					category13.setVisibility(View.GONE);	
					category14.setVisibility(View.GONE);	
					category15.setVisibility(View.GONE);	
					category16.setVisibility(View.GONE);	
					category17.setVisibility(View.GONE);	
					category18.setVisibility(View.GONE);	
					category19.setVisibility(View.GONE);	
					category20.setVisibility(View.GONE);	
					category21.setVisibility(View.GONE);
					category22.setVisibility(View.GONE);
					category23.setVisibility(View.GONE);

				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

        });
        

    }
    
    public ArrayList<BeerGroup> Group1() {
    	        ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
    	        ArrayList<BeerChild> list1A = new ArrayList<BeerChild>();
    	        ArrayList<BeerChild> list1B = new ArrayList<BeerChild>();
    	        ArrayList<BeerChild> list1C = new ArrayList<BeerChild>();
    	        ArrayList<BeerChild> list1D = new ArrayList<BeerChild>();
    	        ArrayList<BeerChild> list1E = new ArrayList<BeerChild>();
    	        BeerGroup gru1 = new BeerGroup();
    	        
    	        gru1.setName(this.getString(R.string.a10));
    	        BeerChild ch1_1 = new BeerChild();
    	        ch1_1.setName(this.getString(R.string.a11));
    	        list1A.add(ch1_1);
    	        BeerChild ch1_2 = new BeerChild();
    	        ch1_2.setName(this.getString(R.string.a12));
    	       	list1A.add(ch1_2);
    	        BeerChild ch1_3 = new BeerChild();
    	        ch1_3.setName(this.getString(R.string.a13));
    	        list1A.add(ch1_3);
    	        BeerChild ch1_4 = new BeerChild();
    	        ch1_4.setName(this.getString(R.string.a14));
    	        list1A.add(ch1_4);
    	        BeerChild ch1_5 = new BeerChild();
    	        ch1_5.setName(this.getString(R.string.a15));
    	        list1A.add(ch1_5);
    	        BeerChild ch1_6 = new BeerChild();
    	        ch1_6.setName(this.getString(R.string.a16));
    	        list1A.add(ch1_6);
    	        BeerChild ch1_7 = new BeerChild();
    	        ch1_7.setName(this.getString(R.string.a17));
    	        list1A.add(ch1_7);
    	        BeerChild ch1_8 = new BeerChild();
    	        ch1_8.setName(this.getString(R.string.a18));
    	        list1A.add(ch1_8);
    	        BeerChild ch1_9 = new BeerChild();
    	        ch1_9.setName(this.getString(R.string.a19));
    	        list1A.add(ch1_9);
    	        
    	        gru1.setItems(list1A);
    	        
    	        BeerGroup gru2 = new BeerGroup();
    	        gru2.setName(this.getString(R.string.b10));
    	        BeerChild ch2_1 = new BeerChild();
    	        ch2_1.setName(this.getString(R.string.b11));
    	        list1B.add(ch2_1);
    	        BeerChild ch2_2 = new BeerChild();
    	        ch2_2.setName(this.getString(R.string.b12));
    	        list1B.add(ch2_2);
    	        BeerChild ch2_3 = new BeerChild();
    	        ch2_3.setName(this.getString(R.string.b13));
    	        list1B.add(ch2_3);
    	        BeerChild ch2_4 = new BeerChild();
    	        ch2_4.setName(this.getString(R.string.b14));
    	        list1B.add(ch2_4);
    	        BeerChild ch2_5 = new BeerChild();
    	        ch2_5.setName(this.getString(R.string.b15));
    	        list1B.add(ch2_5);
    	        BeerChild ch2_6 = new BeerChild();
    	        ch2_6.setName(this.getString(R.string.b16));
    	        list1B.add(ch2_6);
    	        BeerChild ch2_7 = new BeerChild();
    	        ch2_7.setName(this.getString(R.string.b17));
    	        list1B.add(ch2_7);
    	        BeerChild ch2_8 = new BeerChild();
    	        ch2_8.setName(this.getString(R.string.b18));
    	        list1B.add(ch2_8);
    	        BeerChild ch2_9 = new BeerChild();
    	        ch2_9.setName(this.getString(R.string.b19));
    	        list1B.add(ch2_9);
    	        
    	        gru2.setItems(list1B);
    	        
    	        BeerGroup gru3 = new BeerGroup();
    	        gru3.setName(this.getString(R.string.c10));
    	        BeerChild ch3_1 = new BeerChild();
    	        ch3_1.setName(this.getString(R.string.c11));
    	        list1C.add(ch3_1);
    	        BeerChild ch3_2 = new BeerChild();
    	        ch3_2.setName(this.getString(R.string.c12));
    	        list1C.add(ch3_2);
    	        BeerChild ch3_3 = new BeerChild();
    	        ch3_3.setName(this.getString(R.string.c13));
    	        list1C.add(ch3_3);
    	        BeerChild ch3_4 = new BeerChild();
    	        ch3_4.setName(this.getString(R.string.c14));
    	        list1C.add(ch3_4);
    	        BeerChild ch3_5 = new BeerChild();
    	        ch3_5.setName(this.getString(R.string.c15));
    	        list1C.add(ch3_5);
    	        BeerChild ch3_6 = new BeerChild();
    	        ch3_6.setName(this.getString(R.string.c16));
    	        list1C.add(ch3_6);
    	        BeerChild ch3_7 = new BeerChild();
    	        ch3_7.setName(this.getString(R.string.c17));
    	        list1C.add(ch3_7);
    	        BeerChild ch3_8 = new BeerChild();
    	        ch3_8.setName(this.getString(R.string.c18));
    	        list1C.add(ch3_8);
    	        BeerChild ch3_9 = new BeerChild();
    	        ch3_9.setName(this.getString(R.string.c19));
    	        list1C.add(ch3_9);
    	        
    	        gru3.setItems(list1C);
    	        
    	        
    	        BeerGroup gru4 = new BeerGroup();
    	        gru4.setName(this.getString(R.string.d10));
    	        BeerChild ch4_1 = new BeerChild();
    	        ch4_1.setName(this.getString(R.string.d11));
    	        list1D.add(ch4_1);
    	        BeerChild ch4_2 = new BeerChild();
    	        ch4_2.setName(this.getString(R.string.d12));
    	        list1D.add(ch4_2);
    	        BeerChild ch4_3 = new BeerChild();
    	        ch4_3.setName(this.getString(R.string.d13));
    	        list1D.add(ch4_3);
    	        BeerChild ch4_4 = new BeerChild();
    	        ch4_4.setName(this.getString(R.string.d14));
    	        list1D.add(ch4_4);
    	        BeerChild ch4_5 = new BeerChild();
    	        ch4_5.setName(this.getString(R.string.d15));
    	        list1D.add(ch4_5);
    	        BeerChild ch4_6 = new BeerChild();
    	        ch4_6.setName(this.getString(R.string.d16));
    	        list1D.add(ch4_6);
    	        BeerChild ch4_7 = new BeerChild();
    	        ch4_7.setName(this.getString(R.string.d17));
    	        list1D.add(ch4_7);
    	        BeerChild ch4_8 = new BeerChild();
    	        ch4_8.setName(this.getString(R.string.d18));
    	        list1D.add(ch4_8);
    	        BeerChild ch4_9 = new BeerChild();
    	        ch4_9.setName(this.getString(R.string.d19));
    	        list1D.add(ch4_9);
    	        
    	        gru4.setItems(list1D);
    	        
    	        
    	        BeerGroup gru5 = new BeerGroup();
    	        gru5.setName(this.getString(R.string.e10));
    	        BeerChild ch5_1 = new BeerChild();
    	        ch5_1.setName(this.getString(R.string.e11));
    	        list1E.add(ch5_1);
    	        BeerChild ch5_2 = new BeerChild();
    	        ch5_2.setName(this.getString(R.string.e12));
    	        list1E.add(ch5_2);
    	        BeerChild ch5_3 = new BeerChild();
    	        ch5_3.setName(this.getString(R.string.e13));
    	        list1E.add(ch5_3);
    	        BeerChild ch5_4 = new BeerChild();
    	        ch5_4.setName(this.getString(R.string.e14));
    	        list1E.add(ch5_4);
    	        BeerChild ch5_5 = new BeerChild();
    	        ch5_5.setName(this.getString(R.string.e15));
    	        list1E.add(ch5_5);
    	        BeerChild ch5_6 = new BeerChild();
    	        ch5_6.setName(this.getString(R.string.e16));
    	        list1E.add(ch5_6);
    	        BeerChild ch5_7 = new BeerChild();
    	        ch5_7.setName(this.getString(R.string.e17));
    	        list1E.add(ch5_7);
    	        BeerChild ch5_8 = new BeerChild();
    	        ch5_8.setName(this.getString(R.string.e18));
    	        list1E.add(ch5_8);
    	        BeerChild ch5_9 = new BeerChild();
    	        ch5_9.setName(this.getString(R.string.e19));
    	        list1E.add(ch5_9);
    	        
    	        gru5.setItems(list1E);
    	        
    	        
    	        list.add(gru1);
    	        list.add(gru2);
    	        list.add(gru3);
    	        list.add(gru4);
    	        list.add(gru5);
    	         
    	        return list;
    	    }
    
    public ArrayList<BeerGroup> Group2() {
        ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
        ArrayList<BeerChild> list2A = new ArrayList<BeerChild>();
        ArrayList<BeerChild> list2B = new ArrayList<BeerChild>();  
        ArrayList<BeerChild> list2C = new ArrayList<BeerChild>();
        
        BeerGroup gru1 = new BeerGroup();
        gru1.setName(this.getString(R.string.a20));
        BeerChild ch1_1 = new BeerChild();
        ch1_1.setName(this.getString(R.string.a21));
        list2A.add(ch1_1);
        BeerChild ch1_2 = new BeerChild();
        ch1_2.setName(this.getString(R.string.a22));
        list2A.add(ch1_2);
        BeerChild ch1_3 = new BeerChild();
        ch1_3.setName(this.getString(R.string.a23));
        list2A.add(ch1_3);
        BeerChild ch1_4 = new BeerChild();
        ch1_4.setName(this.getString(R.string.a24));
        list2A.add(ch1_4);
        BeerChild ch1_5 = new BeerChild();
        ch1_5.setName(this.getString(R.string.a25));
        list2A.add(ch1_5);
        BeerChild ch1_6 = new BeerChild();
        ch1_6.setName(this.getString(R.string.a26));
        list2A.add(ch1_6);
        BeerChild ch1_7 = new BeerChild();
        ch1_7.setName(this.getString(R.string.a27));
        list2A.add(ch1_7);
        BeerChild ch1_8 = new BeerChild();
        ch1_8.setName(this.getString(R.string.a28));
        list2A.add(ch1_8);
        BeerChild ch1_9 = new BeerChild();
        ch1_9.setName(this.getString(R.string.a29));
        list2A.add(ch1_9);
        
        gru1.setItems(list2A);
        
           
        BeerGroup gru2 = new BeerGroup();
        gru2.setName(this.getString(R.string.b20));
        BeerChild ch2_1 = new BeerChild();
        ch2_1.setName(this.getString(R.string.b21));
        list2B.add(ch2_1);
        BeerChild ch2_2 = new BeerChild();
        ch2_2.setName(this.getString(R.string.b22));
        list2B.add(ch2_2);
        BeerChild ch2_3 = new BeerChild();
        ch2_3.setName(this.getString(R.string.b23));
        list2B.add(ch2_3);
        BeerChild ch2_4 = new BeerChild();
        ch2_4.setName(this.getString(R.string.b24));
        list2B.add(ch2_4);
        BeerChild ch2_5 = new BeerChild();
        ch2_5.setName(this.getString(R.string.b25));
        list2B.add(ch2_5);
        BeerChild ch2_6 = new BeerChild();
        ch2_6.setName(this.getString(R.string.b26));
        list2B.add(ch2_6);
        BeerChild ch2_7 = new BeerChild();
        ch2_7.setName(this.getString(R.string.b27));
        list2B.add(ch2_7);
        BeerChild ch2_8 = new BeerChild();
        ch2_8.setName(this.getString(R.string.b28));
        list2B.add(ch2_8);
        BeerChild ch2_9 = new BeerChild();
        ch2_9.setName(this.getString(R.string.b29));
        list2B.add(ch2_9);
        
              
        gru2.setItems(list2B);
        
        
        BeerGroup gru3 = new BeerGroup();
        gru3.setName(this.getString(R.string.c20));
        BeerChild ch3_1 = new BeerChild();
        ch3_1.setName(this.getString(R.string.c21));
        list2C.add(ch3_1);
        BeerChild ch3_2 = new BeerChild();
        ch3_2.setName(this.getString(R.string.c22));
        list2C.add(ch3_2);
        BeerChild ch3_3 = new BeerChild();
        ch3_3.setName(this.getString(R.string.c23));
        list2C.add(ch3_3);
        BeerChild ch3_4 = new BeerChild();
        ch3_4.setName(this.getString(R.string.c24));
        list2C.add(ch3_4);
        BeerChild ch3_5 = new BeerChild();
        ch3_5.setName(this.getString(R.string.c25));
        list2C.add(ch3_5);
        BeerChild ch3_6 = new BeerChild();
        ch3_6.setName(this.getString(R.string.c26));
        list2C.add(ch3_6);
        BeerChild ch3_7 = new BeerChild();
        ch3_7.setName(this.getString(R.string.c27));
        list2C.add(ch3_7);
        BeerChild ch3_8 = new BeerChild();
        ch3_8.setName(this.getString(R.string.c28));
        list2C.add(ch3_8);
        BeerChild ch3_9 = new BeerChild();
        ch3_9.setName(this.getString(R.string.c29));
        list2C.add(ch3_9);
        
        
        gru3.setItems(list2C);
        
        list.add(gru1);
        list.add(gru2);
        list.add(gru3);
         
        return list;
    }
    
    public ArrayList<BeerGroup> Group3() {
    	
    	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
    	
    	ArrayList<BeerChild> list3A = new ArrayList<BeerChild>();
        ArrayList<BeerChild> list3B = new ArrayList<BeerChild>();  
        
        BeerGroup gru1 = new BeerGroup();
        gru1.setName(this.getString(R.string.a30));
        BeerChild ch1_1 = new BeerChild();
        ch1_1.setName(this.getString(R.string.a31));
        list3A.add(ch1_1);
        BeerChild ch1_2 = new BeerChild();
        ch1_2.setName(this.getString(R.string.a32));
        list3A.add(ch1_2);
        BeerChild ch1_3 = new BeerChild();
        ch1_3.setName(this.getString(R.string.a33));
        list3A.add(ch1_3);
        BeerChild ch1_4 = new BeerChild();
        ch1_4.setName(this.getString(R.string.a34));
        list3A.add(ch1_4);
        BeerChild ch1_5 = new BeerChild();
        ch1_5.setName(this.getString(R.string.a35));
        list3A.add(ch1_5);
        BeerChild ch1_6 = new BeerChild();
        ch1_6.setName(this.getString(R.string.a36));
        list3A.add(ch1_6);
        BeerChild ch1_7 = new BeerChild();
        ch1_7.setName(this.getString(R.string.a37));
        list3A.add(ch1_7);
        BeerChild ch1_8 = new BeerChild();
        ch1_8.setName(this.getString(R.string.a38));
        list3A.add(ch1_8);
        BeerChild ch1_9 = new BeerChild();
        ch1_9.setName(this.getString(R.string.a39));
        list3A.add(ch1_9);
        
        gru1.setItems(list3A);
        
        BeerGroup gru2 = new BeerGroup();
        gru2.setName(this.getString(R.string.b30));
        BeerChild ch2_1 = new BeerChild();
        ch2_1.setName(this.getString(R.string.b31));
        list3B.add(ch2_1);
        BeerChild ch2_2 = new BeerChild();
        ch2_2.setName(this.getString(R.string.b32));
        list3B.add(ch2_2);
        BeerChild ch2_3 = new BeerChild();
        ch2_3.setName(this.getString(R.string.b33));
        list3B.add(ch2_3);
        BeerChild ch2_4 = new BeerChild();
        ch2_4.setName(this.getString(R.string.b34));
        list3B.add(ch2_4);
        BeerChild ch2_5 = new BeerChild();
        ch2_5.setName(this.getString(R.string.b35));
        list3B.add(ch2_5);
        BeerChild ch2_6 = new BeerChild();
        ch2_6.setName(this.getString(R.string.b36));
        list3B.add(ch2_6);
        BeerChild ch2_7 = new BeerChild();
        ch2_7.setName(this.getString(R.string.b37));
        list3B.add(ch2_7);
        BeerChild ch2_8 = new BeerChild();
        ch2_8.setName(this.getString(R.string.b38));
        list3B.add(ch2_8);
        BeerChild ch2_9 = new BeerChild();
        ch2_9.setName(this.getString(R.string.b39));
        list3B.add(ch2_9);
        
        gru2.setItems(list3B);
        
        list.add(gru1);
        list.add(gru2);
        
    	
    	return list;
    
    }
    
public ArrayList<BeerGroup> Group4() {
	
		  	
    	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
    	
    	ArrayList<BeerChild> list4A = new ArrayList<BeerChild>();
        ArrayList<BeerChild> list4B = new ArrayList<BeerChild>();
        ArrayList<BeerChild> list4C = new ArrayList<BeerChild>();
        
        BeerGroup gru1 = new BeerGroup();
        gru1.setName(this.getString(R.string.a40));
        BeerChild ch1_1 = new BeerChild();
        ch1_1.setName(this.getString(R.string.a41));
        list4A.add(ch1_1);
        BeerChild ch1_2 = new BeerChild();
        ch1_2.setName(this.getString(R.string.a42));
        list4A.add(ch1_2);
        BeerChild ch1_3 = new BeerChild();
        ch1_3.setName(this.getString(R.string.a43));
        list4A.add(ch1_3);
        BeerChild ch1_4 = new BeerChild();
        ch1_4.setName(this.getString(R.string.a44));
        list4A.add(ch1_4);
        BeerChild ch1_5 = new BeerChild();
        ch1_5.setName(this.getString(R.string.a45));
        list4A.add(ch1_5);
        BeerChild ch1_6 = new BeerChild();
        ch1_6.setName(this.getString(R.string.a46));
        list4A.add(ch1_6);
        BeerChild ch1_7 = new BeerChild();
        ch1_7.setName(this.getString(R.string.a47));
        list4A.add(ch1_7);
        BeerChild ch1_8 = new BeerChild();
        ch1_8.setName(this.getString(R.string.a48));
        list4A.add(ch1_8);
        BeerChild ch1_9 = new BeerChild();
        ch1_9.setName(this.getString(R.string.a49));
        list4A.add(ch1_9);
        
        gru1.setItems(list4A);
        
        BeerGroup gru2 = new BeerGroup();
        gru2.setName(this.getString(R.string.b40));
        BeerChild ch2_1 = new BeerChild();
        ch2_1.setName(this.getString(R.string.b41));
        list4B.add(ch2_1);
        BeerChild ch2_2 = new BeerChild();
        ch2_2.setName(this.getString(R.string.b42));
        list4B.add(ch2_2);
        BeerChild ch2_3 = new BeerChild();
        ch2_3.setName(this.getString(R.string.b43));
        list4B.add(ch2_3);
        BeerChild ch2_4 = new BeerChild();
        ch2_4.setName(this.getString(R.string.b44));
        list4B.add(ch2_4);
        BeerChild ch2_5 = new BeerChild();
        ch2_5.setName(this.getString(R.string.b45));
        list4B.add(ch2_5);
        BeerChild ch2_6 = new BeerChild();
        ch2_6.setName(this.getString(R.string.b46));
        list4B.add(ch2_6);
        BeerChild ch2_7 = new BeerChild();
        ch2_7.setName(this.getString(R.string.b47));
        list4B.add(ch2_7);
        BeerChild ch2_8 = new BeerChild();
        ch2_8.setName(this.getString(R.string.b48));
        list4B.add(ch2_8);
        BeerChild ch2_9 = new BeerChild();
        ch2_9.setName(this.getString(R.string.b49));
        list4B.add(ch2_9);
        
        gru2.setItems(list4B);
        
        BeerGroup gru3 = new BeerGroup();
        gru3.setName(this.getString(R.string.c40));
        BeerChild ch3_1 = new BeerChild();
        ch3_1.setName(this.getString(R.string.c41));
        list4C.add(ch3_1);
        BeerChild ch3_2 = new BeerChild();
        ch3_2.setName(this.getString(R.string.c42));
        list4C.add(ch3_2);
        BeerChild ch3_3 = new BeerChild();
        ch3_3.setName(this.getString(R.string.c43));
        list4C.add(ch3_3);
        BeerChild ch3_4 = new BeerChild();
        ch3_4.setName(this.getString(R.string.c44));
        list4C.add(ch3_4);
        BeerChild ch3_5 = new BeerChild();
        ch3_5.setName(this.getString(R.string.c45));
        list4C.add(ch3_5);
        BeerChild ch3_6 = new BeerChild();
        ch3_6.setName(this.getString(R.string.c46));
        list4C.add(ch3_6);
        BeerChild ch3_7 = new BeerChild();
        ch3_7.setName(this.getString(R.string.c47));
        list4C.add(ch3_7);
        BeerChild ch3_8 = new BeerChild();
        ch3_8.setName(this.getString(R.string.c48));
        list4C.add(ch3_8);
        BeerChild ch3_9 = new BeerChild();
        ch3_9.setName(this.getString(R.string.c49));
        list4C.add(ch3_9);
        
        gru3.setItems(list4C);
        
        
        list.add(gru1);
        list.add(gru2);
        list.add(gru3);
        
    	
    	return list;
    
    }
public ArrayList<BeerGroup> Group5() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	
	ArrayList<BeerChild> list5A = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list5B = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list5C = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list5D = new ArrayList<BeerChild>();
    
	BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a50));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a51));
    list5A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a52));
    list5A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a53));
    list5A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a54));
    list5A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a55));
    list5A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a56));
    list5A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a57));
    list5A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a58));
    list5A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a59));
    list5A.add(ch1_9);
    
    gru1.setItems(list5A);
    
	BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b50));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b51));
    list5B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b52));
    list5B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b53));
    list5B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b54));
    list5B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b55));
    list5B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b56));
    list5B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b57));
    list5B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b58));
    list5B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b59));
    list5B.add(ch2_9);
    
    gru2.setItems(list5B);
    
	BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c50));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c51));
    list5C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c52));
    list5C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c53));
    list5C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c54));
    list5C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c55));
    list5C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c56));
    list5C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c57));
    list5C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c58));
    list5C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c59));
    list5C.add(ch3_9);
    
    gru3.setItems(list5C);
    
	BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d50));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d51));
    list5D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d52));
    list5D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d53));
    list5D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d54));
    list5D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d55));
    list5D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d56));
    list5D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d57));
    list5D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d58));
    list5D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d59));
    list5D.add(ch4_9);
    
    gru4.setItems(list5D); 
    
    
    
    list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    list.add(gru4);
    
	
	return list;

}
public ArrayList<BeerGroup> Group6() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list6A = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list6B = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list6C = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list6D = new ArrayList<BeerChild>();
    
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a60));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a61));
    list6A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a62));
    list6A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a63));
    list6A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a64));
    list6A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a65));
    list6A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a66));
    list6A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a67));
    list6A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a68));
    list6A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a69));
    list6A.add(ch1_9);
    
    gru1.setItems(list6A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b60));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b61));
    list6B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b62));
    list6B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b63));
    list6B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b64));
    list6B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b65));
    list6B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b66));
    list6B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b67));
    list6B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b68));
    list6B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b69));
    list6B.add(ch2_9);
    
    gru2.setItems(list6B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c60));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c61));
    list6C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c62));
    list6C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c63));
    list6C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c64));
    list6C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c65));
    list6C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c66));
    list6C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c67));
    list6C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c68));
    list6C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c69));
    list6C.add(ch3_9);
    
    gru3.setItems(list6C);
    
    BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d60));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d61));
    list6D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d62));
    list6D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d63));
    list6D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d64));
    list6D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d65));
    list6D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d66));
    list6D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d67));
    list6D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d68));
    list6D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d69));
    list6D.add(ch4_9);
    
    gru4.setItems(list6D);
    
    list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    list.add(gru4);
    
	
    
    
	
	return list;

}
public ArrayList<BeerGroup> Group7() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list7A = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list7B = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list7C = new ArrayList<BeerChild>();
    
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a70));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a71));
    list7A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a72));
    list7A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a73));
    list7A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a74));
    list7A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a75));
    list7A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a76));
    list7A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a77));
    list7A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a78));
    list7A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a79));
    list7A.add(ch1_9);
    
    gru1.setItems(list7A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b70));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b71));
    list7B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b72));
    list7B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b73));
    list7B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b74));
    list7B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b75));
    list7B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b76));
    list7B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b77));
    list7B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b78));
    list7B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b79));
    list7B.add(ch2_9);
    
    gru2.setItems(list7B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c70));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c71));
    list7C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c72));
    list7C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c73));
    list7C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c74));
    list7C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c75));
    list7C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c76));
    list7C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c77));
    list7C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c78));
    list7C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c79));
    list7C.add(ch3_9);
    
    gru3.setItems(list7C);
    
    list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    
    
	
	return list;

}
public ArrayList<BeerGroup> Group8() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list8A = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list8B = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list8C = new ArrayList<BeerChild>();
    
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a80));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a81));
    list8A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a82));
    list8A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a83));
    list8A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a84));
    list8A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a85));
    list8A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a86));
    list8A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a87));
    list8A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a88));
    list8A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a89));
    list8A.add(ch1_9);
    
    gru1.setItems(list8A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b80));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b81));
    list8B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b82));
    list8B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b83));
    list8B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b84));
    list8B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b85));
    list8B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b86));
    list8B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b87));
    list8B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b88));
    list8B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b89));
    list8B.add(ch2_9);
    
    gru2.setItems(list8B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c80));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c81));
    list8C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c82));
    list8C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c83));
    list8C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c84));
    list8C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c85));
    list8C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c86));
    list8C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c87));
    list8C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c88));
    list8C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c89));
    list8C.add(ch3_9);
    
    gru3.setItems(list8C);
    
    
    list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group9() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list9A = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list9B = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list9C = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list9D = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list9E = new ArrayList<BeerChild>();
    
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a90));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a91));
    list9A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a92));
    list9A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a93));
    list9A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a94));
    list9A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a95));
    list9A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a96));
    list9A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a97));
    list9A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a98));
    list9A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a99));
    list9A.add(ch1_9);
    
    gru1.setItems(list9A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b90));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b91));
    list9B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b92));
    list9B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b93));
    list9B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b94));
    list9B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b95));
    list9B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b96));
    list9B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b97));
    list9B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b98));
    list9B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b99));
    list9B.add(ch2_9);
    
    gru2.setItems(list9B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c90));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c91));
    list9C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c92));
    list9C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c93));
    list9C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c94));
    list9C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c95));
    list9C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c96));
    list9C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c97));
    list9C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c98));
    list9C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c99));
    list9C.add(ch3_9);
    
    gru3.setItems(list9C);
    
    BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d90));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d91));
    list9D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d92));
    list9D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d93));
    list9D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d94));
    list9D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d95));
    list9D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d96));
    list9D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d97));
    list9D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d98));
    list9D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d99));
    list9D.add(ch4_9);
    
    gru4.setItems(list9D);
    
    BeerGroup gru5 = new BeerGroup();
    gru5.setName(this.getString(R.string.e90));
    BeerChild ch5_1 = new BeerChild();
    ch5_1.setName(this.getString(R.string.e91));
    list9E.add(ch5_1);
    BeerChild ch5_2 = new BeerChild();
    ch5_2.setName(this.getString(R.string.e92));
    list9E.add(ch5_2);
    BeerChild ch5_3 = new BeerChild();
    ch5_3.setName(this.getString(R.string.e93));
    list9E.add(ch5_3);
    BeerChild ch5_4 = new BeerChild();
    ch5_4.setName(this.getString(R.string.e94));
    list9E.add(ch5_4);
    BeerChild ch5_5 = new BeerChild();
    ch5_5.setName(this.getString(R.string.e95));
    list9E.add(ch5_5);
    BeerChild ch5_6 = new BeerChild();
    ch5_6.setName(this.getString(R.string.e96));
    list9E.add(ch5_6);
    BeerChild ch5_7 = new BeerChild();
    ch5_7.setName(this.getString(R.string.e97));
    list9E.add(ch5_7);
    BeerChild ch5_8 = new BeerChild();
    ch5_8.setName(this.getString(R.string.e98));
    list9E.add(ch5_8);
    BeerChild ch5_9 = new BeerChild();
    ch5_9.setName(this.getString(R.string.e99));
    list9E.add(ch5_9);
    
    gru5.setItems(list9E);

    
    list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    list.add(gru4);
    list.add(gru5);
    
	return list;

}
public ArrayList<BeerGroup> Group10() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list10A = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list10B = new ArrayList<BeerChild>();
    ArrayList<BeerChild> list10C = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a100));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a101));
    list10A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a102));
    list10A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a103));
    list10A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a104));
    list10A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a105));
    list10A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a106));
    list10A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a107));
    list10A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a108));
    list10A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a109));
    list10A.add(ch1_9);
    
    gru1.setItems(list10A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b100));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b101));
    list10B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b102));
    list10B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b103));
    list10B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b104));
    list10B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b105));
    list10B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b106));
    list10B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b107));
    list10B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b108));
    list10B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b109));
    list10B.add(ch2_9);
    
    gru2.setItems(list10B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c100));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c101));
    list10C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c102));
    list10C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c103));
    list10C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c104));
    list10C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c105));
    list10C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c106));
    list10C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c107));
    list10C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c108));
    list10C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c109));
    list10C.add(ch3_9);
    
    gru3.setItems(list10C);
    
    list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group11() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list11A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list11B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list11C = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a110));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a111));
    list11A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a112));
    list11A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a113));
    list11A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a114));
    list11A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a115));
    list11A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a116));
    list11A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a117));
    list11A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a118));
    list11A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a119));
    list11A.add(ch1_9);
    
    gru1.setItems(list11A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b110));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b111));
    list11B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b112));
    list11B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b113));
    list11B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b114));
    list11B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b115));
    list11B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b116));
    list11B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b117));
    list11B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b118));
    list11B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b119));
    list11B.add(ch2_9);
    
    gru2.setItems(list11B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c110));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c111));
    list11C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c112));
    list11C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c113));
    list11C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c114));
    list11C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c115));
    list11C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c116));
    list11C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c117));
    list11C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c118));
    list11C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c119));
    list11C.add(ch3_9);
    
    gru3.setItems(list11C);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group12() {
	
  	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list12A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list12B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list12C = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a120));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a121));
    list12A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a122));
    list12A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a123));
    list12A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a124));
    list12A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a125));
    list12A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a126));
    list12A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a127));
    list12A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a128));
    list12A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a129));
    list12A.add(ch1_9);
    
    gru1.setItems(list12A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b120));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b121));
    list12B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b122));
    list12B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b123));
    list12B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b124));
    list12B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b125));
    list12B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b126));
    list12B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b127));
    list12B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b128));
    list12B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b129));
    list12B.add(ch2_9);
    
    gru2.setItems(list12B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c120));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c121));
    list12C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c122));
    list12C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c123));
    list12C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c124));
    list12C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c125));
    list12C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c126));
    list12C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c127));
    list12C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c128));
    list12C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c129));
    list12C.add(ch3_9);
    
    gru3.setItems(list12C);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group13() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list13A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list13B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list13C = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list13D = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list13E = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list13F = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a130));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a131));
    list13A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a132));
    list13A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a133));
    list13A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a134));
    list13A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a135));
    list13A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a136));
    list13A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a137));
    list13A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a138));
    list13A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a139));
    list13A.add(ch1_9);
    
    gru1.setItems(list13A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b130));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b131));
    list13B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b132));
    list13B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b133));
    list13B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b134));
    list13B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b135));
    list13B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b136));
    list13B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b137));
    list13B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b138));
    list13B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b139));
    list13B.add(ch2_9);
    
    gru2.setItems(list13B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c130));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c131));
    list13C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c132));
    list13C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c133));
    list13C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c134));
    list13C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c135));
    list13C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c136));
    list13C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c137));
    list13C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c138));
    list13C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c139));
    list13C.add(ch3_9);
    
    gru3.setItems(list13C);
    
    BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d130));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d131));
    list13D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d132));
    list13D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d133));
    list13D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d134));
    list13D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d135));
    list13D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d136));
    list13D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d137));
    list13D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d138));
    list13D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d139));
    list13D.add(ch4_9);
    
    gru4.setItems(list13D);
    
    BeerGroup gru5 = new BeerGroup();
    gru5.setName(this.getString(R.string.e130));
    BeerChild ch5_1 = new BeerChild();
    ch5_1.setName(this.getString(R.string.e131));
    list13E.add(ch5_1);
    BeerChild ch5_2 = new BeerChild();
    ch5_2.setName(this.getString(R.string.e132));
    list13E.add(ch5_2);
    BeerChild ch5_3 = new BeerChild();
    ch5_3.setName(this.getString(R.string.e133));
    list13E.add(ch5_3);
    BeerChild ch5_4 = new BeerChild();
    ch5_4.setName(this.getString(R.string.e134));
    list13E.add(ch5_4);
    BeerChild ch5_5 = new BeerChild();
    ch5_5.setName(this.getString(R.string.e135));
    list13E.add(ch5_5);
    BeerChild ch5_6 = new BeerChild();
    ch5_6.setName(this.getString(R.string.e136));
    list13E.add(ch5_6);
    BeerChild ch5_7 = new BeerChild();
    ch5_7.setName(this.getString(R.string.e137));
    list13E.add(ch5_7);
    BeerChild ch5_8 = new BeerChild();
    ch5_8.setName(this.getString(R.string.e138));
    list13E.add(ch5_8);
    BeerChild ch5_9 = new BeerChild();
    ch5_9.setName(this.getString(R.string.e139));
    list13E.add(ch5_9);
    
    gru5.setItems(list13E);
    
    BeerGroup gru6 = new BeerGroup();
    gru6.setName(this.getString(R.string.f130));
    BeerChild ch6_1 = new BeerChild();
    ch6_1.setName(this.getString(R.string.f131));
    list13F.add(ch6_1);
    BeerChild ch6_2 = new BeerChild();
    ch6_2.setName(this.getString(R.string.f132));
    list13F.add(ch6_2);
    BeerChild ch6_3 = new BeerChild();
    ch6_3.setName(this.getString(R.string.f133));
    list13F.add(ch6_3);
    BeerChild ch6_4 = new BeerChild();
    ch6_4.setName(this.getString(R.string.f134));
    list13F.add(ch6_4);
    BeerChild ch6_5 = new BeerChild();
    ch6_5.setName(this.getString(R.string.f135));
    list13F.add(ch6_5);
    BeerChild ch6_6 = new BeerChild();
    ch6_6.setName(this.getString(R.string.f136));
    list13F.add(ch6_6);
    BeerChild ch6_7 = new BeerChild();
    ch6_7.setName(this.getString(R.string.f137));
    list13F.add(ch6_7);
    BeerChild ch6_8 = new BeerChild();
    ch6_8.setName(this.getString(R.string.f138));
    list13F.add(ch6_8);
    BeerChild ch6_9 = new BeerChild();
    ch6_9.setName(this.getString(R.string.f139));
    list13F.add(ch6_9);
    
    gru6.setItems(list13F);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    list.add(gru4);
    list.add(gru5);
    list.add(gru6);
    
	return list;
	

}
public ArrayList<BeerGroup> Group14() {
	
  	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list14A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list14B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list14C = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a140));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a141));
    list14A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a142));
    list14A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a143));
    list14A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a144));
    list14A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a145));
    list14A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a146));
    list14A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a147));
    list14A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a148));
    list14A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a149));
    list14A.add(ch1_9);
    
    gru1.setItems(list14A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b140));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b141));
    list14B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b142));
    list14B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b143));
    list14B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b144));
    list14B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b145));
    list14B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b146));
    list14B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b147));
    list14B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b148));
    list14B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b149));
    list14B.add(ch2_9);
    
    gru2.setItems(list14B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c140));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c141));
    list14C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c142));
    list14C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c143));
    list14C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c144));
    list14C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c145));
    list14C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c146));
    list14C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c147));
    list14C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c148));
    list14C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c149));
    list14C.add(ch3_9);
    
    gru3.setItems(list14C);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group15() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list15A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list15B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list15C = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list15D = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a150));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a151));
    list15A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a152));
    list15A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a153));
    list15A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a154));
    list15A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a155));
    list15A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a156));
    list15A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a157));
    list15A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a158));
    list15A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a159));
    list15A.add(ch1_9);
    
    gru1.setItems(list15A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b150));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b151));
    list15B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b152));
    list15B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b153));
    list15B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b154));
    list15B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b155));
    list15B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b156));
    list15B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b157));
    list15B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b158));
    list15B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b159));
    list15B.add(ch2_9);
    
    gru2.setItems(list15B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c150));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c151));
    list15C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c152));
    list15C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c153));
    list15C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c154));
    list15C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c155));
    list15C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c156));
    list15C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c157));
    list15C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c158));
    list15C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c159));
    list15C.add(ch3_9);
    
    gru3.setItems(list15C);
    
    BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d150));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d151));
    list15D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d152));
    list15D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d153));
    list15D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d154));
    list15D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d155));
    list15D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d156));
    list15D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d157));
    list15D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d158));
    list15D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d159));
    list15D.add(ch4_9);
    
    gru4.setItems(list15D);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group16() {
		
		ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
		
		ArrayList<BeerChild> list16A = new ArrayList<BeerChild>();
		ArrayList<BeerChild> list16B = new ArrayList<BeerChild>();
		ArrayList<BeerChild> list16C = new ArrayList<BeerChild>();
		ArrayList<BeerChild> list16D = new ArrayList<BeerChild>();
		ArrayList<BeerChild> list16E = new ArrayList<BeerChild>();

		
	    BeerGroup gru1 = new BeerGroup();
	    gru1.setName(this.getString(R.string.a160));
	    BeerChild ch1_1 = new BeerChild();
	    ch1_1.setName(this.getString(R.string.a161));
	    list16A.add(ch1_1);
	    BeerChild ch1_2 = new BeerChild();
	    ch1_2.setName(this.getString(R.string.a162));
	    list16A.add(ch1_2);
	    BeerChild ch1_3 = new BeerChild();
	    ch1_3.setName(this.getString(R.string.a163));
	    list16A.add(ch1_3);
	    BeerChild ch1_4 = new BeerChild();
	    ch1_4.setName(this.getString(R.string.a164));
	    list16A.add(ch1_4);
	    BeerChild ch1_5 = new BeerChild();
	    ch1_5.setName(this.getString(R.string.a165));
	    list16A.add(ch1_5);
	    BeerChild ch1_6 = new BeerChild();
	    ch1_6.setName(this.getString(R.string.a166));
	    list16A.add(ch1_6);
	    BeerChild ch1_7 = new BeerChild();
	    ch1_7.setName(this.getString(R.string.a167));
	    list16A.add(ch1_7);
	    BeerChild ch1_8 = new BeerChild();
	    ch1_8.setName(this.getString(R.string.a168));
	    list16A.add(ch1_8);
	    BeerChild ch1_9 = new BeerChild();
	    ch1_9.setName(this.getString(R.string.a169));
	    list16A.add(ch1_9);
	    
	    gru1.setItems(list16A);
	    
	    BeerGroup gru2 = new BeerGroup();
	    gru2.setName(this.getString(R.string.b160));
	    BeerChild ch2_1 = new BeerChild();
	    ch2_1.setName(this.getString(R.string.b161));
	    list16B.add(ch2_1);
	    BeerChild ch2_2 = new BeerChild();
	    ch2_2.setName(this.getString(R.string.b162));
	    list16B.add(ch2_2);
	    BeerChild ch2_3 = new BeerChild();
	    ch2_3.setName(this.getString(R.string.b163));
	    list16B.add(ch2_3);
	    BeerChild ch2_4 = new BeerChild();
	    ch2_4.setName(this.getString(R.string.b164));
	    list16B.add(ch2_4);
	    BeerChild ch2_5 = new BeerChild();
	    ch2_5.setName(this.getString(R.string.b165));
	    list16B.add(ch2_5);
	    BeerChild ch2_6 = new BeerChild();
	    ch2_6.setName(this.getString(R.string.b166));
	    list16B.add(ch2_6);
	    BeerChild ch2_7 = new BeerChild();
	    ch2_7.setName(this.getString(R.string.b167));
	    list16B.add(ch2_7);
	    BeerChild ch2_8 = new BeerChild();
	    ch2_8.setName(this.getString(R.string.b168));
	    list16B.add(ch2_8);
	    BeerChild ch2_9 = new BeerChild();
	    ch2_9.setName(this.getString(R.string.b169));
	    list16B.add(ch2_9);
	    
	    gru2.setItems(list16B);
	    
	    BeerGroup gru3 = new BeerGroup();
	    gru3.setName(this.getString(R.string.c160));
	    BeerChild ch3_1 = new BeerChild();
	    ch3_1.setName(this.getString(R.string.c161));
	    list16C.add(ch3_1);
	    BeerChild ch3_2 = new BeerChild();
	    ch3_2.setName(this.getString(R.string.c162));
	    list16C.add(ch3_2);
	    BeerChild ch3_3 = new BeerChild();
	    ch3_3.setName(this.getString(R.string.c163));
	    list16C.add(ch3_3);
	    BeerChild ch3_4 = new BeerChild();
	    ch3_4.setName(this.getString(R.string.c164));
	    list16C.add(ch3_4);
	    BeerChild ch3_5 = new BeerChild();
	    ch3_5.setName(this.getString(R.string.c165));
	    list16C.add(ch3_5);
	    BeerChild ch3_6 = new BeerChild();
	    ch3_6.setName(this.getString(R.string.c166));
	    list16C.add(ch3_6);
	    BeerChild ch3_7 = new BeerChild();
	    ch3_7.setName(this.getString(R.string.c167));
	    list16C.add(ch3_7);
	    BeerChild ch3_8 = new BeerChild();
	    ch3_8.setName(this.getString(R.string.c168));
	    list16C.add(ch3_8);
	    BeerChild ch3_9 = new BeerChild();
	    ch3_9.setName(this.getString(R.string.c169));
	    list16C.add(ch3_9);
	    
	    gru3.setItems(list16C);
	    
	    BeerGroup gru4 = new BeerGroup();
	    gru4.setName(this.getString(R.string.d160));
	    BeerChild ch4_1 = new BeerChild();
	    ch4_1.setName(this.getString(R.string.d161));
	    list16D.add(ch4_1);
	    BeerChild ch4_2 = new BeerChild();
	    ch4_2.setName(this.getString(R.string.d162));
	    list16D.add(ch4_2);
	    BeerChild ch4_3 = new BeerChild();
	    ch4_3.setName(this.getString(R.string.d163));
	    list16D.add(ch4_3);
	    BeerChild ch4_4 = new BeerChild();
	    ch4_4.setName(this.getString(R.string.d164));
	    list16D.add(ch4_4);
	    BeerChild ch4_5 = new BeerChild();
	    ch4_5.setName(this.getString(R.string.d165));
	    list16D.add(ch4_5);
	    BeerChild ch4_6 = new BeerChild();
	    ch4_6.setName(this.getString(R.string.d166));
	    list16D.add(ch4_6);
	    BeerChild ch4_7 = new BeerChild();
	    ch4_7.setName(this.getString(R.string.d167));
	    list16D.add(ch4_7);
	    BeerChild ch4_8 = new BeerChild();
	    ch4_8.setName(this.getString(R.string.d168));
	    list16D.add(ch4_8);
	    BeerChild ch4_9 = new BeerChild();
	    ch4_9.setName(this.getString(R.string.d169));
	    list16D.add(ch4_9);
	    
	    gru4.setItems(list16D);
	    
	    BeerGroup gru5 = new BeerGroup();
	    gru5.setName(this.getString(R.string.e160));
	    BeerChild ch5_1 = new BeerChild();
	    ch5_1.setName(this.getString(R.string.e161));
	    list16E.add(ch5_1);
	    BeerChild ch5_2 = new BeerChild();
	    ch5_2.setName(this.getString(R.string.e162));
	    list16E.add(ch5_2);
	    BeerChild ch5_3 = new BeerChild();
	    ch5_3.setName(this.getString(R.string.e163));
	    list16E.add(ch5_3);
	    BeerChild ch5_4 = new BeerChild();
	    ch5_4.setName(this.getString(R.string.e164));
	    list16E.add(ch5_4);
	    BeerChild ch5_5 = new BeerChild();
	    ch5_5.setName(this.getString(R.string.e165));
	    list16E.add(ch5_5);
	    BeerChild ch5_6 = new BeerChild();
	    ch5_6.setName(this.getString(R.string.e166));
	    list16E.add(ch5_6);
	    BeerChild ch5_7 = new BeerChild();
	    ch5_7.setName(this.getString(R.string.e167));
	    list16E.add(ch5_7);
	    BeerChild ch5_8 = new BeerChild();
	    ch5_8.setName(this.getString(R.string.e168));
	    list16E.add(ch5_8);
	    BeerChild ch5_9 = new BeerChild();
	    ch5_9.setName(this.getString(R.string.e169));
	    list16E.add(ch5_9);
	    
	    gru5.setItems(list16E);
	    
		
		list.add(gru1);
	    list.add(gru2);
	    list.add(gru3);
	    list.add(gru4);
	    list.add(gru5);

	    
		return list;
		

}

public ArrayList<BeerGroup> Group17() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list17A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list17B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list17C = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list17D = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list17E = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list17F = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a170));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a171));
    list17A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a172));
    list17A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a173));
    list17A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a174));
    list17A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a175));
    list17A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a176));
    list17A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a177));
    list17A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a178));
    list17A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a179));
    list17A.add(ch1_9);
    
    gru1.setItems(list17A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b170));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b171));
    list17B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b172));
    list17B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b173));
    list17B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b174));
    list17B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b175));
    list17B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b176));
    list17B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b177));
    list17B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b178));
    list17B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b179));
    list17B.add(ch2_9);
    
    gru2.setItems(list17B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c170));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c171));
    list17C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c172));
    list17C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c173));
    list17C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c174));
    list17C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c175));
    list17C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c176));
    list17C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c177));
    list17C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c178));
    list17C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c179));
    list17C.add(ch3_9);
    
    gru3.setItems(list17C);
    
    BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d170));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d171));
    list17D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d172));
    list17D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d173));
    list17D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d174));
    list17D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d175));
    list17D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d176));
    list17D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d177));
    list17D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d178));
    list17D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d179));
    list17D.add(ch4_9);
    
    gru4.setItems(list17D);
    
    BeerGroup gru5 = new BeerGroup();
    gru5.setName(this.getString(R.string.e170));
    BeerChild ch5_1 = new BeerChild();
    ch5_1.setName(this.getString(R.string.e171));
    list17E.add(ch5_1);
    BeerChild ch5_2 = new BeerChild();
    ch5_2.setName(this.getString(R.string.e172));
    list17E.add(ch5_2);
    BeerChild ch5_3 = new BeerChild();
    ch5_3.setName(this.getString(R.string.e173));
    list17E.add(ch5_3);
    BeerChild ch5_4 = new BeerChild();
    ch5_4.setName(this.getString(R.string.e174));
    list17E.add(ch5_4);
    BeerChild ch5_5 = new BeerChild();
    ch5_5.setName(this.getString(R.string.e175));
    list17E.add(ch5_5);
    BeerChild ch5_6 = new BeerChild();
    ch5_6.setName(this.getString(R.string.e176));
    list17E.add(ch5_6);
    BeerChild ch5_7 = new BeerChild();
    ch5_7.setName(this.getString(R.string.e177));
    list17E.add(ch5_7);
    BeerChild ch5_8 = new BeerChild();
    ch5_8.setName(this.getString(R.string.e178));
    list17E.add(ch5_8);
    BeerChild ch5_9 = new BeerChild();
    ch5_9.setName(this.getString(R.string.e179));
    list17E.add(ch5_9);
    
    gru5.setItems(list17E);
    
    BeerGroup gru6 = new BeerGroup();
    gru6.setName(this.getString(R.string.f170));
    BeerChild ch6_1 = new BeerChild();
    ch6_1.setName(this.getString(R.string.f171));
    list17F.add(ch6_1);
    BeerChild ch6_2 = new BeerChild();
    ch6_2.setName(this.getString(R.string.f172));
    list17F.add(ch6_2);
    BeerChild ch6_3 = new BeerChild();
    ch6_3.setName(this.getString(R.string.f173));
    list17F.add(ch6_3);
    BeerChild ch6_4 = new BeerChild();
    ch6_4.setName(this.getString(R.string.f174));
    list17F.add(ch6_4);
    BeerChild ch6_5 = new BeerChild();
    ch6_5.setName(this.getString(R.string.f175));
    list17F.add(ch6_5);
    BeerChild ch6_6 = new BeerChild();
    ch6_6.setName(this.getString(R.string.f176));
    list17F.add(ch6_6);
    BeerChild ch6_7 = new BeerChild();
    ch6_7.setName(this.getString(R.string.f177));
    list17F.add(ch6_7);
    BeerChild ch6_8 = new BeerChild();
    ch6_8.setName(this.getString(R.string.f178));
    list17F.add(ch6_8);
    BeerChild ch6_9 = new BeerChild();
    ch6_9.setName(this.getString(R.string.f179));
    list17F.add(ch6_9);
    
    gru6.setItems(list17F);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    list.add(gru4);
    list.add(gru5);
    list.add(gru6);
    
	return list;

}

public ArrayList<BeerGroup> Group18() {
	

	
    ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list18A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list18B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list18C = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list18D = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list18E = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list18F = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a180));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a181));
    list18A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a182));
    list18A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a183));
    list18A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a184));
    list18A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a185));
    list18A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a186));
    list18A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a187));
    list18A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a188));
    list18A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a189));
    list18A.add(ch1_9);
    
    gru1.setItems(list18A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b180));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b181));
    list18B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b182));
    list18B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b183));
    list18B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b184));
    list18B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b185));
    list18B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b186));
    list18B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b187));
    list18B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b188));
    list18B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b189));
    list18B.add(ch2_9);
    
    gru2.setItems(list18B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c180));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c181));
    list18C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c182));
    list18C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c183));
    list18C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c184));
    list18C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c185));
    list18C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c186));
    list18C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c187));
    list18C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c188));
    list18C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c189));
    list18C.add(ch3_9);
    
    gru3.setItems(list18C);
    
    BeerGroup gru4 = new BeerGroup();
    gru4.setName(this.getString(R.string.d180));
    BeerChild ch4_1 = new BeerChild();
    ch4_1.setName(this.getString(R.string.d181));
    list18D.add(ch4_1);
    BeerChild ch4_2 = new BeerChild();
    ch4_2.setName(this.getString(R.string.d182));
    list18D.add(ch4_2);
    BeerChild ch4_3 = new BeerChild();
    ch4_3.setName(this.getString(R.string.d183));
    list18D.add(ch4_3);
    BeerChild ch4_4 = new BeerChild();
    ch4_4.setName(this.getString(R.string.d184));
    list18D.add(ch4_4);
    BeerChild ch4_5 = new BeerChild();
    ch4_5.setName(this.getString(R.string.d185));
    list18D.add(ch4_5);
    BeerChild ch4_6 = new BeerChild();
    ch4_6.setName(this.getString(R.string.d186));
    list18D.add(ch4_6);
    BeerChild ch4_7 = new BeerChild();
    ch4_7.setName(this.getString(R.string.d187));
    list18D.add(ch4_7);
    BeerChild ch4_8 = new BeerChild();
    ch4_8.setName(this.getString(R.string.d188));
    list18D.add(ch4_8);
    BeerChild ch4_9 = new BeerChild();
    ch4_9.setName(this.getString(R.string.d189));
    list18D.add(ch4_9);
    
    gru4.setItems(list18D);
    
    BeerGroup gru5 = new BeerGroup();
    gru5.setName(this.getString(R.string.e180));
    BeerChild ch5_1 = new BeerChild();
    ch5_1.setName(this.getString(R.string.e181));
    list18E.add(ch5_1);
    BeerChild ch5_2 = new BeerChild();
    ch5_2.setName(this.getString(R.string.e182));
    list18E.add(ch5_2);
    BeerChild ch5_3 = new BeerChild();
    ch5_3.setName(this.getString(R.string.e183));
    list18E.add(ch5_3);
    BeerChild ch5_4 = new BeerChild();
    ch5_4.setName(this.getString(R.string.e184));
    list18E.add(ch5_4);
    BeerChild ch5_5 = new BeerChild();
    ch5_5.setName(this.getString(R.string.e185));
    list18E.add(ch5_5);
    BeerChild ch5_6 = new BeerChild();
    ch5_6.setName(this.getString(R.string.e186));
    list18E.add(ch5_6);
    BeerChild ch5_7 = new BeerChild();
    ch5_7.setName(this.getString(R.string.e187));
    list18E.add(ch5_7);
    BeerChild ch5_8 = new BeerChild();
    ch5_8.setName(this.getString(R.string.e188));
    list18E.add(ch5_8);
    BeerChild ch5_9 = new BeerChild();
    ch5_9.setName(this.getString(R.string.e189));
    list18E.add(ch5_9);
    
    gru5.setItems(list18E);
    
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
    list.add(gru4);
    list.add(gru5);

    
	return list;
	



}
public ArrayList<BeerGroup> Group19() {
	
  	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list19A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list19B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list19C = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a190));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a191));
    list19A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a192));
    list19A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a193));
    list19A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a194));
    list19A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a195));
    list19A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a196));
    list19A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a197));
    list19A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a198));
    list19A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a199));
    list19A.add(ch1_9);
    
    gru1.setItems(list19A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b190));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b191));
    list19B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b192));
    list19B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b193));
    list19B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b194));
    list19B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b195));
    list19B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b196));
    list19B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b197));
    list19B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b198));
    list19B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b199));
    list19B.add(ch2_9);
    
    gru2.setItems(list19B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c190));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c191));
    list19C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c192));
    list19C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c193));
    list19C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c194));
    list19C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c195));
    list19C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c196));
    list19C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c197));
    list19C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c198));
    list19C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c199));
    list19C.add(ch3_9);
    
    gru3.setItems(list19C);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group20() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list20A = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a200));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a201));
    list20A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a202));
    list20A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a203));
    list20A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a204));
    list20A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a205));
    list20A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a206));
    list20A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a207));
    list20A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a208));
    list20A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a209));
    list20A.add(ch1_9);
    
    gru1.setItems(list20A);
    
    list.add(gru1);
	
	return list;

}
public ArrayList<BeerGroup> Group21() {
	
  	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list21A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list21B = new ArrayList<BeerChild>();

	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a210));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a211));
    list21A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a212));
    list21A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a213));
    list21A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a214));
    list21A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a215));
    list21A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a216));
    list21A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a217));
    list21A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a218));
    list21A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a221));
    list21A.add(ch1_9);
    
    gru1.setItems(list21A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b210));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b211));
    list21B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b212));
    list21B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b213));
    list21B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b214));
    list21B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b215));
    list21B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b216));
    list21B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b217));
    list21B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b218));
    list21B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b221));
    list21B.add(ch2_9);
    
    gru2.setItems(list21B);
    


	list.add(gru1);
    list.add(gru2);

	
	return list;

}
public ArrayList<BeerGroup> Group22() {
	
  	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list22A = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list22B = new ArrayList<BeerChild>();
	ArrayList<BeerChild> list22C = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a220));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a221));
    list22A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a222));
    list22A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a223));
    list22A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a224));
    list22A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a225));
    list22A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a226));
    list22A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a227));
    list22A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a228));
    list22A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a222));
    list22A.add(ch1_9);
    
    gru1.setItems(list22A);
    
    BeerGroup gru2 = new BeerGroup();
    gru2.setName(this.getString(R.string.b220));
    BeerChild ch2_1 = new BeerChild();
    ch2_1.setName(this.getString(R.string.b221));
    list22B.add(ch2_1);
    BeerChild ch2_2 = new BeerChild();
    ch2_2.setName(this.getString(R.string.b222));
    list22B.add(ch2_2);
    BeerChild ch2_3 = new BeerChild();
    ch2_3.setName(this.getString(R.string.b223));
    list22B.add(ch2_3);
    BeerChild ch2_4 = new BeerChild();
    ch2_4.setName(this.getString(R.string.b224));
    list22B.add(ch2_4);
    BeerChild ch2_5 = new BeerChild();
    ch2_5.setName(this.getString(R.string.b225));
    list22B.add(ch2_5);
    BeerChild ch2_6 = new BeerChild();
    ch2_6.setName(this.getString(R.string.b226));
    list22B.add(ch2_6);
    BeerChild ch2_7 = new BeerChild();
    ch2_7.setName(this.getString(R.string.b227));
    list22B.add(ch2_7);
    BeerChild ch2_8 = new BeerChild();
    ch2_8.setName(this.getString(R.string.b228));
    list22B.add(ch2_8);
    BeerChild ch2_9 = new BeerChild();
    ch2_9.setName(this.getString(R.string.b222));
    list22B.add(ch2_9);
    
    gru2.setItems(list22B);
    
    BeerGroup gru3 = new BeerGroup();
    gru3.setName(this.getString(R.string.c220));
    BeerChild ch3_1 = new BeerChild();
    ch3_1.setName(this.getString(R.string.c221));
    list22C.add(ch3_1);
    BeerChild ch3_2 = new BeerChild();
    ch3_2.setName(this.getString(R.string.c222));
    list22C.add(ch3_2);
    BeerChild ch3_3 = new BeerChild();
    ch3_3.setName(this.getString(R.string.c223));
    list22C.add(ch3_3);
    BeerChild ch3_4 = new BeerChild();
    ch3_4.setName(this.getString(R.string.c224));
    list22C.add(ch3_4);
    BeerChild ch3_5 = new BeerChild();
    ch3_5.setName(this.getString(R.string.c225));
    list22C.add(ch3_5);
    BeerChild ch3_6 = new BeerChild();
    ch3_6.setName(this.getString(R.string.c226));
    list22C.add(ch3_6);
    BeerChild ch3_7 = new BeerChild();
    ch3_7.setName(this.getString(R.string.c227));
    list22C.add(ch3_7);
    BeerChild ch3_8 = new BeerChild();
    ch3_8.setName(this.getString(R.string.c228));
    list22C.add(ch3_8);
    BeerChild ch3_9 = new BeerChild();
    ch3_9.setName(this.getString(R.string.c222));
    list22C.add(ch3_9);
    
    gru3.setItems(list22C);
	
	list.add(gru1);
    list.add(gru2);
    list.add(gru3);
	
	return list;

}
public ArrayList<BeerGroup> Group23() {
	
	ArrayList<BeerGroup> list = new ArrayList<BeerGroup>();
	
	ArrayList<BeerChild> list23A = new ArrayList<BeerChild>();
	
    BeerGroup gru1 = new BeerGroup();
    gru1.setName(this.getString(R.string.a230));
    BeerChild ch1_1 = new BeerChild();
    ch1_1.setName(this.getString(R.string.a231));
    list23A.add(ch1_1);
    BeerChild ch1_2 = new BeerChild();
    ch1_2.setName(this.getString(R.string.a232));
    list23A.add(ch1_2);
    BeerChild ch1_3 = new BeerChild();
    ch1_3.setName(this.getString(R.string.a233));
    list23A.add(ch1_3);
    BeerChild ch1_4 = new BeerChild();
    ch1_4.setName(this.getString(R.string.a234));
    list23A.add(ch1_4);
    BeerChild ch1_5 = new BeerChild();
    ch1_5.setName(this.getString(R.string.a235));
    list23A.add(ch1_5);
    BeerChild ch1_6 = new BeerChild();
    ch1_6.setName(this.getString(R.string.a236));
    list23A.add(ch1_6);
    BeerChild ch1_7 = new BeerChild();
    ch1_7.setName(this.getString(R.string.a237));
    list23A.add(ch1_7);
    BeerChild ch1_8 = new BeerChild();
    ch1_8.setName(this.getString(R.string.a238));
    list23A.add(ch1_8);
    BeerChild ch1_9 = new BeerChild();
    ch1_9.setName(this.getString(R.string.a239));
    list23A.add(ch1_9);
    
    gru1.setItems(list23A);
    
    list.add(gru1);
	
	return list;

}


    
    
    



}
