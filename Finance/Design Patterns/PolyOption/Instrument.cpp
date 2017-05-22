// Instrument.cpp
// Author : Dan Socaicu

#include <iostream>
#include "Instrument.h"

using namespace std;


//Contains primarily getters and setters for the classes
//along with the constructers and destructers.
Instrument::Instrument(){

}

Instrument::~Instrument()
{

}

void Instrument::setName(char arg[])
{
	for(int i = 0;i<12;i++)
	{
		name[i] = arg[i];
	}
}



float Instrument::getAskPrice()
{
	return askPrice;
}

int Instrument::getAskSize()
{
	return askSize;
}

float Instrument::getBidPrice()
{
	return bidPrice;
}

int Instrument::getBidSize()
{
	return bidSize;
}

void Instrument::setBidPrice(float bPrice)
{
	bidPrice = bPrice;
}

void Instrument::setBidSize(int bSize)
{
	bidSize = bSize;
}


void Instrument::setAskPrice(float aPrice)
{
	askPrice = aPrice;
}

void Instrument::setAskSize(int aSize)
{
	askSize = aSize;
}

string Stock::getExchange()
{
	return exchange;
}

void Stock::setExchange(string exc)
{
	exchange = exc;
}

Stock::Stock()
{

}

Stock::~Stock()
{

}

void Option::setExpiration(string exp)
{
	expiration = exp;
}

string Option::getExpiration()
{
	return expiration;
}

Option::Option()
{

}


Option::~Option()
{

}
