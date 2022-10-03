def prime(n):
    if n == 1:
        return False
    elif n == 2:
        return True
    for i in range(2,n):
        if n%i == 0:
            return False
    return True
n = int(input())
lst = list(map(int,input().split()))
count = 0
for i in lst:
    if prime(i) == True:
        count += 1
print(count)