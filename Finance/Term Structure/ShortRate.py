#Short Rate Lattice

level = 5

lattice = [[0 for i in range(j+1)] for j in range(level+1)]


root = 0.06
lattice[0][0] = root


u = 1.25
d = .9




for i in range(0,level):
	for j in range(0,i+1):
		lattice[i+1][j] = round(lattice[i][j] * d,5)
		lattice[i+1][j+1] = round(lattice[i][j] * u,5)


print("Printing Short Rates for " + str(level) + " levels")

for i in lattice:
	print(i)



