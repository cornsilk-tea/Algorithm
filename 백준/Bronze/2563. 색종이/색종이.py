paper = [([0 for _ in range(100)]) for _ in range(100)]
# for i in paper:
    # print(i)
# n = 3
# arr = [[3,7],[5,2],[15,7]]
# print(arr)
n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))
    
def putpaper(arr):
    x = arr[0]
    y = arr[1]
    for i in range(x,x+10):
        for j in range(y,y+10):
            paper[i][j] = 1
for k in arr:
    putpaper(k)

# for i in paper:
#     print(i)
x = 0
y = 0
for i in arr:
    if x < i[0]:
        x = i[0]
    if y < i[1]:
        y = i[1]
x +=10
y +=10
# print("x="+str(x)+"y="+str(y))

temp = []
for i in paper:
    temp.append(i[0:y+1])
cnt = 0
for i in temp:
    if i.count(0) == len(temp[0]):
        cnt += 1
    else:
        cnt -= 1
        break
# print(cnt)
temp = temp[cnt:x+1]

# for i in temp:
#     print("i="+str(i))
for i in range(len(temp)):
    for j in range(len(temp[i])):
        pass
# for i in temp:
#     print(str(i))
result = 0
for i in temp:
    result += i.count(1)
print(result)