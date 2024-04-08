# 10828 스택

import sys
from collections import deque

n = int(sys.stdin.readline())
s = deque()

for i in range(n):
    command = sys.stdin.readline().split()
    
    if command[0] == 'push':
        s.append(command[1])
    elif command[0] == 'pop':
        if len(s):
            print(s.pop())
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(s))
    elif command[0] == 'empty':
        if len(s):
            print(0)
        else:
            print(1)
    elif command[0] == 'top':
        if len(s):
            print(s[-1])
        else:
            print(-1)