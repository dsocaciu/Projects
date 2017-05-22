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

Stock::Stock()
{

}

Stock::~Stock()
{

}


string Stock::getExchange()
{
	return exchange;
}

void Stock::setExchange(string exc)
{
	exchange = exc;
}

string Stock::getName()
{
	return name;
}

void Stock::setName(string nm)
{
	name = nm;
}


void Option::setExpiration(string exp)
{
	expiration = exp;
}

string Option::getExpiration()
{
	return expiration;
}

void Option::setOptionName(string opnm)
{
	option_name = opnm;
}

string Option::getOptionName()
{
	return option_name;
}

void Option::setUnderlyingName(string unl)
{
	underlying = unl;
}

string Option::getUnderlying()
{
	return underlying;
}


Option::Option()
{

}


Option::~Option()
{

}
