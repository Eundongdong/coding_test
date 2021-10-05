#빠르게 읽기 위해서 input 대신 sys.stdin.readline 사용

import sys


while(1):
    a, b = map(int,sys.stdin.readline().split())
    if(a ==0 and b ==0):
        break
    else:
        print(a+b)
    