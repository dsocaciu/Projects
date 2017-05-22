// Order.cpp
// Author : Dan Socaicu

#include <iostream>
#include "Order.h"

using namespace std;

//Order* Order::o_instance = NULL;


//Contains primarily getters and setters for the classes
//along with the constructers and destructers.
//Order::Order()
//{
//
//}

Order::Order()
{

}



Order::~Order()
{

}

//Book::~Book()
//{
//
//}

Order::Order(int _orderid, string _action, string _time)
{

	orderId = _orderid;
	action = _action;
	time = _time;

}

Order *Order::make_order(string bs)
{
  if (bs.compare("Buy")==0)
    return new BuyOrder();

    return new SellOrder();
}

//Order* Order::Instance()
//{
//   if (!o_instance)   // Only allow one instance of class to be generated.
//        o_instance = new Order;
//
//   return o_instance;
//}

BuyOrder::BuyOrder() : Order()
{

}

BuyOrder::BuyOrder(int _orderid, QuoteBridgeBuy & _qptr, string _action, string _time) : Order ( _orderid, _action, _time)
{
	qptr = _qptr;
	orderId = _orderid;
	action = _action;
	time = _time;

	//cout <<qptr.getSymbol()<<" "<<qptr.getPrice()<<" "<< qptr.getShare() << endl;

	//cout <<"new order symbol - " << ptr->getSymbol() << endl;
	//cout <<"new order share -  " << ptr->getShare() << endl;
	//cout <<"new order price -  " << ptr->getPrice() << endl;

	//cout <<"new order symbol - " << ptr->getSymbol() << endl;
	//cout <<"side: " << _qptr.getSide()<< endl;
	//if(_qptr->getSide().compare("Buy")==0)
	//{
	//	//cout<<"Double Buy"<<endl;
	//}
	//cout << temp.getSymbol() << endl;
	//cout << getBridge()->getShare()<<endl;
	//cout << temp.getShare() << endl;
	//Book.insert(pair<int,Order>(temp.getOrderId(),temp));
}

int BuyOrder::getOrderId()
{
	return orderId;
}

string BuyOrder::getSymbol()
{
	return qptr.getSymbol();
}

float BuyOrder::getPrice()
{
	return qptr.getPrice();
}

int BuyOrder::getShare()
{
	return qptr.getShare();
}

string BuyOrder::getSide()
{
	return qptr.getSide();
}

string SellOrder::getSide()
{
	return qptr.getSide();
}

void BuyOrder::setShare(int _share)
{
	qptr.setShare(_share);
}

void SellOrder::setShare(int _share)
{
	qptr.setShare(_share);
}

//int Order::getShare()
//{
//	return share;
//}




SellOrder::SellOrder() : Order()
{

}

SellOrder::SellOrder(int _orderid, QuoteBridgeSell & _qptr, string _action, string _time) : Order ( _orderid, _action, _time)
{
	orderId = _orderid;
	qptr = _qptr;
	action = _action;
	time = _time;

	//cout <<qptr.getSymbol()<<" "<<qptr.getPrice()<<" "<< qptr.getShare() << endl;
	//QuoteBridge * ptr = &_qptr;

	//cout <<"new order symbol - " << ptr->getSymbol() << endl;
	//cout <<"new order share -  " << ptr->getShare() << endl;
	//cout <<"new order price -  " << ptr->getPrice() << endl;
	//cout <<"side: " << _qptr.getSide()<< endl;
	//if(_qptr->getSide().compare("Buy")==0)
	//{
	//	//cout<<"Double Buy"<<endl;
	//}
	//Order temp(_orderid, ptr, _action, _time);

	//return temp;
//	cout <<"temp order id " << temp.getOrderId()<<endl;
//	cout <<"temp symbol - " << temp.getSymbol()<<endl;
//	cout <<"temp shares = " << temp.getShare() <<endl;
	//cout <<"insert"<<endl;
	//Book.insert(pair<int,Order>(temp.getOrderId(),temp));
}

int SellOrder::getOrderId()
{
	return orderId;
}

string SellOrder::getSymbol()
{
	return qptr.getSymbol();
}

float SellOrder::getPrice()
{
	return qptr.getPrice();
}

int SellOrder::getShare()
{
	return qptr.getShare();
}




//void Order::setOrderId(int oId)
//{
//	orderId = oId;
//}

//void Order::setSymbol(string sym)
//{
//	symbol = sym;
//}

//void Order::setAction(string act)
//{
//	action = act;
//}

//void Order::setSide(string sid)
//{
//	side = sid;
//}
//
//void Order::setTime(string tim)
//{
//	time = tim;
//}

//void Order::setPrice(float pri)
//{
//	price = pri;
//}

//void Order::setShare(int sha)
//{
//	share = sha;
//}

//void Order::setExecute(bool exe)
//{
//	execute = exe;
//}

int Order::getOrderId()
{
	return orderId;
}

//string Order::getSymbol()
//{
//	return symbol;
//}

//string Order::getAction()
//{
//	return action;
//}

//string Order::getSide()
//{
//	return side;
//}

//string Order::getTime()
//{
//	return time;
//}


//bool Order::getExecute()
//{
//	return execute;
//}

