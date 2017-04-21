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




def CalculateLevels(Level,node):
	
	currentLevel = node.Level+1

	if currentLevel <= Level:

		if currentLevel not in Lattice:
			Lattice[currentLevel] = []

		#check if Node exists
		UpNode = Node(currentLevel,node.Price*u)
		DownNode = Node(currentLevel,node.Price*d)
		if UpNode not in Lattice[currentLevel]:
			node.Up = UpNode
			Lattice[currentLevel].append(UpNode)
			CalculateLevels(Level,UpNode)
		if DownNode not in Lattice[currentLevel]:
			node.Down = DownNode
			Lattice[currentLevel].append(DownNode)
			CalculateLevels(Level,DownNode)


def printNodes(node):

	if node.Up:
		printNodes(node.Up)

	print(node)

	if node.Down:
		printNodes(node.Down)

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

print("Reversing the Lattice")

k = Lattice.keys()

for i in reversed(sorted(k)):
	print(str(i) + " " * int(i) + str(Lattice[i]))


printNodes(root)