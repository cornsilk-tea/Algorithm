people = int(input())
time = list(map(int, input().split()))
res = 0
time.sort()
for i in range(people):
    for j in range(i+1):
        res += time[j]
print(res)