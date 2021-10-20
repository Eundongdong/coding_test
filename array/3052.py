num = list()
for l in range(10):
    num.append(int(input()))
res = list()
for i in range(len(num)):
    x = num[i]%42
    if x not in res:
        res.append(x)

print(len(res))
### 이 문제 다시 풀기