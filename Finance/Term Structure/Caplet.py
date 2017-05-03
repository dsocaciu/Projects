#Caplet

from copy import deepcopy

fixed_rate = .02

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


print("Printing Short Rates for " + str(level) + " levels")

for i in shortrate:
	print(i)




caplet = deepcopy(shortrate)





# for the default level of 5, this prices out a 4 year zero coupon bond
for i in range(len(caplet)-1,-1,-1):
	for j in range(len(caplet[i])-1,-1,-1):
		if i == len(caplet)-1:
			caplet[i][j] = round((shortrate[i][j]-fixed_rate)/(1+shortrate[i][j]),4)
		#print(str(i) + " " + str(j))
		else:
			caplet[i][j] = round(((caplet[i+1][j+1]*q) + (caplet[i+1][j]*one_minus_q)) / (1+shortrate[i][j]),5)


print("Printing Zero Couponfor " + str(level) + " levels")

for i in caplet:
	print(i)

print(caplet[0][0])