a = []
for i in range(15):
    line = []              # 안쪽 리스트로 사용할 빈 리스트 생성
    for j in range(14):
        line.append(0)     # 안쪽 리스트에 0 추가
    a.append(line) 
for i in range(15):
    a[i][0] = 1
for i in range(14):
    a[0][i]=i+1
for i in range(1,15):
    for j in range(1,14):
        a[i][j] = a[i][j-1] + a[i-1][j]

for i in range(int(input())):
    k = int(input())
    n = int(input())
    print(a[k][n-1])