s = input()
a = ''
for i in range(97,123):
    if chr(i) in s:
      a = a + str(s.index(chr(i))) + " "
    else:
      a += "-1 "
print(a)