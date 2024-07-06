# 스택 수열
# 처음 풀이 : for문을 돌며 한개씩 비교하며 push, pop을 한 후, arr를 모두 꺼냈다면 나머지를 pop하여 만들어야 할 수열과 비교

from collections import deque
from copy import deepcopy
n = int(input())
# 만들어야 할 수열 arr
arr = deque(list(int(input()) for _ in range(n)))
compare_arr= deepcopy(arr)
# 1부터 n까지 수
stack = [i for i in range(n)]
# push 저장 스택
tmp = []
# push, pop 저장
answer = []
#NO Signal
sig = 1
#arr idx
idx = 0
i =1
#arr를 모두 pop할 때까지
while i <= n:
    if len(tmp):
        if tmp[-1] == arr[idx]:
            tmp.pop()
            idx+=1
            answer.append('-')
        else:
            tmp.append(i)
            answer.append('+')
            i +=1
    else:
        tmp.append(i)
        answer.append('+')
        i +=1
while idx <n:
    if tmp.pop() == arr[idx]:
        idx+=1
        answer.append('-')
    else:
        sig = 0
        break

if sig:
    print("\n".join(str(i) for i in answer))
else:
    print("NO")