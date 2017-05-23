#ifndef ORDERQUOTE_H_
#define ORDERQUOTE_H_

#include <string>
using namespace std;

struct OrderQuote
{
	int OrderID;
	string Symbol, Action, Side;
	double Price;
	long Share;
};


#endif