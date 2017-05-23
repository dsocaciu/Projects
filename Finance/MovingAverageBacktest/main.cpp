#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include "linear.h"
#include <stdio.h>
#include <stdlib.h>
#include <map>
#include "helpers.h"
#include "Order.h"

using namespace std;

vector<float> prices;
ofstream myfile;
ofstream myfile2;

void processPrices(string line)
{
	int i = 0;
	float price;

	string tempV[16];

	istringstream iss(line);


	while (iss)
	    {
	      string s;
	      if (!getline( iss, s, ',' )) break;
	      //cout<<"s: " << s << endl;
	      tempV[i] = s;
	      i++;

	    }
	//cout <<tempV[1]<<endl;
	istringstream price_(tempV[6]);
		price_ >> price;
	prices.push_back(price);
}

void readData(){
	//cout <<"Read in data"<<endl;

	string line;
	ifstream myfile("xme strat.csv");
	if (myfile.is_open())
	  {
	    while ( myfile.good() )
	    {
	      getline (myfile,line);
	      //readLine(line);
	      //temp = readLine(line);
	      //InputData.push_back(temp);

	    //skip title line
	  	if ((line.find("Date")==string::npos) & (!line.empty()))
	      //take in dates and prices
	  		processPrices(line);

	    }
	    myfile.close();

	    //remove duplicate value at the end
	    prices.pop_back();
	  }

	  else cout << "Unable to open file";

}




vector<Order*> processSignals(vector<string> signals)
{


	//cout <<"in Process signals" << endl;

	//bool to determine whether a position is active
	bool BuyActive = false;


	float buyPrice=0;
	float sellPrice=0;

	vector<Order*> actions;

	//first add buy and then sell
	unsigned int i = 0;

	while (i < signals.size())
	{
		//Check if Buy signal is proceeded by Sell signal
		if(i>0){


			if(signals[i].compare("Buy")==0 and signals[i-1].compare("Sell")==0 and !BuyActive )
			{
				buyPrice = prices[i];
				BuyActive = true;
			}

			if(signals[i].compare("Sell")==0 and signals[i-1].compare("Sell")==0 and BuyActive)
			{
				sellPrice = prices[i];
				actions.push_back(Order::make_order(buyPrice,sellPrice,i));
				buyPrice = 0;
				sellPrice = 0;
				BuyActive = false;
			}
		}

			i++;

	//	}

	}

	return actions;
}

float calculateTotalReturn(vector<Order*> actions)
{
	float sum=0.0;

	for (unsigned int i = 0; i < actions.size(); i++)
		   sum += actions[i]->getReturn();

	return sum;

}

float calculateAverageReturn(vector<Order*> actions)
{
	float sum=0.0;

	for (unsigned int i = 0; i < actions.size(); i++)
		   sum += actions[i]->getReturn();

	return sum/(float)actions.size();

}

float calculatePercentagePositive(vector<Order*> actions)
{
	float percentage = 0.0;
	int num_pos =0;

	for (unsigned int i = 0; i < actions.size(); i++)
	{
		   if( actions[i]->getReturn() > 0)
		   {
			   num_pos++;
		   }
	}
	//cout <<"num pos: "<< num_pos << endl;
	percentage = (float)num_pos / actions.size();

	return percentage;
}

//float average losing amount
float calculateAverageLoss(vector<Order*> actions)
{
	float percentage = 0.0;
	float amount = 0.0;
	int num_neg =0;

	for (unsigned int i = 0; i < actions.size(); i++)
	{
		   if( actions[i]->getReturn() < 0)
		   {
			   amount += actions[i]->getReturn();
			   num_neg++;
		   }
	}
	//cout <<"num pos: "<< num_pos << endl;
	percentage = amount / (float)num_neg;

	return percentage;
}

float getVarianceOfReturns(vector<Order*> actions)
{
	vector<float> returns;
	for(unsigned int i = 0;i < actions.size();i++)
	{
		returns.push_back(actions[i]->getReturn());
	}

	// Get mean
	float mean = averageInSet(returns);
	//cout << "mean: " << mean <<endl;
	// Calculate variance
	float variance = 0.0;
	for(unsigned int i = 0;i<returns.size();i++)
	{
	  variance += ((returns[i]-mean)*(returns[i]-mean))/returns.size();
	}

	return variance;
}

//measures for the AR(1) model
void performanceMeasures1(vector<Order*> actions, vector<float> new_prices, int num_test)
{
	//cout <<num_test<<" "<<actions.size() <<endl;

	myfile<<num_test+1<<","<<actions.size()<<","<<calculateTotalReturn(actions)
	<<","<<calculatePercentagePositive(actions)*100
	<<"%,"<<calculateAverageLoss(actions)
	<<","<<((calculatePercentagePositive(actions)*calculateAverageLoss(actions))-1+calculatePercentagePositive(actions))/calculateAverageLoss(actions)
	<<","<<calculateAverageReturn(actions)/pow((getVarianceOfReturns(actions)/actions.size()),.5)
	<<","<<maxInSet(new_prices)-new_prices[new_prices.size()-1]
	<<","<<averageInSet(new_prices)
	<<","<<maxInSet(new_prices)
	<<","<<minInSet(new_prices)
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-5]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-24]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-64]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-38]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-248]<<"\n";


}

