# def prime(n):
#     if n == 1:
#         return False
#     elif n == 2:
#         return True
#     for i in range(2,n):
#         if n%i == 0:
#             return False
#     return True

n = int(input())
i = 2
lst = []
while n>1:
    if n % i ==0:
        lst.append(i)
        n = n//i
        continue
    else: i += 1
for i in lst:
    print(i)

# 1. i=2로 시작하여 i++ 하면서 n%i == 0 인지 체크한다.
# 2. n%i==0이 성립하는 경우 i를 소인수로 등록한 후 
#    n은 i로 나눈 값을 저장하고 i는 i++ 하지 않고 
#    i부터 다시 시작하도록 한다.
# 3. n이 1이 될 때까지 위 과정을 반복한다.