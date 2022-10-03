n = int(input())
case = []
for i in range(n):
  case.append(input())
for i in range(n):
  score = 0
  cnt = 1
  for j in case[i]:
    if j == "O":
      if cnt > 0:#만약 전단계에서도 0였을경우
        score = score + cnt
        cnt = cnt+1
      else:#전단계가 x였을경우
        score = score + cnt
        cnt = 1
    else:
      cnt = 1
  print(score)