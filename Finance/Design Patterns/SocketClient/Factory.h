/***
	Factory.h - Header file used to implement the Factory design pattern.
		Both buy and sell orders are generated from the factory.

	Date: Dec 14, 2012
	By: Dan Socaciu, Zhe Zhou, Brian Higgins
***/
// Here I use factory method design pattern to generate orders.

#ifndef FACTORY_H_
#define FACTORY_H_

#include "MyOrder.h"
#include <iostream>
#include <string>

using namespace std;

class MyOrder;
class BuyOrder;
class SellOrder;

class Factory
{
public:
	virtual MyOrder* GenerateOrder() = 0;
	virtual MyOrder* GenerateOrder(int _orderid, QuoteBridge * _qptr)=0;
	//virtual MyOrder* GenerateOrder(int _orderid, QuoteBridgeSell & _qptr)=0;
};

class BuyFactory : public Factory
{
public:
	MyOrder* GenerateOrder();
	MyOrder* GenerateOrder(int _orderid, QuoteBridge * _qptr);
};

class SellFactory : public Factory
{
public:
	MyOrder* GenerateOrder();
	MyOrder* GenerateOrder(int _orderid, QuoteBridge * _qptr);
};


#endif