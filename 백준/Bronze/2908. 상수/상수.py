num1, num2 = input().split()
rev1, rev2 = [],[]
a, b = '', ''
for i in num1:
  rev1.append(i)
for i in num2:
  rev2.append(i)
rev1.reverse()
rev2.reverse()
for i in rev1:
  a = a + i
for i in rev2:
  b = b + i
a = int(a)
b = int(b)
if a > b:
  print(a)
else:
  print(b)