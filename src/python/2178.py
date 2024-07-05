# 2178 미로탐색


from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]
n, m = map(int, input().split())
graph = [list(map(int,input())) for _ in range(n)]

def bfs(a, b, graph) :
    cnt =1
    q = deque()
    q.append((a,b))
    
    while q :
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < len(graph) and 0<= ny < len(graph[0]):
                if graph[nx][ny] == 1:
                    graph[nx][ny] = graph[x][y] +1
                    q.append((nx,ny))
            
    return graph[n-1][m-1]



a = bfs(0,0,graph)
print(a)

