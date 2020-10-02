import math

i = 0
f = 0
while f < 100*365*24*60*60*1000000:
    f = math.factorial(i)
    i = i+1
    pass

print(i-2)
