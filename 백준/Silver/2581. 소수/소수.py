# M이상 N이하의 자연수 중 소수인 것을 모두 찾아 
# 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 
# 단, M이상 N이하의 자연수 중 소수가 없을 경우는 
# 첫째 줄에 -1을 출력한다.
def prime(n):
    if n == 1:
        return False
    elif n == 2:
        return True
    for i in range(2,n):
        if n%i == 0:
            return False
    return True

m = int(input())
n = int(input())
lst = []
for i in range(m,n+1):
    if prime(i):
        lst.append(i)
if len(lst) == 0:
    print(-1)
else:
    res = 0
    for i in lst:
        res += i
    print(res)
    print(min(lst))