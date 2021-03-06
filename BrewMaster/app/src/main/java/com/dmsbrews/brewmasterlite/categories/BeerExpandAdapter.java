package com.dmsbrews.brewmasterlite.categories;



import java.util.ArrayList;

import com.dmsbrews.brewmasterlite.R;


 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
	 
public class BeerExpandAdapter  extends BaseExpandableListAdapter {
	 
	    private Context context;
	    private ArrayList<BeerGroup> groups;
	    public BeerExpandAdapter(Context context, ArrayList<BeerGroup> groups) {
	        this.context = context;
	        this.groups = groups;
	    }
	     
	    public void addItem(BeerChild item, BeerGroup group) {
	        if (!groups.contains(group)) {
	            groups.add(group);
	        }
	        int index = groups.indexOf(group);
	        ArrayList<BeerChild> ch = groups.get(index).getItems();
	        ch.add(item);
	        groups.get(index).setItems(ch);
	    }
	    public Object getChild(int groupPosition, int childPosition) {
	        // TODO Auto-generated method stub
	        ArrayList<BeerChild> chList = groups.get(groupPosition).getItems();
	        return chList.get(childPosition);
	    }
	 
	    public long getChildId(int groupPosition, int childPosition) {
	        // TODO Auto-generated method stub
	        return childPosition;
	    }
	 
	    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
	            ViewGroup parent) {
	        BeerChild child = (BeerChild) getChild(groupPosition, childPosition);
	        if (view == null) {
	            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            view = infalInflater.inflate(R.layout.beerchild, null);
	        }
	        TextView tv = (TextView) view.findViewById(R.id.tvChild);
	        tv.setText(child.getName().toString());
	        tv.setTag(child.getTag());
	        // TODO Auto-generated method stub
	        return view;
	    }
	 
	    public int getChildrenCount(int groupPosition) {
	        // TODO Auto-generated method stub
	        ArrayList<BeerChild> chList = groups.get(groupPosition).getItems();
	 
	        return chList.size();
	 
	    }
	 
	    public Object getGroup(int groupPosition) {
	        // TODO Auto-generated method stub
	        return groups.get(groupPosition);
	    }
	 
	    public int getGroupCount() {
	        // TODO Auto-generated method stub
	        return groups.size();
	    }
	 
	    public long getGroupId(int groupPosition) {
	        // TODO Auto-generated method stub
	        return groupPosition;
	    }
	 
	    public View getGroupView(int groupPosition, boolean isLastChild, View view,
	            ViewGroup parent) {
	        BeerGroup group = (BeerGroup) getGroup(groupPosition);
	        if (view == null) {
	            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            view = inf.inflate(R.layout.beergroup, null);
	        }
	        TextView tv = (TextView) view.findViewById(R.id.tvGroup);
	        tv.setText(group.getName());
	        // TODO Auto-generated method stub
	        return view;
	    }
	 
	    public boolean hasStableIds() {
	        // TODO Auto-generated method stub
	        return true;
	    }
	 
	    public boolean isChildSelectable(int arg0, int arg1) {
	        // TODO Auto-generated method stub
	        return true;
	    }
	 
 }