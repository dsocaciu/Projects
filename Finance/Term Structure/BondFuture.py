# Bond Forward

from copy import deepcopy

shortrate_level = 5

shortrate = [[0 for i in range(j+1)] for j in range(shortrate_level+1)]

rate_root = 0.06
shortrate[0][0] = rate_root


u = 1.25
d = .9

q = .5
one_minus_q = .5

coupon_rate = .10

for i in range(0,shortrate_level):
	for j in range(0,i+1):
		#print(round(shortrate[i-1][j]*down,5))
		#print(str(i) + " " + str(j))
		shortrate[i+1][j] = round(shortrate[i][j] * d,5)
		shortrate[i+1][j+1] = round(shortrate[i][j] * u,5)


print("Printing Short Rates for " + str(shortrate_level) + " levels")

for i in shortrate:
	print(i)

bondyear = 6

couponbond = [[0 for i in range(j+1)] for j in range(bondyear+1)]

#initialize the face value to be 100

couponbond[len(couponbond)-1] = [round(100*(1+coupon_rate),5)] * len(couponbond)

# for the default level of 5, this prices out a 4 year zero coupon bond
for i in range(len(couponbond)-2,-1,-1):
	for j in range(len(couponbond[i])-1,-1,-1):
		#print(str(i) + " " + str(j))
		couponbond[i][j] = round(100*coupon_rate+(((couponbond[i+1][j+1]*q) + (couponbond[i+1][j]*one_minus_q)) / (1+shortrate[i][j])),5)

zerolevel = 4
zerocoupon = [[0 for i in range(j+1)] for j in range(zerolevel+1)]

#initialize the face value to be 100

zerocoupon[len(zerocoupon)-1] = [100] * len(zerocoupon)

# for the default level of 5, this prices out a 4 year zero coupon bond
for i in range(len(zerocoupon)-2,-1,-1):
	for j in range(len(zerocoupon[i])-1,-1,-1):
		#print(str(i) + " " + str(j))
		zerocoupon[i][j] = round(((zerocoupon[i+1][j+1]*q) + (zerocoupon[i+1][j]*one_minus_q)) / (1+shortrate[i][j]),5)


print("Printing Zero Couponfor " + str(zerolevel) + " levels")

for i in zerocoupon:
	print(i)

print(zerocoupon[0][0])

print("Printing " + str(bondyear) + " Year " + str(coupon_rate*100) + "% Coupon Bond")

for i in couponbond:
	print(i)

print(couponbond[0][0])

bondforward_maturity = 4 
bondforward =  deepcopy(couponbond[0:bondforward_maturity+1])

#subtract coupon from the forward
bondforward[len(bondforward)-1] = [x-(100*coupon_rate) for x in bondforward[len(bondforward)-1]]

for i in range(len(bondforward)-2,-1,-1):
	for j in range(len(bondforward[i])-1,-1,-1):
		#print(str(i) + " " + str(j))
		bondforward[i][j] = round(((bondforward[i+1][j+1]*q) + (bondforward[i+1][j]*one_minus_q)) / (1+shortrate[i][j]),5)



print ("Printing " + str(bondforward_maturity) + " Period Bond Forward")
for i in bondforward:
	print(i)

print("Bond Forward Price " + str(round(100*bondforward[0][0]/zerocoupon[0][0],4)))

bondfuture_maturity = 4
bondfuture = deepcopy(couponbond[0:bondfuture_maturity+1])

#subtract coupon from the future
bondfuture[len(bondfuture)-1] = [x-(100*coupon_rate) for x in bondfuture[len(bondfuture)-1]]

for i in range(len(bondfuture)-2,-1,-1):
	for j in range(len(bondfuture[i])-1,-1,-1):
		#print(str(i) + " " + str(j))
		bondfuture[i][j] = round(((bondfuture[i+1][j+1]*q) + (bondfuture[i+1][j]*one_minus_q)),5)

print ("Printing " + str(bondfuture_maturity) + " Period Bond Future")
for i in bondfuture:
	print(i)	

print("Bond Future " + str(bondfuture[0][0]))





