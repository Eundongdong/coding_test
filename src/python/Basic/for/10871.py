#input은 한 줄 단위여서 이렇게 두 개로 나누어서 할 수 있다.
#여러 값이 들어오는데 하나의 변수에 담으려면 리스틀를 사용해야 한다.

x, y = map(int,input().split())
a = list(map(int,input().split()))

for i in range(x) :
    if a[i] < y:
        print(a[i],end=" ")