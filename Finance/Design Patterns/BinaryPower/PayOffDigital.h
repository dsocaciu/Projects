//
//
//                            PayOffDigital.h
//
//

#ifndef PAYOFFDIGITAL_H
#define PAYOFFDIGITAL_H

#include "PayOff3.h"

//class PayOffDigital inherits PayOff class

class PayOffDigital: public PayOff
{
public:

    PayOffDigital(){};

    virtual double operator()(double Spot) const=0;
    virtual ~PayOffDigital(){}
    virtual PayOffDigital* clone() const=0;

private:

};

class PayOffDigitalCall : public PayOffDigital
{
public:

    PayOffDigitalCall( double Strike_);

    virtual double operator()(double Spot) const;
    virtual ~PayOffDigitalCall(){}
    virtual PayOffDigitalCall* clone() const;

private:

    double Strike;
    //double Spot;
};


class PayOffDigitalPut : public PayOffDigital
{
public:

    PayOffDigitalPut( double Strike_);

    virtual double operator()(double Spot) const;
    virtual ~PayOffDigitalPut(){}
    virtual PayOffDigitalPut* clone() const;

private:


	double Strike;
	//double Spot;

};

#endif



