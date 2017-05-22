//File: Order.h
//Info: Order holds the information for each order.
//Author: Dan Socaciu



#ifndef ORDER_H_
#define ORDER_H_

#include <string>
#include "QuoteBridge.h"

#include <map>

using namespace std;

//OrderID	Symbol	Action	Side	Time	Price	Share

class Order{

protected:
	//QuoteBridge qptr;
	int orderId;
	string action;
	string time;

//	static Order *o_instance;

//	map<int,Order> Book;

public:



	static Order *make_order(string bs);



	int getOrderId();
	string getSymbol();
	int getShare();
	//QuoteBridge * getBridge();
	//string getAction();
	//string getSide();
	//string getTime();
	//float getPrice();

	//static Order *Instance();
	Order();
	Order(int _orderid, string _action, string _time);
	virtual ~Order();


};

class BuyOrder : public Order
{
private:
	QuoteBridgeBuy qptr;
	int orderId;
	string action;
	string time;

public:
	int getOrderId();
	string getSymbol();
	int getShare();
	void setShare(int _share);
	string getSide();
	float getPrice();
	static BuyOrder *make_order(string bs);
	BuyOrder();
	BuyOrder(int _orderid, QuoteBridgeBuy & _qptr, string _action, string _time);
	void cancelBuyOrder();
	void executeBuyOrder();
};

class SellOrder : public Order
{
private:
	QuoteBridgeSell qptr;
	int orderId;
	string action;
	string time;

public:
	int getOrderId();
	string getSymbol();
	int getShare();
	string getSide();
	void setShare(int _share);
	float getPrice();
	SellOrder();
	SellOrder(int _orderid, QuoteBridgeSell & _qptr, string _action, string _time);
	void cancelSellOrder();
	void executeSellOrder();
};


#endif /*ORDER_H_*/