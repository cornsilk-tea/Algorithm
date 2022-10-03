n = int(input())
case = []
for i in range(n):
  case.append(list(map(int,input().split())))
for i in range(n):
  average = 0
  cnt = 0
  for j in range(case[i][0]):
    average = average + case[i][j+1]
  average = average/case[i][0]
  for k in range(case[i][0]):
    if case[i][k+1] > average:
      cnt = cnt + 1
  res = cnt/case[i][0]*100
  print("%.3f%%" %round(res, 3))