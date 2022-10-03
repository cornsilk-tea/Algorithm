n, m, l = map(int, input().split())
people=[]
for i in range(n):
    people.append(0)
cnt = 0
p = 0
while True:
    people[p] += 1
    if people[p] == m:
        print(cnt)
        break
    elif people[p]%2!=0: # 홀수
        p = (p+l)%n
    else: # 짝수
        p=(p+(n-l))%n
    cnt += 1
