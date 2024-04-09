# 1926 그림

from collections import deque


def bfs(a,b,graph):
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    cnt = 1
    q = deque()
    q.append((a,b)) #탐색할 포지션 큐에 넣기
    graph[a][b] =0 # visited 대신 맵 0으로 바꿔버리기
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < len(graph) and 0<= ny < len(graph[0]):
                if graph[nx][ny] == 1 :
                    graph[nx][ny] = 0
                    q.append((nx,ny))
                    cnt +=1
    return cnt



n,m = map(int, input().split())
graph = [list(map(int,input().split())) for _ in range(n)]


ans = []
for i in range(n):
    for j in range(m):
        if graph[i][j] ==1:
            w = bfs(i,j,graph)
            ans.append(w)


print(len(ans))
if not len(ans):
    print(0)
else:
    print(max(ans))