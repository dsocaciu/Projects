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

//vector<Order> InputData;
class BuyBook{
	map<int, BuyOrder> Book;
	map<float, BuyOrder> snapBook;

	static BuyBook *b_instance;
	BuyBook()
	{

	}

public:
	void insert(BuyOrder in)
	{
		//cout <<"order id" << in.getOrderId() <<"shares"<< in.getShare() << endl;
		Book.insert(pair<int,BuyOrder>(in.getOrderId(),in));
	}

	void cancel(BuyOrder in)
	{
		map<int, BuyOrder>::iterator ob;
		ob = Book.find(in.getOrderId());
		ob->second.setShare(ob->second.getShare()-in.getShare());
	}

	void execute(BuyOrder in)
	{
		map<int, BuyOrder>::iterator ob;
		ob = Book.find(in.getOrderId());
		ob->second.setShare(ob->second.getShare()-in.getShare());
	}

	void processBook()
	{
		map<int, BuyOrder>::iterator bb;
		map<float, BuyOrder>::iterator sb;


		//running through the book
		for(bb = Book.begin();bb!=Book.end();bb++)
		{
			sb = snapBook.find(bb->second.getPrice());
			if(sb==snapBook.end())
			{
				snapBook.insert(pair<float,BuyOrder>(bb->second.getPrice(),bb->second));
			}
			else
			{
				//cout<<"Updating processes"<<endl;
				//cout<<sb->first << " " << sb->second.getShare() << " " << bb->second.getShare() << endl;
				//sb = snapBook.find(bb->second.getPrice());
				sb->second.setShare(sb->second.getShare()+bb->second.getShare());
			}
		}
	}

	void print()
	{
		map<int, BuyOrder>::iterator bb;
		//running through the book
		for(bb = Book.begin();bb!=Book.end();bb++)
		{
			//cout<<"Symbol: "<<ob->second.getSymbol()<<endl;//<<" ,Shares: "<<ob->second.getShare()<<endl;
			//cout <<ob->first<<endl;
			cout<<"Buy Order id: "<<bb->second.getOrderId()<<" "<<bb->second.getPrice()<<" "<<bb->second.getShare()<<endl;

			//cout<<"Symbol: "<<ob->second.getBridge()->getSymbol()<<endl;
			//cout<<"Shares: "<<ob->second.getShare()<<endl;
		}
	}

	void printSnap()
	{
		map<float, BuyOrder>::iterator sb;
		for(sb = snapBook.begin();sb!=snapBook.end();sb++)
				{
					//cout<<"Symbol: "<<ob->second.getSymbol()<<endl;//<<" ,Shares: "<<ob->second.getShare()<<endl;
					//cout <<ob->first<<endl;
					cout<<sb->second.getSide()<<" "<<sb->second.getPrice()<<" "<<sb->second.getShare()<<endl;

					//cout<<"Symbol: "<<ob->second.getBridge()->getSymbol()<<endl;
					//cout<<"Shares: "<<ob->second.getShare()<<endl;
				}
	}

	void printBest()
		{
			map<float, BuyOrder>::iterator sb;
			sb = snapBook.begin();
			cout <<endl << sb->second.getSide() <<" " << sb->second.getShare() << " at " << sb->first << endl;
		}

	static BuyBook *instance()
	{
		if(!b_instance)
			b_instance = new BuyBook;
		return b_instance;
	}
};

BuyBook *BuyBook::b_instance=0;

class SellBook{
	map<int, SellOrder> Book;
	map<float, SellOrder> snapBook;
	static SellBook *s_instance;
	SellBook()
	{

	}

public:
	void insert(SellOrder in)
	{
		Book.insert(pair<int,SellOrder>(in.getOrderId(),in));
	}

	void cancel(SellOrder in)
	{
		map<int, SellOrder>::iterator sb;
		sb = Book.find(in.getOrderId());
		sb->second.setShare(sb->second.getShare()-in.getShare());
	}

	void execute(SellOrder in)
	{
		map<int, SellOrder>::iterator sb;
		sb = Book.find(in.getOrderId());
		sb->second.setShare(sb->second.getShare()-in.getShare());
	}


	void print()
	{
		map<int, SellOrder>::iterator sb;
		//running through the book
		for(sb = Book.begin();sb!=Book.end();sb++)
		{
			//cout<<"Symbol: "<<ob->second.getSymbol()<<endl;//<<" ,Shares: "<<ob->second.getShare()<<endl;
			//cout <<ob->first<<endl;
			cout<<"Sell Order id: "<<sb->second.getOrderId()<<" "<<sb->second.getShare()<<endl;

			//cout<<"Symbol: "<<ob->second.getBridge()->getSymbol()<<endl;
			//cout<<"Shares: "<<ob->second.getShare()<<endl;
		}
	}

