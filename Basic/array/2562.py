lists = list()
for i in range(9) :
    lists.append(int(input()))
    
m = max(lists)
print(m)
print(lists.index(m)+1)