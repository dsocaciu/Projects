//#include "StdAfx.h"
#include "Book.h"
#include <stdarg.h>

Book* Book::m_pInstance = NULL;

Book::Book(void)
{
 	// // create map at first time
}

Book::~Book(void)
{
	//delete map
}

Book* Book::Instance()
{
   if (!m_pInstance)   // Only allow one instance of class to be generated.
        m_pInstance = new Book;

   return m_pInstance;
}