n = int(input())
cnt = 1#방 기준이 되는 숫자
plus = 6 #6씩 커지는 수열
count = 1#거치는 방 횟수
if n == 1: print(1)
else:
    while True:
        cnt += plus
        count += 1
        if n <= cnt:
            print(count)
            break
        plus += 6