# 7576 토마토
# 먼저 익은 토마토를 모두 탐색 대기 큐에 넣어두고, 탐색을 돌려버리기

from collections import deque

m, n = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

q = deque()

for i in range(n):
    for j in range(m):
        if graph[i][j] ==1:
            q.append((i,j))

while q:
    x, y = q.popleft()
    for idx in range(4):
        nx = x + dx[idx]
        ny = y + dy[idx]
        
        if 0<= nx < n and 0 <= ny < m:
            if graph[nx][ny] ==0:
                graph[nx][ny] =graph[x][y] +1 # 일 수 계산
                q.append((nx,ny))
                
ans = 0


for line in graph:
    for tomato in line:
        if tomato ==0:
            print(-1)
            exit()
    ans = max(ans, max(line))
print(ans -1)
