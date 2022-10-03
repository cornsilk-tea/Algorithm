n = int(input())

for i in range(n):
  a = ''
  case = input().split(' ')
  for j in case[1]:
    for k in range(int(case[0])):
      a += j
  print(a)