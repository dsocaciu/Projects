#6 year 10% Coupon Bond

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

print("Printing " + str(bondyear) + " Year " + str(coupon_rate*100) + "% Coupon Bond")

for i in couponbond:
	print(i)

print(couponbond[0][0])