#pragma once
#include <stdio.h>
#include <map>
using namespace std;



class Book
{
public:
	static Book* Instance();     // get Instance

private:
	Book(void);				// cannot intantiate an object
	Book(Book const&){};    // cannot copy
	~Book(void);

	static Book* m_pInstance;

};


