# cost = 고정비용 = 가변비용*n
# 고정비용, 가변비용, 노트북가격
# A            B        c
# 총 수입비용 = (C*n)
# 총 비용 = (A+B*n)
A, B, C = map(int,input().split())
n = 0
if C <= B: n = -1
else: n = A//(C-B) +1
print(n)