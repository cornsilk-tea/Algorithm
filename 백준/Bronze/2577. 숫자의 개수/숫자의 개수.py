a = int(input())
b = int(input())
c = int(input())
res = str(a*b*c)
for i in range(0,10):
  cnt = 0
  for n in range(len(res)):
    if int(res[n]) == i:
      cnt = cnt + 1
  print(cnt)