n = input()
list1 = []
list2 = []
cnt = 0
for i in n:
  i = ord(i)
  if i > 96:
    i -= 32
  if i not in list1:
    list1.append(i)
    list2.append(1)
  else:
    list2[list1.index(i)] += 1
max(list2)
for i in list2:
  if i == max(list2):
    cnt += 1
if cnt > 1:
  print("?")
else:
  print(chr(list1[list2.index(max(list2))]))
