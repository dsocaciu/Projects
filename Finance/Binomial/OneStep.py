#Step 1

from fractions import Fraction

class Lattice:
	NodeDict = {}


class Node:
	def __init__(self,Level=None,Price=None,Up=None, Down=None):

		self.Level = Level
		self.Price = Price 
		self.Up = Up
		self.Down = Down

	def getLevel(self):
		return self.Level


def CalculateNextLevel(node):
	currentLevel = node.getLevel()
	UpNode = Node(currentLevel+1,node.Price*u)
	DownNode = Node(currentLevel+1,node.Price*d)
	node.Up = UpNode
	node.Down = DownNode

	return UpNode,DownNode

root = Node(0,Fraction(100,1))

u = Fraction(107,100)
d = Fraction(1,u)

upNode, downNode = CalculateNextLevel(root)

#print(str((100*d)*u))


print(str(root.Level)+ " " + str(float(root.Price)))

#print(root.Up.Price)
#print(root.Down.Price)

print(str(upNode.Level) + " " + str(float(upNode.Price)))
print(str(downNode.Level) + " " + str(float(downNode.Price)))
