a = int(input())
z = 0
i = 0
while(1):    
    b = a /10
    c = a % 10
    x = b+c
    y = c+(x%10)
    z = (x%10) + (y%10)
    if (a == z):
        break
    else:
        i = i + 1
        a = z

print(i)