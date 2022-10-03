# n = 7
n = int(input())
cnt = 0
for i in range(1, n+1):
    for j in range(i, n+1):
        if i*j <= n:
            # print(str(i) + "<->" + str(j))
            cnt += 1
        else: break
print(cnt)