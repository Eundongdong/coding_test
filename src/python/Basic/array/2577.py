num = list()
for i in range(3):
    num.append(int(input()))

res = int(num[0]*num[1]*num[2])

x = [0,0,0,0,0,0,0,0,0,0]

while(res>=10):
    a = int(res % 10)
    x[a] = x[a]+1
    res = res //10
if(res <10):
    x[res] = x[res]+1

for i in range(len(x)):
    print(x[i])
