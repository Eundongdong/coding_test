# 10799 쇠막대기

import sys
from collections import deque

n = sys.stdin.readline()
s = deque()
flag = 1
ans = 0
for i in n:

    if i == '(':
        s.append('(')
        flag = 1
    elif i == ')':
        s.pop()
        if flag: # 레이저
            ans += len(s)
        else: # 막대기의 끝
            ans +=1
        flag = 0
print(ans)
        