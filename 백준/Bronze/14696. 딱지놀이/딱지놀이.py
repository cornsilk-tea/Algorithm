"""
A가 승자라면 A, 
B가 승자라면 B, 
무승부라면 D이다.
별, 동그라미, 네모, 세모를 각각 숫자 4, 3, 2, 1
▲■●★
 1 2 3 4
만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.
"""
def fight(a,b):
    a = a[1:]
    b = b[1:]
    if a.count(4) != b.count(4):
        if a.count(4) < b.count(4):
            return "B"
        else:
            return "A"
    elif a.count(3) != b.count(3):
        if a.count(3) < b.count(3):
            return "B"
        else:
            return "A"
    elif a.count(2) != b.count(2):
        if a.count(2) < b.count(2):
            return "B"
        else:
            return "A" 
    elif a.count(1) != b.count(1):
        if a.count(1) < b.count(1):
            return "B"
        else:
            return "A"
    else:
        return "D"
        

# n = 총 라운드 수를 나타내는 자연수 n
# 이 다음줄부턴 두 줄씩 묶어서 한 라운드를 이루는데
# 첫줄은 어린이 A가 내는 딱지에 나온 그림의 총 개수 a가 주어진다.
# 따라나오는 숫자는 총 a개로 각각 4,3,2,1중 하나의 값이다.

n = int(input())
arr=[]
for i in range(n*2):
    arr.append(list(map(int,input().split())))
# print(arr)
# n = 5
# arr = [[1, 4], [4, 3, 3, 2, 1], [5, 2, 4, 3, 2, 1], [4, 4, 3, 3, 1], [4, 3, 2, 1, 1], [4, 2, 3, 2, 1], [4, 4, 3, 2, 1], [3, 4, 3, 2], [5, 4, 4, 2, 3, 1], [5, 4, 2, 4, 1, 3]]
a = []
b = []
for i in range(0,len(arr)-1,2):
    # print(arr[i])
    # print(arr[i+1])
    print(fight(arr[i], arr[i+1]))
