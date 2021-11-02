N = int(input())

for i in range(N):
  score = list(map(int, input().split(' ')))

  average = sum(score[1:])/score[0]
  cnt = 0

  for score in score[1:]:
    if score > average:
      cnt += 1
  result = cnt / score[0] * 100
  print(f'{result:.3f}%')