def selfcheck(n):
  strn = str(n)
  res = n
  for i in strn:
    res = res + int(i)
  return res

a = []
for i in range(1,10001):
    n = i
    while True:
        n = selfcheck(n)
        if(n > 10000): break
        elif(n in a): break
        a.append(n)
for j in range(1,10001):
    if (j not in a):
        print(j)