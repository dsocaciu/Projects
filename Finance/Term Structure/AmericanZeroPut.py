#Zero Coupon Bond

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
		print(str(i) + " " + str(j))
		shortrate[i+1][j] = round(shortrate[i][j] * d,5)
		shortrate[i+1][j+1] = round(shortrate[i][j] * u,5)


print("Printing Short Rates for " + str(level) + " levels")

for i in shortrate:
	print(i)


zerocoupon = [[0 for i in range(j+1)] for j in range(level)]

#initialize the face value to be 100

zerocoupon[len(zerocoupon)-1] = [100] * len(zerocoupon)

# for the default level of 5, this prices out a 4 year zero coupon bond
for i in range(len(zerocoupon)-2,-1,-1):
	for j in range(len(zerocoupon[i])-1,-1,-1):
		zerocoupon[i][j] = round(((zerocoupon[i+1][j+1]*q) + (zerocoupon[i+1][j]*one_minus_q)) / (1+shortrate[i][j]),5)
print ("Printing Zero Coupon Bond Lattice")
for i in zerocoupon:
	print(i)

print("Zero Coupon " + str(zerocoupon[0][0]))

amer_K = 88.00
american_lattice = deepcopy(zerocoupon[0:4])

#print(american_lattice)

for i in range(len(american_lattice)-1,-1,-1):
	for j in range(len(american_lattice[i])-1,-1,-1):
		if i == len(american_lattice)-1:
			american_lattice[i][j] = round(max(amer_K-american_lattice[i][j],0),3)
			#print (str(j))
		else:
			#print(str(i) + " " + str(j) + " " + str(american_lattice[i+1][j+1]) + " " + str(american_lattice[i+1][j]))
			american_lattice[i][j] = round(max(max(amer_K-american_lattice[i][j],0),((american_lattice[i+1][j+1]*q) + (american_lattice[i+1][j]*one_minus_q)) / (1+shortrate[i][j])),5)

print("Printing American Call Lattice")

for i in american_lattice:
	print(i)

print("American Call on Zero Coupon Bond " + str(american_lattice[0][0]))

