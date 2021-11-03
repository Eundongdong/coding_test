def solve(a: list):
    sum = 0
    for i in range(a[1:]):
        if type(a[i]) is int:
            sum += a[i]
    return(sum)
