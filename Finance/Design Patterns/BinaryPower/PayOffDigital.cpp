//
//
//                          PayOffDigital.cpp
//
//

#include "PayOffDigital.h"
#include "minmax.h"

PayOffDigitalCall::PayOffDigitalCall(double Strike_) : Strike(Strike_)
{
}

double PayOffDigitalCall::operator () (double Spot) const
{
    if(Spot<Strike)
    	return 0;

    return 1;
}

PayOffDigitalCall* PayOffDigitalCall::clone() const
{
    return new PayOffDigitalCall(*this);
}


double PayOffDigitalPut::operator () (double Spot) const
{
    if(Spot<Strike)
    	return 1;

    return 0;
}

PayOffDigitalPut::PayOffDigitalPut(double Strike_) : Strike(Strike_)
{
}

PayOffDigitalPut* PayOffDigitalPut::clone() const
{
    return new PayOffDigitalPut(*this);
}



