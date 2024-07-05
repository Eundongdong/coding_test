#다리 놓기
#조합..?

import sys
import math

num = int(input())
for _ in range(num):
    n,m = map(int,input().split())
    if n>m:
        res = math.factorial(n) // (math.factorial(m)*math.factorial(abs(n-m)))
    else:
        res = math.factorial(m) // (math.factorial(n)*math.factorial(abs(n-m)))
    print(res)
    