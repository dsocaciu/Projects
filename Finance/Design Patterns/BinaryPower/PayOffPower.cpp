//
//
//                          PayOffPower.cpp
//
//

#include "PayOffPower.h"
#include "minmax.h"
#include "math.h"

PayOffPowerCall::PayOffPowerCall(double Strike_, double Power_) : Strike(Strike_), Power(Power_)
{
}

double PayOffPowerCall::operator () (double Spot) const
{
	return max(pow(Spot,Power)-Strike,0.0);
}

PayOffPowerCall* PayOffPowerCall::clone() const
{
    return new PayOffPowerCall(*this);
}


double PayOffPowerPut::operator () (double Spot) const
{
	return max(Strike-pow(Spot,Power),0.0);
}

PayOffPowerPut::PayOffPowerPut(double Strike_,double Power_) : Strike(Strike_), Power(Power_)
{
}

PayOffPowerPut* PayOffPowerPut::clone() const
{
    return new PayOffPowerPut(*this);
}



