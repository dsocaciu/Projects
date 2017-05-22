
#include "QuoteBridge.h"

QuoteBridge::QuoteBridge()
{

}

QuoteBridge::QuoteBridge(const QuoteBridge& original)
{
	//PriceQuotePtr = original.PriceQuotePtr->clone();
}

QuoteBridge::QuoteBridge(const PriceQuote& inner)
{
	//PriceQuotePtr = inner.clone();
}

QuoteBridgeBuy::QuoteBridgeBuy()
{

}

QuoteBridgeBuy::QuoteBridgeBuy(const QuoteBridgeBuy& original) :  QuoteBridge(original)
{
	PriceQuoteBuyPtr = original.PriceQuoteBuyPtr->clone();
}

QuoteBridgeBuy::QuoteBridgeBuy(const PriceQuoteBuy& inner) : QuoteBridge(inner)
{
	PriceQuoteBuyPtr = inner.clone();
}

QuoteBridge::QuoteBridge( string symbol, float price, int share)
{
	PriceQuotePtr = new PriceQuote(symbol,price,share);
}


QuoteBridgeBuy::QuoteBridgeBuy( string symbol, float price, int share)
{
	PriceQuoteBuyPtr = new PriceQuoteBuy(symbol,price,share);
}

QuoteBridgeSell::QuoteBridgeSell(const QuoteBridgeSell& original) :  QuoteBridge(original)
{
	PriceQuoteSellPtr = original.PriceQuoteSellPtr->clone();
}

QuoteBridgeSell::QuoteBridgeSell(const PriceQuoteSell& inner) : QuoteBridge(inner)
{
	PriceQuoteSellPtr = inner.clone();
}

QuoteBridgeSell::QuoteBridgeSell( string symbol, float price, int share)
{
	PriceQuoteSellPtr = new PriceQuoteSell(symbol,price,share);
}

QuoteBridgeSell::QuoteBridgeSell()
{

}


