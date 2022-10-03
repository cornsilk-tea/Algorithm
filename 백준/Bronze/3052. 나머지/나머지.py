arr = []
for i in range(10):
  arr.append(int(input())%42)
cnt = 0
resarr = []
for n in arr:
  if n not in resarr:
    cnt = cnt + 1
    resarr.append(n)
print(len(resarr))