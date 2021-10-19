a = int(input()) #몇 개가 올 지 갯수 새어주는 변수 a
for i in range(a):  #변수 만큼반복
    b = input() #한번에 input을 받고
    s = list(b) #이것을 그냥 바로 리스트에 넣음
    sum = 0 #최종 print할 변수
    c = 1 #연속된 O인지 확인하기 위한 변수
    for i in s:
        if i == 'O':
            sum += c 
            c += 1
        else:
            c = 1
    print(sum)