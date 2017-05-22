//
//
//                      SimpleMC5.cpp
//
//

#include "SimpleMC5.h"
#include "Random1.h"
#include <cmath>
#include <iostream>

using namespace std;

double SimpleMonteCarlo3(const Option& TheOption,
						 double Spot,
						 double Vol,
						 double r,
						 unsigned long NumberOfPaths)
{

    double Expiry = TheOption.GetExpiry();

	double variance = Vol*Vol*Expiry;
	double rootVariance = sqrt(variance);
	double itoCorrection = -0.5*variance;

	double movedSpot = Spot*exp(r*Expiry +itoCorrection);
	double thisSpot;
	double runningSum=0;

	for (unsigned long i=0; i < NumberOfPaths; i++)
	{
		double thisGaussian = GetOneGaussianByBoxMuller();
		thisSpot = movedSpot*exp( rootVariance*thisGaussian);
		double thisPayOff = TheOption.OptionPayOff(thisSpot);
		//cout << "In Monte Carlo: PayOff=" << thisPayOff <<endl;
		runningSum += thisPayOff;
	}
	double mean = runningSum / NumberOfPaths;
	mean *= exp(-r*Expiry);
	return mean;
}

double SimpleMonteCarlo5(const OptionDigital& DigOption,
						 double Spot,
						 double Vol,
						 double r,
						 unsigned long NumberOfPaths)
{

    double Expiry = DigOption.GetExpiry();

	double variance = Vol*Vol*Expiry;
	double rootVariance = sqrt(variance);
	double itoCorrection = -0.5*variance;

	double movedSpot = Spot*exp(r*Expiry +itoCorrection);
	double thisSpot;
	double runningSum=0;

	for (unsigned long i=0; i < NumberOfPaths; i++)
	{
		double thisGaussian = GetOneGaussianByBoxMuller();
		thisSpot = movedSpot*exp( rootVariance*thisGaussian);
		//cout << "ThisSpot" << thisSpot << endl;
		double thisPayOff = DigOption.OptionPayOff(thisSpot);
		//cout << "In Monte Carlo: PayOff=" << thisPayOff <<endl;
		runningSum += thisPayOff;
	}
	double mean = runningSum / NumberOfPaths;
	mean *= exp(-r*Expiry);
	return mean;
}

double SimpleMonteCarlo7(const OptionPower& PowOption,
						 double Spot,
						 double Vol,
						 double r,
						 unsigned long NumberOfPaths)
{

    double Expiry = PowOption.GetExpiry();

	double variance = Vol*Vol*Expiry;
	double rootVariance = sqrt(variance);
	double itoCorrection = -0.5*variance;

	double movedSpot = Spot*exp(r*Expiry +itoCorrection);
	double thisSpot;
	double runningSum=0;

	for (unsigned long i=0; i < NumberOfPaths; i++)
	{
		double thisGaussian = GetOneGaussianByBoxMuller();
		thisSpot = movedSpot*exp( rootVariance*thisGaussian);
		//cout << "ThisSpot" << thisSpot << endl;
		double thisPayOff = PowOption.OptionPayOff(thisSpot);
		//cout << "In Monte Carlo: PayOff=" << thisPayOff <<endl;
		runningSum += thisPayOff;
	}
	double mean = runningSum / NumberOfPaths;
	mean *= exp(-r*Expiry);
	return mean;
}

