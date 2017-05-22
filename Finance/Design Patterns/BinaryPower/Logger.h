#pragma once
#include <stdio.h>

using namespace std;

#define LOG_FILE	"TestResult.txt"

class Logger
{
public:
	static Logger* Instance();     // get Instance
	void print(char *format,...);  // print into file

private:
	Logger(void);				// cannot intantiate an object 
	Logger(Logger const&){};    // cannot copy
	~Logger(void);

	FILE *m_pf;
	static Logger* m_pInstance;	
};

 
