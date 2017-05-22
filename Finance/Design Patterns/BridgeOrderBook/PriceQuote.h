#ifndef PRICEQUOTE_H_
#define PRICEQUOTE_H_

#include <string>
#include <iostream>

using namespace std;

class PriceQuote
{
private:
	string symbol;
	float price;
	int share;

public:

	//string getSide();
	virtual string getSymbol(){}
	virtual float getPrice(){}
	virtual int getShare(){}

	//void setSide(string _side);
	void setSymbol(string _symbol);
	void setPrice(float _price);
	void setShare(int _share);

	//PriceQuote();
	PriceQuote(string _symbol, float _price, int _share);

	//virtual PriceQuote * clone() const=0;
	//virtual ~PriceQuote();


};

class PriceQuoteBuy : public PriceQuote
{
private:
	string side;
	string symbol;
	float price;
	int share;
public:
	PriceQuoteBuy();
	PriceQuoteBuy(string _symbol, float _price, int _share);

	string getSymbol();
	float getPrice();
	int getShare();

	void setShare(int _share);

	virtual PriceQuoteBuy * clone() const;
	virtual int operator()(int existing) const;
	//virtual ~PriceQuoteBuy(){}
};

class PriceQuoteSell: public PriceQuote
{
private:
	string side;
	string symbol;
	float price;
	int share;
public:
	PriceQuoteSell();
	PriceQuoteSell(string _symbol, float _price, int _share);

	string getSymbol();
	float getPrice();
	int getShare();

	void setShare(int _share);

	virtual PriceQuoteSell * clone() const;
	virtual int operator()(int existing) const;
	//virtual ~PriceQuoteSell(){}
};


#endif /*PRICEQUOTE_H_*/
