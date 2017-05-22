//============================================================================
// Name        : main.cpp
// Author      : Dan Socaciu
// Version     : 1.0
// Description : Run the order book
//============================================================================

#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <stdio.h>
#include <stdlib.h>
#include <map>

#include "Order.h"

using namespace std;

vector<Order> InputData;
map<int, Order> Book;

//get InputData
// function that converts the line data to an Order object
Order lineToOrder(string line)
{
	Order temp;
	int i = 0;
	int id;
	float price;
	int share;
	string tempV[7];

	istringstream iss(line);


	while (iss)
	    {
	      string s;
	      if (!getline( iss, s, ',' )) break;
	      //cout<<"s: " << s << endl;
	      tempV[i] = s;
	      i++;

	    }

	istringstream id_(tempV[0]);
	id_ >> id;

	temp.setOrderId(id);

	temp.setSymbol(tempV[1]);
	temp.setAction(tempV[2]);
	temp.setSide(tempV[3]);
	temp.setTime(tempV[4]);

	istringstream price_(tempV[5]);
	price_ >> price;
	temp.setPrice(price);

	istringstream share_(tempV[6]);
	share_ >> share;
	temp.setShare(share);

	temp.setExecute(false);

	return temp;
}

//function that detects the first line of the InputData and skips it
Order readLine(string line)
{
	Order temp;
	//Skip the first line of the InputData --- OrderID, Symbol ...etc
	size_t firstline;
	firstline = line.find("OrderID");

	if ((firstline==string::npos) & !line.empty())
	{
		//parse the lines of the order into a vector
		temp = lineToOrder(line);

		//cout <<"Line: "<<line<<endl;
		//cout <<"Order id: "<<temp.getOrderId()<< endl;

		
	}

	return temp;

}

//Function to open up the csv file and read the data line by line

void readInputData()
{
	Order temp;
	string line;
	ifstream myfile ("MidtermInput.csv");
	  if (myfile.is_open())
	  {
	    while ( myfile.good() )
	    {
	      getline (myfile,line);
	      //readLine(line);
	      temp = readLine(line);
	      InputData.push_back(temp);

	    }
	    myfile.close();
	  }

	  else cout << "Unable to open file";

}


//process InputData
// takes the original InputData and processes to an Book of Orders
void processInputData()
{

	vector<Order>::iterator vo;
	vo = InputData.begin();
	InputData.erase(vo);

	map<int, Order>::iterator ob;

	//running through the book
	for(vo = InputData.begin();vo!=InputData.end();vo++)
	{

		//include the new orders
		if(vo->getAction().compare("New")==0)
		{
			//cout <<"inserting order " << vo->getOrderId() << endl;
			Book.insert(pair<int,Order>(vo->getOrderId(), *vo));
		}
		//originally canceled the entire order however re-engineered to cancel based on the shares
		else if(vo->getAction().compare("Cancel")==0)
		{
			//cout <<"removing order " << vo->getOrderId() << endl;
			ob = Book.find(vo->getOrderId());
			//Book.erase(ob);
			if(vo->getSide().compare("Buy")==0)
			{
				ob->second.setShare(ob->second.getShare()+vo->getShare());
			}
			else if (vo->getSide().compare("Sell")==0)
			{
				ob->second.setShare(ob->second.getShare()-vo->getShare());
			}
		}
		// changes the execute flag to true
		else if(vo->getAction().compare("Execute")==0)
		{
			//mymap.find('a')->second << endl;
			ob = Book.find(vo->getOrderId());
			//cout <<"set order " <<vo->getOrderId() << " to execute" <<endl;
			ob->second.setExecute(true);
		}

	}
}
//print Book
// runs through the processed orders and prints out the orders with execute flag set to true
void printSnapshot()
{
	map<int, Order>::iterator ob;

	cout <<"Printing snapshot (executed orders): " << endl;

	for(ob = Book.begin();ob!=Book.end();ob++)
	{
		//Assuming to print only items with excute flag true
		if(ob->second.getExecute())
		{
			cout  << ob->second.getSide() << ", "
			<< ob->second.getPrice() << ", "
			<< ob->second.getShare() << endl;
		}

	}
}

