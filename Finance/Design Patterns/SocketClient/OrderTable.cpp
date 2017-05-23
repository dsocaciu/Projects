#include "OrderTable.h"
#include <stdarg.h>
#include <fstream>
#include <iostream>

using namespace std;

OrderTable * OrderTable::s_instance = NULL;

OrderTable::OrderTable(void)
{
}
 
OrderTable::~OrderTable(void)
{
}

OrderTable* OrderTable::Instance()
{
   if (!s_instance)   // Only allow one instance of class to be generated.
        s_instance = new OrderTable;

   return s_instance;
}

void OrderTable::readCsv()
{
	ifstream myfile("C:\\Users\\Zhe\\Desktop\\Midterm.csv");
	string title;
	getline(myfile, title);		// Jump the head line.

	string line;

	vector<string> StringVec;	// Define a string to save each line.

	while (myfile.good())
	{
		getline(myfile, line);	// Read a line.

		char * str = new char[200];
		strcpy(str, line.c_str());		// Transfer atring to char array, in order to split it.

		for (const char * p = strtok( str, ","); p; p = strtok(NULL, ","))
		{ StringVec.push_back(p); }		// // Split and push all element into a string vector.
	}
	
	vector<string>::iterator itString = StringVec.begin();
	OrderQuote thisOrderQ;						// Build a order to save each line and push to OrderVec.

	while (itString != StringVec.end())
	{
		if ((*itString==""))
		break;			// Jump out when reach the end of csv file.

		thisOrderQ.OrderID = atoi((*itString).c_str());		//Auto change string into int.
		itString += 1;									// Iterator move to nex element, which is symbol.

		thisOrderQ.Symbol = *itString;
		itString += 1;				// Next element is action.

		thisOrderQ.Action = *itString;
		itString += 1;				// Next one is side.

		thisOrderQ.Side = *itString;
		itString+=1;				// Next one is Time.

		thisOrderQ.Price = atof((*itString).c_str());
		itString+=1;				// Next one is share, long.

		thisOrderQ.Share = atol((*itString).c_str());
		itString+=1;				// iterator goes back to OrderID. Next loop.

		OrderVec.push_back(thisOrderQ);		// Push thisOrder to vector.
	}
}

