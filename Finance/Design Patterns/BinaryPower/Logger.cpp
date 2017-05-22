//#include "StdAfx.h"
#include "Logger.h"
#include <stdarg.h>

Logger* Logger::m_pInstance = NULL;

Logger::Logger(void)
{
 	m_pf = fopen(LOG_FILE,"a"); // open file at first time
}
 
Logger::~Logger(void)
{
	if (m_pf) fclose(m_pf); // close file
}

Logger* Logger::Instance()
{
   if (!m_pInstance)   // Only allow one instance of class to be generated.
        m_pInstance = new Logger;

   return m_pInstance;
}

void Logger::print(char *format,...) // wrtie formated string into file
{
	va_list marker;
	va_start( marker, format );     /* Initialize variable arguments. */

	vfprintf( m_pf,format,marker);

	va_end(marker);	

	fflush(m_pf);
}
