# 10845 큐

import sys
from collections import deque

n = int(sys.stdin.readline())
s = deque()
for _ in range(n):
    command = sys.stdin.readline().split()
    
    if command[0] == 'push':
        s.append(command[1])
    elif command[0] == 'pop':
        if len(s):
            print(s.popleft())
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(s))
    elif command[0] == 'empty':
        if len(s):
            print(0)
        else:
            print(1)
    elif command[0] == 'front':
        if len(s):
            print(s[0])
        else:
            print(-1)
    elif command[0] == 'back':
        if len(s):
            print(s[-1])
        else:
            print(-1)