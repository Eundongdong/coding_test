# 2504 괄호의 값

import sys
from collections import deque

n = sys.stdin.readline().rstrip('\n')
s = deque()
tmp = 1
ans = 0
for i in range(len(n)):
    if n[i] =='(':
        s.append('(')
        tmp *= 2 
    elif n[i] == '[':
        s.append('[')
        tmp *=3
    elif n[i] == ')':
        if not s or s[-1] =='[':
            ans = 0
            break    
        if n[i-1] =='(':
            ans += tmp
        s.pop()    
        tmp //=2

    elif n[i] == ']':
        if not s or s[-1] =='(':
            ans = 0
            break    
        if n[i-1] =='[':
            ans += tmp
        s.pop()    
        tmp //=3
        
if len(s):
    print(0)
else:
    print(ans)