// PriceQuote.cpp
// Author : Dan Socaicu


#include "PriceQuote.h"

//Contains primarily getters and setters for the classes
//along with the constructers and destructers.

PriceQuote::PriceQuote( float _price, int _share)
{
	price = _price;
	share = _share;
}

PriceQuote::PriceQuote( string _symbol, float _price, int _share)
{
	symbol = _symbol;
	price = _price;
	share = _share;
}

//string PriceQuote::getSide(){
//	return side;
//}
//string PriceQuote::getSymbol(){
//	return symbol;
//}
//float PriceQuote::getPrice(){
//	return price;
//}
//int PriceQuote::getShare(){
//	return share;
//}

//void PriceQuote::setSide(string _side){
//	side = _side;
//}
void PriceQuote::setSymbol(string _symbol){
	symbol = _symbol;
}
void PriceQuote::setPrice(float _price){
	price = _price;

}
void PriceQuote::setShare(int _share){
	share = _share;
}

void PriceQuoteBuy::setShare(int _share){
	share = _share;
}

void PriceQuoteSell::setShare(int _share){
	share = _share;
}

PriceQuoteBuy::PriceQuoteBuy(string _symbol, float _price, int _share): PriceQuote( _symbol, _price, _share)
{
	side = "Buy";
	symbol = _symbol;
	price = _price;
	share = _share;
}

string PriceQuoteBuy::getSymbol()
{
	return symbol;
}

float PriceQuoteBuy::getPrice()
{
	return price;
}

int PriceQuoteBuy::getShare()
{
	return share;
}

PriceQuoteBuy* PriceQuoteBuy::clone() const
{
    return new PriceQuoteBuy(*this);
}

 int PriceQuoteBuy::operator()(int existing) const
 {
	 //share =  existing + share;
	 return existing + share;
 }

PriceQuoteSell::PriceQuoteSell(string _symbol, float _price, int _share): PriceQuote( _symbol, _price, _share)
{
	side = "Sell";
	symbol = _symbol;
	price = _price;
	share = _share;
}

PriceQuoteSell* PriceQuoteSell::clone() const
{
    return new PriceQuoteSell(*this);
}

int PriceQuoteSell::operator()(int existing) const
{
	return existing-share;
	 //share =  existing - share;
}

string PriceQuoteSell::getSymbol()
{
	return symbol;
}

float PriceQuoteSell::getPrice()
{
	return price;
}

int PriceQuoteSell::getShare()
{
	return share;
}
