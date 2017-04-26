#Step 3

from fractions import Fraction



class Node:
	def __init__(self,Level=None,Price=None,Up=None, Down=None):

		self.Level = Level
		self.Price = Price 
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

	for i in  Lattice[Level]:
		if i.Price == price:
			return 1
	return 0

def getNode(Level, price):
	for i in Lattice[Level]:
		if i.Price == price:
			return i



def CalculateLevels(Level,node):
	
	currentLevel = node.Level+1

	if currentLevel <= Level:

		#check if Node exists
		#UpNode = Node(currentLevel,node.Price*u)
		#DownNode = Node(currentLevel,node.Price*d)
		#if UpNode not in Lattice[currentLevel]:
		#	node.Up = UpNode
		#	Lattice[currentLevel].append(UpNode)
		#	CalculateLevels(Level,UpNode)
		#if DownNode not in Lattice[currentLevel]:
		#	node.Down = DownNode
		#	Lattice[currentLevel].append(DownNode)
		#	CalculateLevels(Level,DownNode)

		
		upPrice = round(node.Price*u,2)
		downPrice = round(node.Price*d,2)

		if currentLevel not in Lattice:
			Lattice[currentLevel] = []

		if findPrice(currentLevel,upPrice):
			node.Up = getNode(currentLevel,upPrice)	
		else:
			UpNode = Node(currentLevel,upPrice)
			node.Up = UpNode
			Lattice[currentLevel].append(UpNode)

		if findPrice(currentLevel,downPrice):
			node.Down = getNode(currentLevel,downPrice)
		else:
			DownNode = Node(currentLevel,downPrice)
			node.Down = DownNode
			Lattice[currentLevel].append(DownNode)



		CalculateLevels(Level,node.Up)
		CalculateLevels(Level,node.Down)




Lattice = {}

root = Node(0,Fraction(100,1))

Lattice[0] = []
Lattice[0].append(root)

u = Fraction(107,100)
d = Fraction(1,u)

CalculateLevels(3,root)

#print(str((100*d)*u))

print("Printing Stock Prices for 3 levels")


for i in Lattice:
	print(str(i) + " " * int(i) + str(Lattice[i]))

