#빠르게 읽기 위해서 input 대신 sys.stdin.readline 사용

import sys

cases = int(input())

for i in range(cases):
    a, b = map(int,sys.stdin.readline().split())
    print(a+b)