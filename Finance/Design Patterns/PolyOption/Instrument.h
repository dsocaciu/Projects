//File: Instrument.h
//Info: Provides base information for security
//Author: Dan Socaciu

using namespace std;

#ifndef INSTRUMENT_H_
#define INSTRUMENT_H_
//Instrument
//contains the shared components of the stock and option
class Instrument{

	protected:
	float bidPrice;
	int bidSize;
	float askPrice;
	int askSize;

	public:
		char name[12];
		void setName(char *str);
		void setBidPrice(float bPrice);
		void setBidSize(int bSize);
		void setAskPrice(float aPrice);
		void setAskSize(int aSize);


		float getBidPrice();
		int getBidSize();
		float getAskPrice();
		int getAskSize();

		Instrument();
		virtual ~Instrument();


};

//contains the inherited features of the Instrument class
//along with stock specific functionality
class Stock: public Instrument
{
protected:
	string exchange;

public:
	void setExchange(string exc);
	string getExchange();
	Stock();
	virtual ~Stock();
};

//contains the inherited features of the Instrument class
//along with Option specific functionality
class Option: public Instrument
{

protected:
	string expiration;

public:
	char option_name[26];
	void setExpiration(string exp);
	string getExpiration();
	Option();
	virtual ~Option();
};



#endif /*INSTRUMENT_H_*/