//measures for the AR(2) model
void performanceMeasures2(vector<Order*> actions, vector<float> new_prices, int num_test)
{
	//cout <<num_test<<" "<<actions.size() <<endl;

	myfile2<<num_test+1<<","<<actions.size()<<","<<calculateTotalReturn(actions)
	<<","<<calculatePercentagePositive(actions)*100
	<<"%,"<<calculateAverageLoss(actions)
	<<","<<((calculatePercentagePositive(actions)*calculateAverageLoss(actions))-1+calculatePercentagePositive(actions))/calculateAverageLoss(actions)
	<<","<<calculateAverageReturn(actions)/pow((getVarianceOfReturns(actions)/actions.size()),.5)
	<<","<<maxInSet(new_prices)-new_prices[new_prices.size()-1]
	<<","<<averageInSet(new_prices)
	<<","<<maxInSet(new_prices)
	<<","<<minInSet(new_prices)
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-5]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-24]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-64]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-38]
	<<","<<new_prices[new_prices.size()-1]/new_prices[new_prices.size()-248]<<"\n";


}



int main()
{
	vector<string> buyOrSell;

	vector<Order*> orders;


	  if( remove( "570output.csv" ) != 0 )
	    perror( "File not present" );
	  else
	    puts( "File successfully deleted" );


	  if( remove( "570output2.csv" ) != 0 )
	    perror( "File not present" );
	  else
	    puts( "File successfully deleted" );

	  myfile.open ("570output.csv", ios::out | ios::app);

	  myfile2.open ("570output2.csv", ios::out | ios::app);

	  myfile<<"Sample #,# of round-trip trades ,total return % ,winning trades % ,average losing amount ,kelly criterion ,"
	  			"t-statistic ,max drawdown ,mean ,max ,min ,wtd% ,mtd% ,qtd% ,ytd% ,52wk %chg\n";

	  myfile2<<"Sample #,# of round-trip trades ,total return % ,winning trades % ,average losing amount ,kelly criterion ,"
	  			"t-statistic ,max drawdown ,mean ,max ,min ,wtd% ,mtd% ,qtd% ,ytd% ,52wk %chg\n";

	//read in data
	readData();

	//assess signals on prices
	buyOrSell = movingAverageStrategy(prices);

	// process signals and apply moving average strategy
	orders = processSignals(buyOrSell);

	//Initial sample
	myfile<<"Empirical ,"<<orders.size()<<","<<calculateTotalReturn(orders)
	<<","<<calculatePercentagePositive(orders)*100
	<<"%,"<<calculateAverageLoss(orders)
	<<","<<((calculatePercentagePositive(orders)*calculateAverageLoss(orders))-1+calculatePercentagePositive(orders))/calculateAverageLoss(orders)
	<<","<<calculateAverageReturn(orders)/pow((getVarianceOfReturns(orders)/orders.size()),.5)
	<<","<<maxInSet(prices)-prices[prices.size()-1]
	<<","<<averageInSet(prices)<<","<<maxInSet(prices)
	<<","<<minInSet(prices)
	<<","<<prices[prices.size()-1]/prices[prices.size()-5]
	<<","<<prices[prices.size()-1]/prices[prices.size()-24]
	<<","<<prices[prices.size()-1]/prices[prices.size()-64]
	<<","<<prices[prices.size()-1]/prices[prices.size()-38]
	<<","<<prices[prices.size()-1]/prices[prices.size()-248]<<"\n";

	myfile2<<"Empirical ,"<<orders.size()<<","<<calculateTotalReturn(orders)
	<<","<<calculatePercentagePositive(orders)*100
	<<"%,"<<calculateAverageLoss(orders)
	<<","<<((calculatePercentagePositive(orders)*calculateAverageLoss(orders))-1+calculatePercentagePositive(orders))/calculateAverageLoss(orders)
	<<","<<calculateAverageReturn(orders)/pow((getVarianceOfReturns(orders)/orders.size()),.5)
	<<","<<maxInSet(prices)-prices[prices.size()-1]
	<<","<<averageInSet(prices)<<","<<maxInSet(prices)
	<<","<<minInSet(prices)
	<<","<<prices[prices.size()-1]/prices[prices.size()-5]
	<<","<<prices[prices.size()-1]/prices[prices.size()-24]
	<<","<<prices[prices.size()-1]/prices[prices.size()-64]
	<<","<<prices[prices.size()-1]/prices[prices.size()-38]
	<<","<<prices[prices.size()-1]/prices[prices.size()-248]<<"\n";

	//calculate log returns;
	vector<float> returns = priceToReturns(prices);


	//analyze coefficents alpha, beta using OLS
	//r_t = alpha + beta * r_t-1 + e_t

	//get t set of returns

	vector<float> returns_t;
	vector<float> returns_t_1;
	vector<float> returns_t_2;

	for(unsigned int i = 1;i<returns.size();i++)
	{
		returns_t.push_back(returns[i]);
	}

	//get t-1 set of returns

	returns.pop_back();
	returns_t_1 = returns;

	//get t-2 set of returns

	returns.pop_back();
	returns_t_2 = returns;

	double r_t[returns_t.size()];
	double r_t_1[returns_t_1.size()];

	for (unsigned int i = 0; i<returns_t.size();i++)
	{
		r_t[i] = (double)returns_t[i];
		r_t_1[i] = (double)returns_t_1[i];
	}

    Maths::Regression::Linear A(returns_t.size(), r_t_1, r_t);



    cout << "Slope = " << A.getSlope() << endl;
    cout << "Intercept = " << A.getIntercept() <<endl;

    double beta = A.getSlope();
    double alpha = A.getIntercept();

    //calcuate standard deviation

    double sigma = sqrt((double)varianceInSet(returns));
    double sigma2 = (double)varianceInSet(returns);
    //double sigma = sqrt((double)varianceInSet(prices));

    cout << "Sigma = " << sigma << endl <<"Sigma^2 = " << sigma2 << endl;


	//bootstrap AR(1) model
	//Run bootstrap 500 times
    ofstream pricefile;
    pricefile.open ("pricefile.csv", ios::out | ios::app);
	for(int i = 0; i < 500; i ++)
	{
		vector<float> new_returns;
		vector<float> new_prices;

		vector<string> new_buyOrSell;
		vector<Order*> new_orders;

		//cout <<"before returns loop: "<<endl;

		new_returns.push_back(alpha + rand_normal(0,sigma));

		//rand_normal(double mean, double stddev)
		for(unsigned int k = 1;k<returns_t.size();k++)
		{
		    //bootstrapped log returns
			new_returns.push_back(alpha + (beta*new_returns[k-1]) + rand_normal(0,sigma) );

		}


		//create new prices (p_t = exp(r_t)
		//Correct expression is p(t) = p(t-1)*exp[r(t)]. You can assume that original price p(0) remains always the same.
		new_prices.push_back(prices[0]);
		for(unsigned int k = 0;k<new_returns.size();k++)
		{
			new_prices.push_back(new_prices[k]*exp(new_returns[k]));
		}

		//new_prices = returnsToPrices(new_returns, prices[0]);
		for (unsigned int k = 0; k < new_prices.size();k++)
		{
			pricefile << new_prices[k] << ",";
		}
		pricefile<<endl;

		//create buy/sell signals from strategy with new prices

		new_buyOrSell = movingAverageStrategy(new_prices);


		// process signals and apply moving average strategy
		new_orders = processSignals(new_buyOrSell);

		//run performance numbers
		performanceMeasures1(new_orders,new_prices, i);

	}

	ofstream pricefile2;
	pricefile2.open ("pricefile2.csv", ios::out | ios::app);
	//bootstrap AR(2) with manually calculated numbers
	for(int i = 0; i < 500; i ++)
	{
		//Intercept	-0.000968211
		//X Variable 1	0.010397598
		//X Variable 2	0.049822123

		float alpha2 = -0.000968211;
		float beta1 = 0.010397598;
		float beta2 = 0.049822123;


		vector<float> new_returns2;
		vector<float> new_prices2;

		vector<string> new_buyOrSell;
		vector<Order*> new_orders;

		//cout <<"before returns loop: "<<endl;

		new_returns2.push_back(alpha2 + rand_normal(0,sigma));
		new_returns2.push_back(alpha2 + (beta1*new_returns2[0]) + rand_normal(0,sigma) );

		//rand_normal(double mean, double stddev)
		for(unsigned int k = 2;k<returns_t.size();k++)
		{
		    //bootstrapped log returns
			new_returns2.push_back(alpha2 + (beta1*new_returns2[k-1]) + (beta2*new_returns2[k-2])+ rand_normal(0,sigma) );

		}





		//Correct expression is p(t) = p(t-1)*exp[r(t)] + p(t-2)*exp[r(t-1)]. You can assume that original price p(0) remains always the same.
		new_prices2.push_back(prices[0]);
		for(unsigned int k = 0;k<new_returns2.size();k++)
		{
			new_prices2.push_back((new_prices2[k]*exp(new_returns2[k])));
		}


		for (unsigned int k = 0; k < new_prices2.size();k++)
		{
			pricefile2 << new_prices2[k] << ",";
		}
		pricefile2<<endl;

		//new_prices = returnsToPrices(new_returns, prices[0]);

		//create buy/sell signals from strategy with new prices

		new_buyOrSell = movingAverageStrategy(new_prices2);




		// process signals and apply moving average strategy
		new_orders = processSignals(new_buyOrSell);

		//run performance numbers
		performanceMeasures2(new_orders,new_prices2, i);

	}



	//int num_test = 0;
	//new_prices = returnsToPrices
	//performanceMeasures(orders,new_prices, num_test);

	myfile.close();
	pricefile.close();

	myfile2.close();
	pricefile2.close();


	return 0;

}