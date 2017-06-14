package com.dmsbrews.brewmasterlite.categories;

import java.util.ArrayList;
	 
public class BeerGroup {
	  
	    private String Name;
	    private ArrayList<BeerChild> Items;
	     
	    public String getName() {
	        return Name;
	    }
	    public void setName(String name) {
	        this.Name = name;
	    }
	    public ArrayList<BeerChild> getItems() {
	        return Items;
	    }
	    public void setItems(ArrayList<BeerChild> Items) {
	        this.Items = Items;
	    }
	     
	  

}
