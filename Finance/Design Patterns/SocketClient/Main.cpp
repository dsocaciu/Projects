/***
	Main.cpp - This is the main program for our team project to implement the long/short trading strategy
		using 5 Design Patterns.

	Date: Dec 14, 2012
	By: Dan Socaciu, Zhe Zhou, Brian Higgins
***/

#ifdef _WIN32
# include <Windows.h>
# define sleep( seconds) Sleep( seconds * 1000);
#else
# include <unistd.h>
#endif

#include <iostream>
#include <string>
#include <windows.h>
#include <vector>
#include "Logger.h"

#include "Factory.h"
#include "MyOrder.h"
#include "PosixTestClient.h"

using namespace std;

// The Book class implements the Singleton design pattern.
// It is used to insert an order into the Book. The book is
// a vector of pointers to MyOrder.
class Book
{
    vector<MyOrder*> book;
    static Book *s_instance;
    Book()
    {
        
    }
  public:
	void insert(MyOrder * _ord)
	{
		book.push_back(_ord);
	}
	vector<MyOrder *> getBook()
	{
		return book;
	}
    static Book *instance()
    {
        if (!s_instance)
          s_instance = new Book;
        return s_instance;
    }
};

Book *Book::s_instance = 0;

const unsigned MAX_ATTEMPTS = 50;
const unsigned SLEEP_TIME = 10;

// The TemplateProcess object implements the Template Function Design Pattern.
// It is used to retrieve the input from the user for the long and short stock order information.
class TemplateProcess {
	public:
		string longStock;
		int longQuantity;
		float longLimit;

		string shortStock;
		int shortQuantity;
		float shortLimit;
		float tradeTriggerPct;

		void performTemplateProcess(){
			retrieveLongStock();
			retrieveLongShares();
			retrieveLongLimit();
			retrieveShortStock();
			retrieveShortShares();
			retrieveShortLimit();
		}
		virtual void retrieveLongStock()=0;
		virtual void retrieveLongShares()=0;
		virtual void retrieveLongLimit()=0;
		virtual void retrieveShortStock()=0;
		virtual void retrieveShortShares()=0;
		virtual void retrieveShortLimit()=0;
};

// The InputProcess object is derived from the TemplateProcess object, and
// contains the methods which prompt for input of the long and short stock order
// information.
class InputProcess: public TemplateProcess {
	public:
		void retrieveLongStock() {
			cout << "Enter Stock Symbol you wish to Long : ";
			cin >> longStock;
		}
		void retrieveLongShares(){
			cout << "Enter number of shares you wish to Long : ";
			cin >> longQuantity;
		}
		void retrieveLongLimit(){
			cout << "Enter the limit for the stock you wish to Long : ";
			cin >> longLimit;
		}
		void retrieveShortStock() {
			cout << "Enter Stock Symbol you wish to Short : ";
			cin >> shortStock;
		}
		void retrieveShortShares(){
			cout << "Enter number of shares you wish to Short : ";
			cin >> shortQuantity;
		}
		void retrieveShortLimit(){
			cout << "Enter the limit for the stock you wish to Short : ";
			cin >> shortLimit;
		}
};

// Main - this is main part of the program. It calls each of the design pattern objects
// to manage the order book transactions. The program listens on the IB socket client
// in infinite loop and handles socket messages.
int main(int argc, char** argv)
{

	Logger::Instance()->print("start running \n");

	const char* host = argc > 1 ? argv[1] : "";
	unsigned int port = 7496;
	int clientId = 0;

	//vector<MyOrder*> book;
	int i=0;

	// Call Template Method pattern to manage input
	TemplateProcess *inputProcess = new InputProcess();
	inputProcess->performTemplateProcess();

	//cout << "You have entered the following information to run the Long/Short Trading Strategey... ";
	//cout << "Long Stock: " << inputProcess->longStock << "\n";
	//cout << "Short Stock: " << inputProcess->shortStock << "\n";
	//cout << "Trade Trigger Percent: " << inputProcess->tradeTriggerPct << "\n";

	// Use Bridge pattern to implement the buy order quote
	QuoteBridge * qptr = 0;

	QuoteBridgeBuy buy(inputProcess->longStock, inputProcess->longLimit, inputProcess->longQuantity);

	Logger::Instance()->print("Long Stock is %f \n",inputProcess->longStock);
	Logger::Instance()->print("Long Limit is %f \n",inputProcess->longLimit);
	Logger::Instance()->print("Long Share Quantity is %f \n",inputProcess->longQuantity);

	/*
	Zhe's code
	BuyFactory buyFac;
	Order* buyOrder = buyFac.GenerateOrder();
	buyOrder->Output();

	SellFactory sellFac;
	Order* sellOrder = sellFac.GenerateOrder();
	sellOrder->Output();
	*/

	qptr = &buy;

	// Use the Factory and Prototype patterns to generate a buy order for the order book.
	//Factory *fac = new BuyFactory();
	BuyFactory buyFac;
	Book::instance()->insert(buyFac.GenerateOrder(i++,qptr));
	//book.push_back(fac->GenerateOrder(i++,qptr));
	//newOrder->Output();

	// Use Bridge pattern to implement the sell order quote
	QuoteBridgeSell sell(inputProcess->shortStock, inputProcess->shortLimit, inputProcess->shortQuantity);

	Logger::Instance()->print("Short Stock is %f \n",inputProcess->shortStock);
	Logger::Instance()->print("Short Limit is %f \n",inputProcess->shortLimit);
	Logger::Instance()->print("Short Share Quantity is %f \n",inputProcess->shortQuantity);

	qptr = &sell;

	// Use the Factory and Prototype patterns to generate a sell order for the order book.
	SellFactory Sellfac;
	Book::instance()->insert(Sellfac.GenerateOrder(i++,qptr));
	//book.push_back(fac->GenerateOrder(i++,qptr));
	//newOrder->Output();

	unsigned attempt = 0;
	Logger::Instance()->print( "Start of POSIX Socket Client Test %u\n", attempt);

	// Infinite loop runs here as the program listens on the IB socket and processes messages
	// it receives.
	for (;;) {
		++attempt;
		printf( "Attempt %u of %u\n", attempt, MAX_ATTEMPTS);

		PosixTestClient client;

		
			// connect to client socket
		client.connect( host, port, clientId);

			// if connected, process messages.
		while( client.isConnected()) {
			client.processMessages(Book::instance()->getBook());
		}

		if( attempt >= MAX_ATTEMPTS) {
			break;
		}

		printf( "Sleeping %u seconds before next attempt\n", SLEEP_TIME);
		sleep( SLEEP_TIME);
	}

	printf ( "End of POSIX Socket Client Test\n");
}

