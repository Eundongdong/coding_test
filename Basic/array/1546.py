n = int(input())
score = list(map(int,input().split()))

max_score = max(score)

new_score = list()
b = 0
for i in range(n):
    a = score[i]/max_score*100
    new_score.append(a)
    b = a + b
    
print(b / n)