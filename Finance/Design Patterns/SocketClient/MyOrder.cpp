/***
	MyOrder.cpp - This file is used to implement the factory pattern and virtual constructor pattern.
		Both buy and sell orders are cloned using this pattern.

	Date: Dec 14, 2012
	By: Dan Socaciu, Zhe Zhou, Brian Higgins
***/

#include "MyOrder.h"
#include <iostream>

using namespace std;


//------------------------------buy order functions-----------------------
MyOrder* BuyOrder::clone()
{
	return new BuyOrder(*this);
}
/*
void BuyOrder::setPrice(double Price_)
{ OrderQ.Price = Price_; }

void BuyOrder::setShare(long Share_)
{ OrderQ.Share = Share_; }

void BuyOrder::setSide()
{ OrderQ.Side = "Buy"; }
*/
void BuyOrder::Output()
{ cout << "One buy order is generated!" << endl; }

BuyOrder::BuyOrder(int _orderid, QuoteBridgeBuy & _qptr) 
{
	qptr = _qptr;
	orderId = _orderid;

}

//--------------------- sell order functions--------------------------

MyOrder* SellOrder::clone()
{
	return new SellOrder(*this);
}

SellOrder::SellOrder(int _orderid, QuoteBridgeSell & _qptr)
{
	orderId = _orderid;
	qptr = _qptr;

}

/*void SellOrder::setPrice(double Price_)
{ OrderQ.Price = Price_; }

void SellOrder::setShare(long Share_)
{ OrderQ.Share = Share_; }

void SellOrder::setSide()
{ OrderQ.Side = "Sell"; }
*/
void SellOrder::Output()
{ cout << "One Sell order is generated!" << endl; }
