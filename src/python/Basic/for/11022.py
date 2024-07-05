#for 를 이용해 반복적으로 input 을 가져올 수 있다.

cases = int(input())

for i in range(cases):
    a,b = map(int, input().split())
    ans = a + b
    print("Case #%s: %s + %s = %s"%(i+1, a, b, ans ))