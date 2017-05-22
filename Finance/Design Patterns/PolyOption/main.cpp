//============================================================================
// Name        : main.cpp
// Author      : Dan Socaciu
// Version     : 1.0
// Description : main application to run instruments to demo
// 				 polymorphism
//============================================================================

#include <iostream>
#include <fstream>
#include "Instrument.h"
using namespace std;

//Quick function to announce intentions of application
void enterQuotes()
{
	cout<<"Enter instrument quotes"<<endl;
}

//Print function takes in a stock array and option array and outputs to
//a file entitled PolyExample.txt
void printQuotes(Stock stocks[], Option options[])
{

	ofstream myfile;
	myfile.open ("PolyExample.txt");

	Option opt;
	Stock stk;
	Instrument * instru1 = &opt;
	Instrument * instru2 = &stk;

	for(int i =0;i<10;i++)
	{
		stk=stocks[i];
		myfile<<"Stock Name: "<<stk.name
		<<" ;Bid Price: "<<instru2->getBidPrice()
		<<" ;Bid Size: "<<instru2->getBidSize()
		<<" ;Ask Price: "<<instru2->getAskPrice()
		<<" ;Ask Size: "<<instru2->getAskSize()
		<<" ;Exchange: "<<stk.getExchange()<<endl;

		opt=options[i];
		myfile<<"Option Name: "<<opt.option_name
		<<" ;Bid Price: "<<instru1->getBidPrice()
		<<" ;Bid Size: "<<instru1->getBidSize()
		<<" ;Ask Price: "<<instru1->getAskPrice()
		<<" ;Ask Size: "<<instru1->getAskSize()
		<<" ;Expiration: "<<opt.getExpiration()<<endl;


	}


}



//main function which prints the intention, contains an iterative loop
//to take input and upon completion output the information
int main() {

	//variables
	Option opt;
	Stock stk;

	float stk_bprice;
	int stk_bsize;
	float stk_aprice;
	int stk_asize;
	string exchange;

	float opt_bprice;
	int opt_bsize;
	float opt_aprice;
	int opt_asize;
	string expiration;



	Instrument * instru1 = &opt;
	Instrument * instru2 = &stk;

	Stock stk_portfolio[10];
	Option opt_portfolio[10];

	enterQuotes();

	//loop for the 10 instruments
	for(int i =0;i<10;i++)
	{

		cout<<"Please enter stock name:"<<endl;
		cin>>stk.name;
		cout<<"Please enter stock bid price:"<<endl;
		cin>>stk_bprice;
		instru2->setBidPrice(stk_bprice);
		cout<<"Please enter stock bid size:"<<endl;
		cin>>stk_bsize;
		instru2->setBidSize(stk_bsize);
		cout<<"Please enter stock ask price:"<<endl;
		cin>>stk_aprice;
		instru2->setAskPrice(stk_aprice);
		cout<<"Please enter stock ask size:"<<endl;
		cin>>stk_asize;
		instru2->setAskSize(stk_asize);
		cout<<"Please enter stock exchange:"<<endl;
		cin>>exchange;
		stk.setExchange(exchange);


		stk_portfolio[i]=stk;

		cout<<"Please enter option name:"<<endl;
		cin>>opt.option_name;
		cout<<"Please enter option bid price:"<<endl;
		cin>>opt_bprice;
		instru1->setBidPrice(opt_bprice);
		cout<<"Please enter option bid size:"<<endl;
		cin>>opt_bsize;
		instru1->setBidSize(opt_bsize);
		cout<<"Please enter option ask price:"<<endl;
		cin>>opt_aprice;
		instru1->setAskPrice(opt_aprice);
		cout<<"Please enter option ask size:"<<endl;
		cin>>opt_asize;
		instru1->setAskSize(opt_asize);
		cout<<"Please enter expiration date:"<<endl;
		cin>>expiration;
		opt.setExpiration(expiration);

		opt_portfolio[i] = opt;




	}

	//print function
	printQuotes(stk_portfolio,opt_portfolio);


	return 0;
}
