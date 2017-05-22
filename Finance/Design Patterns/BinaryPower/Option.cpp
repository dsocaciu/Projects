//
//
//                  Option.cpp
//				Getters and Setters for the Vanilla, Digital and Power Options
//
#include "Option.h"

Option::Option(const PayOffBridge& ThePayOff_, double Expiry_)
                               :  ThePayOff(ThePayOff_), Expiry(Expiry_)
{
}

double Option::GetExpiry() const
{
    return Expiry;
}

double Option::OptionPayOff(double Spot) const
{
    return ThePayOff(Spot);
}

OptionDigital::OptionDigital(const PayOffBridgeDigital& ThePayOff_, double Expiry_) : Option( ThePayOff_, Expiry_), ThePayOff(ThePayOff_), Expiry(Expiry_)
{
}

double OptionDigital::GetExpiry() const
{
    return Expiry;
}

double OptionDigital::OptionPayOff(double Spot) const
{
    return ThePayOff(Spot);
}

OptionPower::OptionPower(const PayOffBridgePower& ThePayOff_, double Expiry_) : Option( ThePayOff_, Expiry_), ThePayOff(ThePayOff_), Expiry(Expiry_)
{
}

double OptionPower::GetExpiry() const
{
    return Expiry;
}

double OptionPower::OptionPayOff(double Spot) const
{
    return ThePayOff(Spot);
}
