from fractions import Fraction
	

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

#Level 0 - Root


print(str(root.Level)+ " " * root.Level + str(float(root.Price)))

#Level 1

print(str(upNode.Level) + " " * upNode.Level + str(float(upNode.Price)))
print(str(downNode.Level) + " " * downNode.Level + str(float(downNode.Price)))

#Extensions beyond one step

#Level 2

upupNode, updownNode = CalculateNextLevel(upNode)

print(str(upupNode.Level) +   " "  * upupNode.Level + str(float(upupNode.Price)))
print(str(updownNode.Level) + " "  * updownNode.Level + str(float(updownNode.Price)))

downupNode, downdownNode = CalculateNextLevel(downNode)

print(str(downupNode.Level) + " " * downupNode.Level + str(float(downupNode.Price)))
print(str(downdownNode.Level) + " " * downdownNode.Level + str(float(downdownNode.Price)))

# Level 3

upupupNode, upupdownNode= CalculateNextLevel(upupNode)


print(str(upupupNode.Level) + " " * upupupNode.Level + str(float(upupupNode.Price)))
print(str(upupdownNode.Level) + " " * upupdownNode.Level + str(float(upupdownNode.Price)))

updownupNode, updowndownNode = CalculateNextLevel(updownNode)

print(str(updownupNode.Level) + " " * updownupNode.Level+ str(float(updownupNode.Price)))
print(str(updowndownNode.Level) + " " * updowndownNode.Level+ str(float(updowndownNode.Price)))


downupupNode, downupdownNode= CalculateNextLevel(downupNode)


print(str(downupupNode.Level) + " " * downupupNode.Level + str(float(downupupNode.Price)))
print(str(downupdownNode.Level) + " " * downupdownNode.Level + str(float(downupdownNode.Price)))

downdownupNode, downdowndownNode = CalculateNextLevel(downdownNode)

print(str(downdownupNode.Level) + " " * downdownupNode.Level+ str(float(downdownupNode.Price)))
print(str(downdowndownNode.Level) + " " * downdowndownNode.Level+ str(float(downdowndownNode.Price)))





