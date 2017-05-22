// Order.cpp
// Author : Dan Socaicu

#include <iostream>
#include "Order.h"

using namespace std;


//Contains primarily getters and setters for the classes
//along with the constructers and destructers.
Order::Order(){

}

Order::~Order()
{

}

void Order::setOrderId(int oId)
{
	orderId = oId;
}

void Order::setSymbol(string sym)
{
	symbol = sym;
}

void Order::setAction(string act)
{
	action = act;
}

void Order::setSide(string sid)
{
	side = sid;
}

void Order::setTime(string tim)
{
	time = tim;
}

void Order::setPrice(float pri)
{
	price = pri;
}

void Order::setShare(int sha)
{
	share = sha;
}

void Order::setExecute(bool exe)
{
	execute = exe;
}

int Order::getOrderId()
{
	return orderId;
}

string Order::getSymbol()
{
	return symbol;
}

string Order::getAction()
{
	return action;
}

string Order::getSide()
{
	return side;
}

string Order::getTime()
{
	return time;
}

float Order::getPrice()
{
	return price;
}

int Order::getShare()
{
	return share;
}

bool Order::getExecute()
{
	return execute;
}

