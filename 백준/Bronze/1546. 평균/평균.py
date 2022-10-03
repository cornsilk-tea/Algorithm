n = int(input())
score = list(map(float,input().split()))
m = max(score)
res = 0
for i in range(n):
  score[i] = float((score[i]/m)*100)
  res = float(res + score[i])
print(res/n)
