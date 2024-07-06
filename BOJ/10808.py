# 알파벳 개수
# 몰랐던 부분 
# chr , ord 함수 검색
# print안에 for 문 넣기 : i for i in v
# print(" ".join(str(i) for i in v))

S = input()
alpha = [0] * 26
for s in S:
    idx = ord(s) - ord('a')
    alpha[idx] +=1

print (" ".join(str(i) for i in alpha))