//structure to help with display of orders based on prices
struct snapshot{
	string bs;
	float price;
	int share;
};

//function to print the orders as ordered by prices
void printSnapshotNumbers()
{
	map<float, snapshot> snap;
	map<int, Order>::iterator ob;

	map<float, snapshot>::iterator sp;

	cout <<"\nPrinting snapshot (consolidated prices): " << endl;

	for(ob = Book.begin();ob!=Book.end();ob++)
	{
		snapshot temp;
		//cout <<"Book Price " << ob->second.getPrice() <<endl;
		sp = snap.find(ob->second.getPrice());

		//cout << sp->second.bs << " " << sp->second.price << endl;

		//snap.insert(pair<float,snapshot>(ob->second.getPrice(),temp));
		if(!snap.empty())
		{
			if( sp->first == ob->second.getPrice() & ob->second.getAction().compare("Execute")!=0)
			{
				temp.bs = ob->second.getSide();
				temp.price = ob->second.getPrice();
				if(sp->second.bs.compare("Sell")==0)
				{
					//cout <<"Sell Price exists " <<endl;
					temp.share -= ob->second.getShare();
				}
				else /*if(sp->second.bs.compare("Buy")==0)*/
				{
					//cout <<"Buy Price exists " <<endl;
					temp.share += ob->second.getShare();
				}
				snap.insert(pair<float,snapshot>(ob->second.getPrice(),temp));
			}
			else
			{
				temp.bs = ob->second.getSide();
				temp.price = ob->second.getPrice();
				temp.share = ob->second.getShare();
				snap.insert(pair<float,snapshot>(ob->second.getPrice(),temp));
			}

		}
		else
		{
			//cout <<"first entry"<<endl;
			temp.bs = ob->second.getSide();
			temp.price = ob->second.getPrice();
			temp.share = ob->second.getShare();
			snap.insert(pair<float,snapshot>(ob->second.getPrice(),temp));
		}

	}

	for(sp = snap.begin();sp!=snap.end();sp++)
	{

		cout << sp->second.bs << ", " << sp->first <<
		", " << sp->second.share << endl;


	}


}

//function which finds the highest and lowest prices and prints out the results
void printBest()
{
	map<int, Order>::iterator ob;

	cout << "\nThe Best buy and best sell price : " << endl;
	float min=9999999999999;//set min to high number
	float max = 0;
	int min_id;
	int max_id;
	for(ob = Book.begin();ob!=Book.end();ob++)
	{
		//cout << ob->second.getPrice() << endl;
		//find the min price and set if less
		if(ob->second.getPrice() < min & ob->second.getSide().compare("Buy")==0)
		{
			min = ob->second.getPrice();
			//cout << min <<endl;
			min_id = ob->first;
		}
		//find the max price and set if greater
		if(max < ob->second.getPrice() & ob->second.getSide().compare("Sell")==0)
				{
					max = ob->second.getPrice();
					//cout << min <<endl;
					max_id = ob->first;
				}


	}

	//Buy 200 at 19.99, Sell 300 at 20 at.

	//cout << min_id << " " << min << endl;
	ob = Book.find(min_id);
	cout <<ob->second.getSide() << " " << ob->second.getShare()<< " at " << ob->second.getPrice() << endl;

	ob = Book.find(max_id);
	cout <<ob->second.getSide() << " " << ob->second.getShare()<< " at " << ob->second.getPrice() << endl;

}

// main fuction which calls the function to get the input data, process and calculate it and then print the subsequent information
int main() {
	//cout << "Processing book... please wait..." << endl; //

	readInputData();

	processInputData();

	printSnapshot();

	printSnapshotNumbers();

	printBest();

	return 0;
}
