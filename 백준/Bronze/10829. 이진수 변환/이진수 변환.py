def binary(n):
    if n == 0:
        return 0
    else:
        return int(str(binary(n//2)) + str(n%2))
n = int(input())
# print(binary(n))
print(binary(n))