#ifndef QUOTEBRIDGE_H_
#define QUOTEBRIDGE_H_

#include "PriceQuote.h"

class QuoteBridge{
	public:
		QuoteBridge();
		QuoteBridge(const QuoteBridge& original);
		QuoteBridge(const PriceQuote& inner);
		QuoteBridge( string symbol, float price, int share);
		virtual std::string getSide(){}
		virtual std::string getSymbol(){}
		virtual float getPrice(){}
		virtual int getShare(){}

	private:
		PriceQuote * PriceQuotePtr;
};

class QuoteBridgeBuy : public QuoteBridge
{
	public:
		QuoteBridgeBuy();
		QuoteBridgeBuy(const QuoteBridgeBuy& original);
		QuoteBridgeBuy(const PriceQuoteBuy& inner);
		QuoteBridgeBuy( string symbol, float price, int share);
		std::string getSide(){std::string Buy = "Buy"; return Buy;}
		std::string getSymbol(){return PriceQuoteBuyPtr->getSymbol();}
		virtual float getPrice(){return PriceQuoteBuyPtr->getPrice();}
		virtual int getShare(){return PriceQuoteBuyPtr->getShare();}
		//void setSymbol(std::string _symbol){ PriceQuoteBuyPtr->setSymbol(_symbol);}
		void setShare(int _share){ PriceQuoteBuyPtr->setShare(_share);}


	private:
		PriceQuoteBuy * PriceQuoteBuyPtr;
};

class QuoteBridgeSell: public QuoteBridge
{
	public:
		QuoteBridgeSell();
		QuoteBridgeSell(const QuoteBridgeSell& original);
		QuoteBridgeSell(const PriceQuoteSell& inner);
		QuoteBridgeSell(string symbol, float price, int share);
		std::string getSide(){return "Sell";}
		std::string getSymbol(){return PriceQuoteSellPtr->getSymbol();}
		virtual float getPrice(){return PriceQuoteSellPtr->getPrice();}
		virtual int getShare(){return PriceQuoteSellPtr->getShare();}
		void setShare(int _share){ PriceQuoteSellPtr->setShare(_share);}
	private:
			PriceQuoteSell * PriceQuoteSellPtr;
};

#endif /*QUOTEBRIDGE_H_*/
