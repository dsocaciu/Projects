//============================================================================
// Name        : Main.cpp
// Author      : Dan Socaciu
// Version     :
// Description : Runs the application, Takes in Stock and Option qutes
// 				 and outputs the results to a text file
//============================================================================

#include <iostream>
#include "Instrument.h"
#include <vector>
#include <map>
#include <fstream>

using namespace std;

//Prints the results
//Takes in a map of Stocks and a map of a vector of Options
void printResults(map<int,Stock> _Stocks, map<string,vector<Option> > _Options )
{
	//iterators for the maps and the vecotr
	map<int,Stock>::iterator s_it;
	map<string,vector<Option> >::iterator o_it;
	vector<Option>::iterator vp;

	vector<Option> v_op;

	ofstream out;
	out.open("InstrumentMap.txt");

	for(s_it = _Stocks.begin();s_it!=_Stocks.end();s_it++)
	{
		//output the stock information from the stock map
		out<<"Stock Name: "<<s_it->second.getName()
		<<"; Bid Price: "<<s_it->second.getBidPrice()
		<<"; Bid Size: "<<s_it->second.getBidSize()
		<<"; Ask Price: "<<s_it->second.getAskPrice()
		<<"; Ask Size: "<<s_it->second.getAskSize()
		<<"; Exchange: "<<s_it->second.getExchange()<<endl;

		// use the stock name to retrieve the vector of options
		o_it = _Options.find(s_it->second.getName());
		v_op = o_it->second;

		//iterate through the vector of options
		for(vp=v_op.begin();vp!=v_op.end();vp++)
		{
			out<<"     Underlying: "<<vp->getUnderlying()
			<<"; Option Name: "<<vp->getOptionName()
			<<"; Bid Price: "<<vp->getBidPrice()
			<<"; Bid Size: "<<vp->getBidSize()
			<<"; Ask Price: "<<vp->getAskPrice()
			<<"; Ask Size: "<<vp->getAskPrice()
			<<"; Expiration: "<<vp->getExpiration()
			<<endl;
		}

	}


}

int main() {

	//maps for Stock and Options
	map<int,Stock> Stocks;
	map<string,vector<Option> > Options;
	vector<Option> vop;

	//information for stocks
	string s_name;
	float s_bprice;
	int s_bsize;
	float s_aprice;
	int s_asize;
	string exchange;

	// information for options
	string underlying;
	string o_name;
	float o_bprice;
	int o_bsize;
	float o_aprice;
	int o_asize;
	string expiration;

	//takes in numbers of stocks and options
	int NumStocks, NumOptions;

	cout<<"Please enter number of Stocks: "<<endl;
	cin>>NumStocks;
	cout<<"Please enter numbers of Options per Stock: "<<endl;
	cin>>NumOptions;


	for(int i = 0;i<NumStocks;i++)
	{
		Stock st;

		cout<<"Enter in Stock Name:"<<endl;
		cin>>s_name;
		st.setName(s_name);
		cout<<"Enter in "<<s_name<<" Bid Price:"<<endl;
		cin>>s_bprice;
		st.setBidPrice(s_bprice);
		cout<<"Enter in "<<s_name<<" Bid Size:"<<endl;
		cin>>s_bsize;
		st.setBidSize(s_bsize);
		cout<<"Enter in "<<s_name<<" Ask Price:"<<endl;
		cin>>s_aprice;
		st.setAskPrice(s_aprice);
		cout<<"Enter in "<<s_name<<" Ask Size:"<<endl;
		cin>>s_asize;
		st.setAskSize(s_asize);
		cout<<"Enter in "<<s_name<<" Exchange:"<<endl;
		cin>>exchange;
		st.setExchange(exchange);

		//once stock is complete, add it to map
		Stocks.insert(pair<int,Stock>(i,st));

		for(int j=0;j<NumOptions;j++)
		{
			Option op;

			op.setUnderlyingName(s_name);
			cout<<"Enter in Option Name:"<<endl;
			cin>>o_name;
			op.setOptionName(o_name);
			cout<<"Enter in "<<o_name<<" Bid Price"<<endl;
			cin>>o_bprice;
			op.setBidPrice(o_bprice);
			cout<<"Enter in "<<o_name<<" Bid Size"<<endl;
			cin>>o_bsize;
			op.setBidSize(o_bsize);
			cout<<"Enter in "<<o_name<<" Ask Price"<<endl;
			cin>>o_aprice;
			op.setAskPrice(o_aprice);
			cout<<"Enter in "<<o_name<<" Ask Size"<<endl;
			cin>>o_asize;
			op.setAskSize(o_asize);
			cout<<"Enter in "<<o_name<<" Expiration"<<endl;
			cin>>expiration;
			op.setExpiration(expiration);

			//once option is complete, add it to the vector
			vop.push_back(op);
		}

		//once the vector of options, add it to the map with the stock name as a key
		Options.insert(pair<string,vector<Option> >(s_name,vop));

	}

	//call the results function described aboce
	printResults(Stocks,Options);

	return 0;
}
