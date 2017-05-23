/***
	MyOrder.h - Header file to implement the factory pattern and virtual constructor pattern.
		Both buy and sell orders are cloned using this pattern.

	Date: Dec 14, 2012
	By: Dan Socaciu, Zhe Zhou, Brian Higgins
***/

// This file includes 3 class. The two son classes "BuyOrder" and "SellOrder" derive from the base "Order".
// I assume, since the signal appears, new orders are generated and sent to IB.
// In this file, I am using factory pattern and virtual constructor pattern.


#ifndef MYORDER_H_
#define MYORDER_H_

#include <string>
#include "QuoteBridge.h"
using namespace std;

// Order object

class MyOrder
{
protected:
	//OrderQuote OrderQ;

	
public:
	virtual MyOrder* clone() = 0;
/*	
	virtual void setPrice(double Price_)=0;
	virtual void setShare(long Share_)=0;*/
	virtual float getPrice()=0;
	virtual string getSymbol()=0;
	virtual string getSide()=0;
	virtual int getShare()=0;

	virtual void Output()=0;
};

// Buy Order object derived from MyOrder

class BuyOrder : public MyOrder
{
private:
	QuoteBridgeBuy qptr;
	int orderId;

public:
	virtual MyOrder* clone();
	
	void setPrice(double Price_);
	void setShare(long Share_);
	float getPrice(){return qptr.getPrice();}
	string getSide(){return qptr.getSide();}
	string getSymbol(){return qptr.getSymbol();}
	int getShare(){return qptr.getShare();}
	BuyOrder(){}
	BuyOrder(int _orderid, QuoteBridgeBuy & _qptr);

	void Output();
};

// Sell Order object derived from MyOrder
class SellOrder : public MyOrder
{
private:
	QuoteBridgeSell qptr;
	int orderId;

public:
	virtual MyOrder* clone();
	
	SellOrder(){}
	SellOrder(int _orderid, QuoteBridgeSell & _qptr);
	
	void setPrice(double Price_);
	void setShare(long Share_);
	float getPrice(){return qptr.getPrice();}
	string getSide(){return qptr.getSide();}
	int getShare(){return qptr.getShare();}
	string getSymbol(){return qptr.getSymbol();}

	void Output();
};


#endif