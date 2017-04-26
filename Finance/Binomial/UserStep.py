#Step 4 - User input for European Call, non-continuous

from math import exp,sqrt
from copy import deepcopy
import sys



class Node:
	def __init__(self,Level,Price,Up=None, Down=None):

		self.Level = Level
		self.Price = Price 
		self.OptionPrice = 0.0
		self.Up = Up
		self.Down = Down

	def __repr__(self):
		return  str(float(self.Price)) 

	def __str__(self):
		return str(self.Level) + " " * self.Level + str(float(self.Price))

	def __eq__(self, other):
		return self.Price == other.Price

	def getLevel(self):
		return self.Level


def findPrice(Level,price):

	for i in  StockLattice[Level]:
		if i.Price == price:
			return 1
	return 0

def getNode(Level, price):
	for i in StockLattice[Level]:
		if i.Price == price:
			return i




def CalculateLevels(Level,node):
	
	currentLevel = node.Level+1


	if currentLevel <= Level:
		
		upPrice = round(node.Price*u,2)
		downPrice = round(node.Price*d,2)

		if currentLevel not in StockLattice:
			StockLattice[currentLevel] = []

		if findPrice(currentLevel,upPrice):
			node.Up = getNode(currentLevel,upPrice)	
		else:
			UpNode = Node(currentLevel,upPrice)
			node.Up = UpNode
			StockLattice[currentLevel].append(UpNode)

		if findPrice(currentLevel,downPrice):
			node.Down = getNode(currentLevel,downPrice)
		else:
			DownNode = Node(currentLevel,downPrice)
			node.Down = DownNode
			StockLattice[currentLevel].append(DownNode)



		CalculateLevels(Level,node.Up)
		CalculateLevels(Level,node.Down)
			



def printNodesIn(node):

	if node.Up:
		printNodesIn(node.Up)

	print(node)

	if node.Down:
		printNodesIn(node.Down)


def printNodesPre(node):

	print(node)

	if node.Up:
		printNodesPre(node.Up)

	if node.Down:
		printNodesPre(node.Down)



def printNodesPost(node):

	if node.Up:
		printNodesPost(node.Up)

	if node.Down:
		printNodesPost(node.Down)

	print(node)





StockLattice = {}

S0 = 100.0
Tyears = .25
sigma = 30
periods = 15
rate = .02
div = .01

#if not given e flag , prompt for user input
if sys.argv[1]  == 'e' :

	S0 = input("Enter the inital Stock Price (default 100): ")
	S0 = int(S0)
	Tyears = input("Enter the time period (default .25): ")
	Tyears = float(Tyears)
	sigma = input("Enter the volatilty (default 30%): ")
	sigma = float(sigma)
	periods = input("Enter the number of periods (default 15): ")
	periods = int(periods)
	rate = input("Enter the interest rate (default 2%): ")
	rate = float(rate)/100.0
	div = input("Enter the dividend yield (default 1%): ")
	div = float(div)/100.0
elif sys.argv[1] == 'd':
	S0 = 100.0
	Tyears = .25
	sigma = 23.4
	periods = 3
	rate = .01
	div = .0



K = 100.0


u = exp((sigma/100)*sqrt(Tyears/periods))
#u = 1.1

print("u: " + str(u))

d = round(1.0/u,5)

print("d: " + str(d))

q = round(((1+rate)-d)/(u-d),4)

one_minus_q = round(1.0 -q,4)

print(q)

print(one_minus_q)

dt = 


root = Node(0,S0)
root.OptionPrice = 0.0

StockLattice[0] = []
StockLattice[0].append(root)

CalculateLevels(periods,root)

#print(str((100*d)*u))

print("Printing Stock Prices for " + str(periods) + " levels")


for i in StockLattice:
	print(str(i) + " " * int(i) + str(StockLattice[i]))


#Some code to print out the lattice dictionary bottom first
print("Create the option lattice")
OptionLattice = deepcopy(StockLattice)

#k = OptionLattice.keys()
for i in reversed(sorted(OptionLattice)):
	#print(i)
	#print(OptionLattice[i])
	for j in OptionLattice[i]:
		if i == len(OptionLattice)-1:
			#print(str(j.OptionPrice))
			j.Price = round(max(j.Price-K,0),2)
			#print(str(j.OptionPrice))
		else:
			#print(str(j.Price) + "; " + str(j.Up.Price) + "; " + str(j.Down.Price))
			j.Price = round((q*j.Up.Price + one_minus_q * j.Down.Price)/(1+rate),2)
			#print(str(j.Price))

for i in reversed(sorted(OptionLattice)):
	print(str(i) + " " * int(i) + str(OptionLattice[i]))

#for i in OptionLattice:
#	print(str(i) + " " * int(i) + str(OptionLattice[i]))


#Printing the binomial tree in different orders
#print("\nPreorder Traversal\n")
#printNodesPre(root)

#print("\nInorder Traversal\n")
#printNodesIn(root)

#print("\nPostorder Traversal\n")
#printNodesPost(root)