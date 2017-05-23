/***
	Factory.cpp - This file is used to implement the Factory design pattern.
		Both buy and sell orders are generated from the factory.

	Date: Dec 14, 2012
	By: Dan Socaciu, Zhe Zhou, Brian Higgins
***/

#include "Factory.h"

MyOrder* BuyFactory::GenerateOrder()
{
	return new BuyOrder();
}

MyOrder* BuyFactory::GenerateOrder(int _orderid, QuoteBridge * _qptr)
{
	QuoteBridgeBuy temp(_qptr->getSymbol(),_qptr->getPrice(),_qptr->getShare());
	return new BuyOrder( _orderid, temp);
}


MyOrder* SellFactory::GenerateOrder()
{
	return new SellOrder();
}

MyOrder* SellFactory::GenerateOrder(int _orderid, QuoteBridge * _qptr)
{
	QuoteBridgeSell temp(_qptr->getSymbol(),_qptr->getPrice(),_qptr->getShare());
	return new SellOrder( _orderid, temp);
}