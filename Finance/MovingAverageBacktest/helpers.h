#ifndef HELPERS_H_
#define HELPERS_H_

#include <vector>
#include <math.h>
#include "Order.h"

using namespace std;



double rand_normal(double mean, double stddev) {
    static double n2 = 0.0;
    static int n2_cached = 0;
    if (!n2_cached) {
        double x, y, r;
	do {
	    x = 2.0*rand()/RAND_MAX - 1;
	    y = 2.0*rand()/RAND_MAX - 1;

	    r = x*x + y*y;
	} while (r == 0.0 || r > 1.0);
        {
        double d = sqrt(-2.0*log(r)/r);
	double n1 = x*d;
	n2 = y*d;
        double result = n1*stddev + mean;
        n2_cached = 1;
        return result;
        }
    } else {
        n2_cached = 0;
        return n2*stddev + mean;
    }
}



float maxInSet(vector<float> pri)
{
	float max = 0.0;

		for(unsigned int i=0;i<pri.size();i++)
		{
			if( pri[i] > max)
			{
				max = pri[i];
			}
		}

	return max;
}

float minInSet(vector<float> pri)
{
	float min = 100000000000000000;

		for(unsigned int i=0;i<pri.size();i++)
		{
			if( pri[i] < min)
			{
				min = pri[i];
			}
		}

	return min;
}

float averageInSet(vector<float> pri)
{
	float total = 0.0;

	for(unsigned int i=0;i<pri.size();i++)
	{
		total+=pri[i];
	}



	return total/(float)pri.size();
}


float varianceInSet(vector<float> pri)
{
	// Get mean
	float mean = averageInSet(pri);
	//cout << "mean: " << mean <<endl;
	// Calculate variance
	float variance = 0;
	for(unsigned int i = 0;i<pri.size();i++)
	{
	  variance += ((pri[i]-mean)*(pri[i]-mean))/pri.size();
	}
	// Display
	return variance;
}



float covarianceInSet(vector<float> pri)
{
	float sumProd=0.0;

	float meanY = averageInSet(pri);
	float meanX = pri.size()/2;

	for (unsigned int i = 0; i < pri.size(); i++)
	{
		sumProd += (((float)i+1)-meanX)*(pri[i]-meanY);
	}

	//cout<<sumProd;

	return sumProd/(pri.size()-1);


}

float calculateBeta(vector<float> pri)
{

	return covarianceInSet(pri)/varianceInSet(pri);
}



//create moving average function
vector<float> movingAverage(vector<float>input,int number)
{
	vector<float> temp;

	float temp_sum;

	int start,end;

	//set up moving average vector
	for(int i = 0; i < number;i++){
		temp.push_back(0);
	}

	for(unsigned int i = 0; i<input.size()-number;i++){

		//start = i;
		end = i+number;

		for (start=i;start<end;start++)
		{
			temp_sum +=input[start];
		}
		temp.push_back(temp_sum/number);
		temp_sum = 0;
	}



	return temp;
}



vector<string> movingAverageStrategy(vector<float> input)
{
	vector<string> signals;
	//The strategy for buy and  sell signals are  based information from sma(5) and sma(20),sma(50)
	//Sell short  is when sma(5) is positive relative to sma(20)
	//Buy to cover is when sma(5) is negative to both sma(20) and sma(50)


	vector<float> sma5 = movingAverage(input,5);

	vector<float> sma20 = movingAverage(input,20);

	vector<float> sma50 = movingAverage(input,50);


//	for(unsigned int i=0;i<sma5.size();i++)
//	{
//		cout << sma5[i] << endl;
//	}
//
//	cout << sma5.size();


	//create difference between sma5 and sma20

	vector<float> diff_sma520;

	if (sma5.size()==sma20.size())
	{
		for(unsigned int i =0;i<sma5.size();i++)
		{
			if(sma5[i]==0 or sma20[i]==0)
			{
				diff_sma520.push_back(0);

			}
			else
			{
				diff_sma520.push_back(sma5[i]-sma20[i]);
			}

		}
	}

//	for(unsigned int i=0;i<diff_sma520.size();i++)
//	{
//		cout << diff_sma520[i] << endl;
//	}
//
//	cout << diff_sma520.size();



	//create difference between sma5 and sma50

	vector<float> diff_sma550;

	if (sma5.size()==sma50.size())
	{
		for(unsigned int i =0;i<sma5.size();i++)
		{
			if(sma5[i]==0 or sma50[i]==0)
			{
				diff_sma550.push_back(0);

			}
			else
			{
				diff_sma550.push_back(sma5[i]-sma50[i]);
			}

		}
	}

//	for(unsigned int i=0;i<diff_sma550.size();i++)
//	{
//		cout << diff_sma550[i] << endl;
//	}
//
//	cout << diff_sma550.size();


	//create signal vector

	if(diff_sma520.size() == diff_sma550.size())
	{

		for (unsigned int i = 0; i < diff_sma520.size();i++)
		{
			if( diff_sma520[i] < 0 and diff_sma550[i] < 0)
			{
				signals.push_back("Sell");
			}
			else //if(diff_sma520[i] > 0)
			{
				signals.push_back("Buy");
			}
//			else
//			{
//				signals.push_back("N/A");
//			}
		}

	}



	return signals;

}

vector<float> priceToReturns(vector<float> prices)
{
	vector<float> logReturns;

	for(unsigned int i = 1;i<prices.size();i++)
	{
		logReturns.push_back(log(prices[i]/prices[i-1]));
	}

	return logReturns;
}

vector<float> returnsToPrices(vector<float> logReturns, float meanPrice)
{
	vector<float> prices;

	for(unsigned int i= 0;i<logReturns.size();i++)
	{
		prices.push_back(meanPrice * exp(logReturns[i]));
	}

	return prices;
}

#endif /*H_H_*/
