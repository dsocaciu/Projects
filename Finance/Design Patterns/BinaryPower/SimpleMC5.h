//
//
//
//                              SimpleMC5.h
//
//

#ifndef SIMPLEMC5_H
#define SIMPLEMC5_H

#include "Option.h"


double SimpleMonteCarlo3(const Option& TheOption,
						 double Spot,
						 double Vol,
						 double r,
						 unsigned long NumberOfPaths);

double SimpleMonteCarlo5(const OptionDigital& DigOption,
						 double Spot,
						 double Vol,
						 double r,
						 unsigned long NumberOfPaths);


double SimpleMonteCarlo7(const OptionPower& PowOption,
						 double Spot,
						 double Vol,
						 double r,
						 unsigned long NumberOfPaths);


#endif

/*
 *
 * Copyright (c) 2002
 * Mark Joshi
 *
 * Permission to use, copy, modify, distribute and sell this
 * software for any purpose is hereby
 * granted without fee, provided that the above copyright notice
 * appear in all copies and that both that copyright notice and
 * this permission notice appear in supporting documentation.
 * Mark Joshi makes no representations about the
 * suitability of this software for any purpose. It is provided
 * "as is" without express or implied warranty.
*/

