word =input()
N = len(word)
tempR = 0
tempC = 0
answer = []
for R in range(1,N+1):
    for C in range(1,N+1):
        if R > C:
            continue
        else:
            if R*C == N:
                # print(str(R) + "*" + str(C) + "=" + str(N))
                if tempR < R:
                    tempR = R
                    tempC = C
# print(str(tempR) + "*" + str(tempC) + "=" + str(N))
R = tempR
C = tempC
array = [[0 for col in range(C)] for row in range(R)]
num = 0
for c in range(C):
    for r in range(R):
        array[r][c] = word[num]
        num+=1


# for i in range(len(array)):
#     print(array[i])
answer=""
for r in range(R):
    for c in range(C):
        answer += array[r][c]
print(answer)