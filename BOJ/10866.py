# 10866 덱

import sys
from collections import deque

n = int(sys.stdin.readline())
s = deque()

for _ in range(n):
    command = sys.stdin.readline().split()
    
    if command[0] == 'push_front':
        s.appendleft(command[1])
    elif command[0] == 'push_back':
        s.append(command[1])
    elif command[0] == 'pop_front':
        if len(s):
            print(s.popleft())
        else:
            print(-1)
    elif command[0] == 'pop_back':
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