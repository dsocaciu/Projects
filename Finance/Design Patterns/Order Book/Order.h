//File: Order.h
//Info: Order holds the information for each order.
//Author: Dan Socaciu

using namespace std;

#ifndef ORDER_H_
#define ORDER_H_

#endif /*ORDER_H_*/

//OrderID	Symbol	Action	Side	Time	Price	Share

class Order{

protected:
	int orderId;
	string symbol;
	string action;
	string side;
	string time;
	float price;
	int share;
	bool execute;

public:

	void setOrderId(int oId);
	void setSymbol(string sym);
	void setAction(string act);
	void setSide(string sid);
	void setTime(string tim);
	void setPrice(float pri);
	void setShare(int sha);
	void setExecute(bool exe);

	int getOrderId();
	string getSymbol();
	string getAction();
	string getSide();
	string getTime();
	float getPrice();
	int getShare();
	bool getExecute();

	Order();
	virtual ~Order();


};