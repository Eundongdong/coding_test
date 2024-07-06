# 4179 불!

from collections import deque

# 입력 받기
N, M = map(int, input().split())
graph = [list(input()) for _ in range(N)]

# 탐색 대기 큐, 불 지도 생성
ans =[]
fire_q = deque()
man_q = deque()
fire_map = [[-1 for _ in range(M)] for _ in range(N)] 

# 위치 이동
dx = [0,0,1,-1]
dy = [1,-1,0,0]

# 지훈의 위치, 불 위치 저장
for row in range(N):
    for item in range(M):
        if 0< len(fire_q) and 0< len(man_q):
            break 
        if graph[row][item] == 'J':
            # print("J")
            # print(row,item)
            man_q.append((row,item))
            graph[row][item] = 0
        elif graph[row][item] == 'F':
            # print("F")
            # print(row, item)
            fire_q.append((row,item))
            fire_map[row][item] = 0
             
# 1. 시간에 따른 불 지도 만들기
while fire_q:
    x, y = fire_q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0<=nx<N and 0<=ny<M :
            # 이전에 방문한 적 없고, 갈 수 있는 길이라면
            if fire_map[nx][ny] ==-1 and graph[nx][ny] != '#':
                # 불지도에 걸린 시간 추가
                fire_map[nx][ny] = fire_map[x][y] + 1
                fire_q.append((nx,ny))

# 2. 지훈의 탈출 경로 파악
while man_q:
    x, y = man_q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0<=nx<N and 0<=ny<M :
            #이전에 방문한 적 없고, 불이 번지기 전이라 갈 수 있는 길이라면?!
            if graph[nx][ny] =='.' :
                #기존 맵에 걸린 시간 추가
                if graph[x][y] +1 < fire_map[nx][ny]:
                    graph[nx][ny] = graph[x][y] +1
                    man_q.append((nx,ny))
                    # 가장자리일 시 불지도와 시간 비교
                    if nx ==0 or nx == N-1 or ny == 0 or ny == M-1:
                        #탈출 성공!
                        ans.append(graph[nx][ny])
if len(ans):
    print(min(ans)+1)
else:
    print("IMPOSSIBLE")