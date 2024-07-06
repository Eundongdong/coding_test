# 1679 숨바꼭질

from collections import deque

n, k = map(int,input().split())

def moving(x):
    p = []
    p.append(x+1)
    p.append(x-1)
    p.append(2*x)
    return p

m_list = 100002
list = [-1 for _ in range(m_list)]
ans = []


def bfs(n,list):
    q = deque()
    q.append(n)
    list[n] = 0
    while list[k] == -1:
        x = q.popleft()
        m = moving(x)
        for i in m:
            if 0<=i < m_list and list[i] == -1:
                list[i] = list[x] +1
                q.append(i)

bfs(n,list)
print(list[k])

