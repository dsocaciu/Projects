// This header iss handling the history data. I assume it's a order book and used our midterm file.

#ifndef ORDERATBLE_H_
#define ORDERATBLE_H_

#include "Order.h"
#include <string>
#include <stdio.h>
#include <vector>

using namespace std;

class OrderTable
{
private:
	OrderTable(void);					// cannot intantiate an object 
	OrderTable(OrderTable const&){};    // cannot copy
	~OrderTable(void);

	vector<OrderQuote> OrderVec;			// save all orders in the csv.
	
public:
	static OrderTable* Instance();     // get Instance
	static OrderTable* s_instance;	

	void readCsv();				// save to OrderVec




	vector<OrderQuote> GetVec()
	{
		return OrderVec;
	}
};

#endif