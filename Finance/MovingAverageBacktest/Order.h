#ifndef ORDER_H_
#define ORDER_H_

#include <iostream>

using namespace std;

class Order
{
	private:

		float buyPrice;
		float sellPrice;
		int sellTime;

	public:
		Order(){buyPrice=0;sellPrice=0;}

		Order(float buy,float sell, int time){
			buyPrice = buy;
			sellPrice = sell;
			sellTime = time;
		}

		void printInfo(){
			cout<<"Buy: "<<buyPrice<<endl;
			cout<<"Sell: "<<sellPrice<<endl;
			cout<<"Return: "<<buyPrice-sellPrice<<endl;
		}

		float getReturn(){
			return buyPrice-sellPrice;
		}

		static Order *make_order(float buy, float sell, int time);

};



		Order *Order::make_order(float buy, float sell, int time){
			return new Order(buy, sell, time);
		}

#endif /*ORDER_H_*/
