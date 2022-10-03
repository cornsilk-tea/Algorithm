k = int(input())
cnt = 0
while k>=0:
    if k % 5 == 0:
        cnt += k//5
        print(cnt)
        break
    else:
        k -= 3
        cnt += 1
else:
    print(-1)
