main = []
calling = []
for i in range(5):
    main.append(list(map(int,input().split())))
for i in range(5):
    for j in list(map(int,input().split())):
        calling.append(j)
# print(calling)
"""
    main                calling
11 12  2 24 10        5 10  7 16  2
16  1 13  3 25        4 22  8 17 13
 6 20  5 21 17        3 18  1  6 25
19  4  8 14  9       12 19 23 14 21
22 15  7 23 18       11 24  9 20 15
"""
# main = [[11, 12, 2, 24, 10], [16, 1, 13, 3, 25], [6, 20, 5, 21, 17], [19, 4, 8, 14, 9], [22, 15, 7, 23, 18]]
# calling = [5, 10, 7, 16, 2, 4, 22, 8, 17, 13, 3, 18, 1, 6, 25, 12, 19, 23, 14, 21, 11, 24, 9, 20, 15]
def check():
    count = 0
    # 가로줄이 빙고인지 훑어보는 함수
    for arr in main:
        if arr.count(0)==5:
            count += 1
        if count == 3:
            return True
    #왼쪽에서 오른쪽으로 내려가는 대각선
    if main[0][0]+main[1][1]+main[2][2]+main[3][3]+main[4][4]==0:
        count += 1
    if count == 3:
        return True
    #오른쪽에서 왼쪽으로 내려가는 대각선
    if main[0][4]+main[1][3]+main[2][2]+main[3][1]+main[4][0]==0:
        count += 1
    if count == 3:
        return True
    #세로줄이 빙고일때 00 10 20 30 40 01 11 21 31 41
    for j in range(len(main)):#앞자리
        temp = 0
        tempcount=0
        for i in range(len(main)):#뒷자리
            # print(j)
            # print("main[{0}][{1}]=".format(i,j) + str(main[i][j]))
            # display()
            # print()
            if main[i][j] == 0:
                # print("main[{0}][{1}]=0".format(i,j))
                tempcount += 1
                if tempcount == 5:
                    count += 1
                    if count ==3:
                        return True
                continue
            else:
                temp = "a"
    if temp != 0:
        return False
    else:
        count += 1
    if count == 3:
        return True
def display():
    for i in main:
        print(i)

# count = 3
# main[2][2] # 정 가운데
for i in range(25):
    #사회자의 콜링 내 빙고판에서 찾기
    for j in main:
        if calling[i] in j:
            j[j.index(calling[i])] = 0
            # display()
            # print("없어진 수는" + str(calling[i]))
            #빙고인지 판단하기
            result = check()
            # print(result)
            if result:
                print(i+1)
                break
    if result:
        break
# print(main)
    


