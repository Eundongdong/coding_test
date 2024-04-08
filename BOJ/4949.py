# 4949 균형잡힌 세상

import sys
from collections import deque

while True:
    flag = 1
    s = deque()
    sentence = sys.stdin.readline().rstrip('\n')
    if sentence =='.':
      break
    else:
        for i in sentence:
            if i =='(' or i=='[':
                s.append(i)
            elif i==')' or i==']':
                if len(s)>0:
                    if i==']' and s[-1] =='[':
                        s.pop()
                    elif i ==')' and s[-1] =='(':
                        s.pop()
                    else:
                        print('no')
                        flag =0
                        break
                        
                else:
                    print('no')
                    flag = 0
                    break
        if flag:
            if len(s) and flag:
                print('no')
            else:
                print('yes')
        
   