// =========================================
// Name: main.cpp
// Author: Dan Socaciu
// Version: 1.0
// Description: Stock Quote program
// =========================================

#include <iostream>
using namespace std;

//Structure for quote contains name (char of 12), bid price, bid size,
//ask price, ask size, last price and total volume
struct quote
{
	char name[12];
	float bid_price;
	int bid_size;
	float ask_price;
	int ask_size;
	float last_price;
	int total_vol;
};

//print function takes in the array of quotes and the total size of the array
void printResults(quote array[], int length)
{
	for (int i=0;i<length;i++)
	{
		cout <<"Name:"<< array[i].name
		<<";Bid Price:"<<array[i].bid_price
		<<";Bid Size:"<<array[i].bid_size
		<<";Ask Price:"<<array[i].ask_price
		<<";Ask Size:"<<array[i].ask_size
		<<";Last Price:"<<array[i].last_price
		<<";Total Volume:"<<array[i].total_vol<<endl;
	}
}

int main()
{
	//array of 10 quotes
	quote portfolio[10];


	int i=0;
	//get the user input for the stock quotes
	while(i<10)
	{
		cout <<"Please enter Stock Name"<<endl;
		cin >> portfolio[i].name;
		cout <<"Please enter Bid Price for "<<portfolio[i].name<<endl;
		cin >> portfolio[i].bid_price;
		cout <<"Please enter Bid Size for "<<portfolio[i].name<<endl;
		cin >> portfolio[i].bid_size;
		cout <<"Please enter Ask Price for "<<portfolio[i].name<<endl;
		cin >> portfolio[i].ask_price;
		cout <<"Please enter Ask Size for "<<portfolio[i].name<<endl;
		cin >> portfolio[i].ask_size;
		cout <<"Please enter Last Price for "<<portfolio[i].name<<endl;
		cin >> portfolio[i].last_price;
		cout <<"Please enter Volume for "<<portfolio[i].name<<endl;
		cin >> portfolio[i].total_vol;


		i++;
	}
	//quick informational statement
	cout<<"Input completed, printing out results"<<endl;

	//function which prints out the user input
	printResults(portfolio, 10);

	return 0;


}