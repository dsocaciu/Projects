#swap

from copy import deepcopy



level = 5

shortrate = [[0 for i in range(j+1)] for j in range(level+1)]

rate_root = 0.06
shortrate[0][0] = rate_root


u = 1.25
d = .9

q = .5
one_minus_q = .5

for i in range(0,level):
	for j in range(0,i+1):
		#print(round(shortrate[i-1][j]*down,5))
		#print(str(i) + " " + str(j))
		shortrate[i+1][j] = round(shortrate[i][j] * d,5)
		shortrate[i+1][j+1] = round(shortrate[i][j] * u,5)


print("Printing Short Rate " + str(level) + " levels")

for i in shortrate:
	print(i)

swap_fixed_rate = .05
swap = [[0 for i in range(j+1)] for j in range(level+1)]

for i in range(len(swap)-1,-1,-1):
	for j in range(len(swap[i])-1,-1,-1):
		if i == len(swap)-1:
			#print("pre assign: " + str(swap[i][j]) + " ; swap_fixed_rate" + str(swap_fixed_rate) )
			swap[i][j] = round((shortrate[i][j]-swap_fixed_rate)/(1+shortrate[i][j]),5)
			#print("post assign: " + str(swap[i][j]))
		#print(str(i) + " " + str(j))
		else:
			swap[i][j] = round(((shortrate[i][j]-swap_fixed_rate) + (swap[i+1][j+1]* q) + (swap[i+1][j] * one_minus_q))/(1+shortrate[i][j]),4)


print("Printing Swap for " + str(level) + " levels")

for i in swap:
	print(i)

print(swap[0][0])