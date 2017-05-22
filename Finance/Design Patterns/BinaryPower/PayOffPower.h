//
//
//                            PayOffPower.h
//
//

#ifndef PAYOFFPOWER_H
#define PAYOFFPOWER_H

#include "PayOff3.h"

//PayOffPower class inherits PayOff

class PayOffPower: public PayOff
{
public:

    PayOffPower(){};

    virtual double operator()(double Spot) const=0;
    virtual ~PayOffPower(){}
    virtual PayOffPower* clone() const=0;

private:

};

class PayOffPowerCall : public PayOffPower
{
public:

    PayOffPowerCall( double Strike_, double Power_);

    virtual double operator()(double Spot) const;
    virtual ~PayOffPowerCall(){}
    virtual PayOffPowerCall* clone() const;

private:

    double Strike;
    double Power;

};


class PayOffPowerPut : public PayOffPower
{
public:

    PayOffPowerPut( double Strike_, double Power_);

    virtual double operator()(double Spot) const;
    virtual ~PayOffPowerPut(){}
    virtual PayOffPowerPut* clone() const;

private:


	double Strike;
	double Power;

};

#endif



