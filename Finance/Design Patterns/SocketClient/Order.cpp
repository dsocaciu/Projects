#include "Order.h"
#include <iostream>

using namespace std;


//------------------------------but order functions-----------------------
Order* BuyOrder::clone()
{
	return new BuyOrder(*this);
}

void BuyOrder::setPrice(double Price_)
{ OrderQ.Price = Price_; }

void BuyOrder::setShare(long Share_)
{ OrderQ.Share = Share_; }

void BuyOrder::setSide()
{ OrderQ.Side = "Buy"; }

void BuyOrder::Output()
{ cout << "One buy order is generated!" << endl; }

//--------------------- sell order functions--------------------------

Order* SellOrder::clone()
{
	return new SellOrder(*this);
}

void SellOrder::setPrice(double Price_)
{ OrderQ.Price = Price_; }

void SellOrder::setShare(long Share_)
{ OrderQ.Share = Share_; }

void SellOrder::setSide()
{ OrderQ.Side = "Sell"; }

void SellOrder::Output()
{ cout << "One Sell order is generated!" << endl; }
