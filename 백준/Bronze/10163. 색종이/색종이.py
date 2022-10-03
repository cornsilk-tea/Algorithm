# n = 색종이의 장수
n = int(input())
temp = []
for i in range(n):
    temp.append(list(map(int,input().split())))
# print(paper)
"""
예제입력 1
n = 2
temp = [[0, 0, 10, 10], [2, 2, 6, 6]]
"""
"""
예제입력 2
n = 3
temp = [[0, 2, 10, 10], [7, 9, 8, 4], [8, 4, 10, 6]]
"""
paper = []
for i in temp:
    paper.append([i[0],i[1],i[0]+i[2],i[1]+i[3]])
# print(paper)
tempx0 = 0
tempy0 = 0
tempx2 = 0
tempy2 = 0
for i in paper:
    for j in range(0,len(i)-1,2):
        # if j == 0: # [0, 0, 10, 10]에서 처음 두개인 경우
        #     if tempx0 < 
        if j != 0: # [0, 0, 10, 10]에서 뒤에 두개인 경우
            if tempx2 < i[j]:
                tempx2 = i[j]
            if tempy2 < i[j+1]:
                tempy2 = i[j]
# print(tempx2)
# print(tempy2)
main = [[0 for _ in range(101)] for _ in range(101)]

def display():
    for i in main:
        print(i)
    print()

def putpaper(paper, papernum): # [0, 0, 10, 10]
    size = (paper[2]-paper[0]) * (paper[3]-paper[1])
    n = 0
    while n < size:
        for i in range(paper[0], paper[2], 1):
            for j in range(paper[1], paper[3], 1):
                main[i][j]= papernum
                n += 1




for i in range(0,len(paper)):
    putpaper(paper[i],i+1)
# display()
for i in range(1,n+1):
    answer = 0
    for element in main:
        answer += element.count(i)
    print(answer)