	void processBook()
	{
		map<int, SellOrder>::iterator bb;
		map<float, SellOrder>::iterator sb;


		//running through the book
		for(bb = Book.begin();bb!=Book.end();bb++)
		{
			sb = snapBook.find(bb->second.getPrice());
			if(sb==snapBook.end())
			{
				snapBook.insert(pair<float,SellOrder>(bb->second.getPrice(),bb->second));
			}
			else
			{
				//cout<<"Updating processes"<<endl;
				//cout<<sb->first << " " << sb->second.getShare() << " " << bb->second.getShare() << endl;
				//sb = snapBook.find(bb->second.getPrice());
				sb->second.setShare(sb->second.getShare()+bb->second.getShare());
			}
		}
	}

	void printSnap()
		{
			map<float, SellOrder>::iterator sb;
			for(sb = snapBook.begin();sb!=snapBook.end();sb++)
					{
						//cout<<"Symbol: "<<ob->second.getSymbol()<<endl;//<<" ,Shares: "<<ob->second.getShare()<<endl;
						//cout <<ob->first<<endl;
						cout<<sb->second.getSide()<<" "<<sb->second.getPrice()<<" "<<sb->second.getShare()<<endl;

						//cout<<"Symbol: "<<ob->second.getBridge()->getSymbol()<<endl;
						//cout<<"Shares: "<<ob->second.getShare()<<endl;
					}
		}

	void printBest()
	{
		map<float, SellOrder>::iterator sb;
		sb = snapBook.begin()--;
		cout << sb->second.getSide() <<" " << sb->second.getShare() << " at " << sb->first << endl;
	}

	static SellBook *instance()
	{
		if(!s_instance)
			s_instance = new SellBook;
		return s_instance;
	}
};

SellBook *SellBook::s_instance=0;




//get InputData
// function that converts the line data to an Order object
void lineToOrder(string line)
{
//	cout<<line<<endl;
//	Order temp;
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
	istringstream price_(tempV[5]);
	price_ >> price;
	istringstream share_(tempV[6]);
	share_ >> share;

	if(tempV[3].compare("Buy")==0)
	{
		//cout<<"PriceQuoteBuy"<<endl;
		//cout <<"tempV1 "<< tempV[1] << endl;
		//cout <<"Buy Shares New " <<share << endl;
		QuoteBridgeBuy buytemp(tempV[1], price, share);

		BuyOrder temp(id, buytemp,tempV[2],tempV[4]);
		//cout <<"symbol " << buytemp.getSymbol()<<endl;

		if(tempV[2].compare("New")==0)
		{

			BuyBook::instance()->insert(temp);
			price = 0, share = 0;
		}
		else if(tempV[2].compare("Cancel")==0)
		{

			BuyBook::instance()->cancel(temp);
			//cout << "Cancel Buy Order" << endl;
			//Order::Instance()->newOrder(id, ,tempV[2],tempV[4]);
		}
		else if(tempV[2].compare("Execute")==0)
		{

			BuyBook::instance()->execute(temp);
			//cout << "Execute Buy Order" << endl;
			//Order::Instance()->newOrder(id, ,tempV[2],tempV[4]);
		}

	}
	else if(tempV[3].compare("Sell")==0)
	{
		//cout<<"PriceQuoteSell"<<endl;
		QuoteBridgeSell selltemp(tempV[1], price, share);

		SellOrder temp(id, selltemp,tempV[2],tempV[4]);
		//cout<<ptr->getSide()<<endl;
		if(tempV[2].compare("New")==0)
		{

			//cout << "New Sell Order" << endl;
			SellBook::instance()->insert(temp);
		}
		else if(tempV[2].compare("Cancel")==0)
		{
			SellBook::instance()->cancel(temp);
			//cout << "Cancel Sell Order" << endl;
			//Order::Instance()->newOrder(id, ,tempV[2],tempV[4]);
		}
		else if(tempV[2].compare("Execute")==0)
		{
			SellBook::instance()->cancel(temp);
			//cout << "Execute Sell Order" << endl;
			//Order::Instance()->newOrder(id, ,tempV[2],tempV[4]);
		}

	}
}

//function that detects the first line of the InputData and skips it
void readLine(string line)
{
	//cout << "in readLine" << endl;
//	Order temp;
	//Skip the first line of the InputData --- OrderID, Symbol ...etc
	size_t firstline;
	firstline = line.find("OrderID");

	if ((firstline==string::npos) & (!line.empty()))
	{
		//parse the lines of the order into a vector

		lineToOrder(line);

	}

}



//Function to open up the csv file and read the data line by line

void readInputData()
{
	//Order temp;
	string line;
	ifstream myfile ("MidtermInput.csv");
	  if (myfile.is_open())
	  {
	    while ( myfile.good() )
	    {
	      getline (myfile,line);
	      readLine(line);
	      //temp = readLine(line);
	      //InputData.push_back(temp);

	    }
	    myfile.close();
	  }

	  else cout << "Unable to open file";

}



// main fuction which calls the function to get the input data, process and calculate it and then print the subsequent information
int main() {
	//cout << "Processing book... please wait..." << endl; //

	readInputData();

	BuyBook::instance()->processBook();

	BuyBook::instance()->printSnap();

	SellBook::instance()->processBook();

	SellBook::instance()->printSnap();

	BuyBook::instance()->printBest();

	SellBook::instance()->printBest();

	return 0;
}
