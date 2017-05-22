//
//
//                       PayOffBridge.h
//
//

#ifndef PAYOFFBRIDGE_H
#define PAYOFFBRIDGE_H

#include "PayOff3.h"
#include "PayOffDigital.h"
#include "PayOffPower.h"

//PayOffBridge from class
class PayOffBridge
{
public:

    PayOffBridge(const PayOffBridge& original);
    PayOffBridge(const PayOff& innerPayOff);

    inline double operator()(double Spot) const;
    ~PayOffBridge();
    PayOffBridge& operator=(const PayOffBridge& original);

private:

    PayOff* ThePayOffPtr;

};

inline double PayOffBridge::operator()(double Spot) const
{
    return ThePayOffPtr->operator ()(Spot);
}

//PayOffBridge for Digital PayOff
//inherited from PayOffBridge
class PayOffBridgeDigital : public PayOffBridge
{
	public:

	    PayOffBridgeDigital(const PayOffBridgeDigital& original_);
	    PayOffBridgeDigital(const PayOffDigital& innerPayOff_);

	    inline double operator()(double Spot) const;
	    ~PayOffBridgeDigital();
	    PayOffBridgeDigital& operator=(const PayOffBridgeDigital& original);

	private:

	    PayOffDigital* ThePayOffDigPtr;
};

inline double PayOffBridgeDigital::operator()(double Spot) const
{
    return ThePayOffDigPtr->operator ()(Spot);
}

//PayOffBridge for Power PayOff
//inherited from PayOffBridge
class PayOffBridgePower : public PayOffBridge
{
	public:

	    PayOffBridgePower(const PayOffBridgePower& original_);
	    PayOffBridgePower(const PayOffPower& innerPayOff_);

	    inline double operator()(double Spot) const;
	    ~PayOffBridgePower();
	    PayOffBridgePower& operator=(const PayOffBridgePower& original);

	private:

	    PayOffPower* ThePayOffPowPtr;
};

inline double PayOffBridgePower::operator()(double Spot) const
{
    return ThePayOffPowPtr->operator ()(Spot);
}

#endif



