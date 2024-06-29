# 1074 Z

# 지그재그로 숫자를 적는 배열중 특정 배열은 숫자가 몇인지?
# [생각한 방법 1]순서를 반환하도록 위치별로 재귀 돌리기
# [생각한 방법 2] 배열에 모든 숫자를 다 적고, 특정 위치의 값 인덱싱 하기

# 생각한 방법 2
"""
graph = [list(0 for _ in range(2**n)) for _ in range(2**n)]

def numbering(x_s,x,y_s,y,cnt):
    if x-x_s ==1:
        graph[x_s][y_s] =cnt
        cnt+=1
        graph[x_s][y] =cnt
        cnt+=1
        graph[x][y_s] =cnt
        cnt+=1
        graph[x][y] =cnt
        cnt+=1
        return
    numbering(x_s,x//2,y_s,y//2,cnt)
    numbering(x_s,x//2,y//2,y,cnt)
    numbering(x//2,x,y_s,y//2,cnt)
    numbering(x//2,x,y//2,y,cnt)
"""
# 너무 많이 반복한다...      
# RecursionError: maximum recursion depth exceeded in comparison

#방법1

def numbering(n,r,c):
    if n ==0:
        return 0
    half = 2**(n-1)
    if r < half and c < half : return numbering(n-1,r,c) # 1사분면
    if r < half and c >= half : return half*half + numbering(n-1,r,c-half) # 2사분면
    if r >= half and c < half : return 2*half*half +numbering(n-1,r-half,c) # 3사분면
    return 3*half*half + numbering(n-1,r-half,c-half) #4사분면


n,r,c = map(int,input().split())

print(numbering(n,r,c))

