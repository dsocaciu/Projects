//
//
//                		main.cpp
//
//
/*
   requires PayOff3.cpp,
            PayOffBridge.cpp,
            Random1.cpp,
            SimpleMC5.cpp
            Vanilla3.cpp
*/
#include<iostream>
#include"SimpleMC5.h"
#include"Option.h"
#include"Logger.h"

using namespace std;

int main()
{

	double Expiry;
	double Strike;
	double Spot;
	double Vol;
	double r;
	unsigned long NumberOfPaths;

	double Power;

	//Logger::Instance()->print("start running \n");

	//Gathering inputs for Digital options

	Logger::Instance()->print("\n Printing inputs for Digital Options \n");

	cout <<"Please enter information for Digital Option";
	cout << "\nEnter expiry\n";
	cin >> Expiry;

	Logger::Instance()->print("Expiry is %f \n",Expiry);

	cout << "\nStrike\n";
	cin >> Strike;

	Logger::Instance()->print("Strike is %f \n", Strike);

	cout << "\nEnter spot\n";
	cin >> Spot;

	Logger::Instance()->print("Spot is %f \n",Spot);

	cout << "\nEnter vol\n";
	cin >> Vol;

	Logger::Instance()->print("Vol is %f \n",Vol);

	cout << "\nr\n";
	cin >> r;

	Logger::Instance()->print("r is %f \n",r);

	cout << "\nNumber of paths\n";
	cin >> NumberOfPaths;

	Logger::Instance()->print("Number of paths is %f \n",NumberOfPaths);

	// setup PayOff for Digital Call and Digital Call Option

    PayOffDigitalCall thePayOff(Strike);

    OptionDigital firstOption(thePayOff, Expiry);

	double result = SimpleMonteCarlo5(firstOption,
                                      Spot,
                                      Vol,
                                      r,
                                      NumberOfPaths);

	Logger::Instance()->print("Printing Digital Options Results:\n");

	cout <<"\nThe digital call price is " << result<< "\n";

	Logger::Instance()->print("The call price is %f \n", result);


	// setup PayOff for Digital Put and Digital Put Option

    PayOffDigitalPut otherPayOff(Strike);
    OptionDigital secondOption(otherPayOff, Expiry);
    //theOption = secondOption;

    result = SimpleMonteCarlo5(secondOption,
                               Spot,
                               Vol,
                               r,
                               NumberOfPaths);

    cout <<"The digital put price is " << result << "\n";

    Logger::Instance()->print("The put price is %f \n", result);

	Logger::Instance()->print("\n Printing inputs for Power Options \n");


	//Gathering inputs for the power options

	cout <<"Please enter information for Power Option";
	cout << "\nEnter expiry\n";
	cin >> Expiry;

	Logger::Instance()->print("Expiry is %f \n",Expiry);

	cout << "\nStrike\n";
	cin >> Strike;

	Logger::Instance()->print("Strike is %f \n", Strike);

	cout << "\nEnter spot\n";
	cin >> Spot;

	Logger::Instance()->print("Spot is %f \n",Spot);

	cout << "\nEnter vol\n";
	cin >> Vol;

	Logger::Instance()->print("Vol is %f \n",Vol);

	cout << "\nr\n";
	cin >> r;

	Logger::Instance()->print("r is %f \n",r);

	cout << "\nNumber of paths\n";
	cin >> NumberOfPaths;

	Logger::Instance()->print("Number of paths is %f \n",NumberOfPaths);

	cout <<"\nPower\n";
	cin >> Power;

	Logger::Instance()->print("Power is %f \n",Power);

	// setup PayOff for Power Call and Power Call Option

    PayOffPowerCall FirstPowerPayOff(Strike,Power);
    OptionPower firstPowerOption(FirstPowerPayOff, Expiry);
    //theOption = secondOption;

    result = SimpleMonteCarlo7(firstPowerOption,
                               Spot,
                               Vol,
                               r,
                               NumberOfPaths);

    cout <<"\nThe power call price is " << result<< "\n";

    Logger::Instance()->print("The power call price is %f \n", result);

    // setup PayOff for Power Put and Power Put Option
    PayOffPowerPut SecondPowerPayOff(Strike,Power);
    OptionPower secondPowerOption(SecondPowerPayOff, Expiry);
    //theOption = secondOption;

    result = SimpleMonteCarlo7(secondPowerOption,
                               Spot,
                               Vol,
                               r,
                               NumberOfPaths);

    cout <<"The power put price is " << result<< "\n";

    Logger::Instance()->print("The power put price is %f \n", result);



    double tmp;
    cin >> tmp;

	return 0;

}


