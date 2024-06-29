# 11729 하노이 탑 이동 순서

# n원판을 이동하는 방법 순서
# 1. n-1개의 원반을 2번장대에 옮긴다.
# 2. n번째 원반을 3번장대에 옮긴다.
# 3. 2번 장대에 있는 n-1개의 원반을 3번장대에 옮긴다 (<- 이 부분이 바로 재귀!!)

def hanoi(n, start, end):
    if n==1:
        print(start, end)
        return
    hanoi(n-1,start,6-start-end)
    print(start,end)
    hanoi(n-1,6-start-end,end)

n = int(input())

print(2**n -1)
hanoi(n,1,3)