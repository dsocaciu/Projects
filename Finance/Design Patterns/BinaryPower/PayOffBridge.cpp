//
//
//               PayOffBridge.cpp
//
//

#include"PayOffBridge.h"

PayOffBridge::PayOffBridge(const PayOffBridge& original)
{
    ThePayOffPtr = original.ThePayOffPtr->clone();
}

PayOffBridge::PayOffBridge(const PayOff& innerPayOff)
{
    ThePayOffPtr = innerPayOff.clone();
}


PayOffBridge::~PayOffBridge()
{
    delete ThePayOffPtr;
}

PayOffBridge& PayOffBridge::operator=(const PayOffBridge& original)
{
    if (this != &original)
    {
        delete ThePayOffPtr;
        ThePayOffPtr = original.ThePayOffPtr->clone();
    }

    return *this;
}




PayOffBridgeDigital::PayOffBridgeDigital(const PayOffBridgeDigital& original) : PayOffBridge(original)
{
    ThePayOffDigPtr = original.ThePayOffDigPtr->clone();
}

PayOffBridgeDigital::PayOffBridgeDigital(const PayOffDigital& innerPayOff) : PayOffBridge(innerPayOff)
{
    ThePayOffDigPtr = innerPayOff.clone();
}


PayOffBridgeDigital::~PayOffBridgeDigital()
{
    delete ThePayOffDigPtr;
}

PayOffBridgeDigital& PayOffBridgeDigital::operator=(const PayOffBridgeDigital& original)
{
    if (this != &original)
    {
        delete ThePayOffDigPtr;
        ThePayOffDigPtr = original.ThePayOffDigPtr->clone();
    }

    return *this;
}

PayOffBridgePower::PayOffBridgePower(const PayOffBridgePower& original) : PayOffBridge(original)
{
    ThePayOffPowPtr = original.ThePayOffPowPtr->clone();
}

PayOffBridgePower::PayOffBridgePower(const PayOffPower& innerPayOff) : PayOffBridge(innerPayOff)
{
    ThePayOffPowPtr = innerPayOff.clone();
}


PayOffBridgePower::~PayOffBridgePower()
{
    delete ThePayOffPowPtr;
}

PayOffBridgePower& PayOffBridgePower::operator=(const PayOffBridgePower& original)
{
    if (this != &original)
    {
        delete ThePayOffPowPtr;
        ThePayOffPowPtr = original.ThePayOffPowPtr->clone();
    }

    return *this;
}

