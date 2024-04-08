#다리를 지나는 트럭
#스택/큐

from collections import deque

def solution(bridge_length, weight, truck_weights):
    l=[0]*bridge_length
    l[-1]=truck_weights[0]
    q=deque(l)
    q2 = deque(truck_weights)
    w=q2.popleft()

    c=1

    while len(q2)>0:
        x=q.popleft()
        if x!=0:
            w-=x
        if w+q2[0]>weight:
            q.append(0)
        else:
            w+=q2[0]
            q.append(q2[0])
            q2.popleft()            
        c+=1

    return c+bridge_length