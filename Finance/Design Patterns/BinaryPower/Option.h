//
//
//                   Option.h
//
//
#ifndef OPTION_H
#define OPTION_H

#include "PayOffBridge.h"

//class based on the VanillaOption class
class Option
{
public:

    Option(const PayOffBridge& ThePayOff_, double Expiry);

    double OptionPayOff(double Spot) const;
    double GetExpiry() const;

private:

    double Expiry;
    PayOffBridge ThePayOff;
};

//The digital option class inherits the option class
class OptionDigital : public Option
{
public:

	//Digital option requres the digital payoff and hence the digital pay off bridge
    OptionDigital(const PayOffBridgeDigital& ThePayOff_, double Expiry);

    double OptionPayOff(double Spot) const;
    double GetExpiry() const;

private:

    double Expiry;
    PayOffBridgeDigital ThePayOff;
};

//The power option class inherits the option class
class OptionPower: public Option
{
public:
	//Power option requires the power payoff and hence the power pay off bridge
	OptionPower(const PayOffBridgePower& ThePayOff_, double Expiry);

    double OptionPayOff(double Spot) const;
    double GetExpiry() const;

private:

    double Expiry;
    PayOffBridgePower ThePayOff;

};

#endif



