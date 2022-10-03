L = int(input())
people = int(input())
cake = ["a" for i in range(L)]
arr1=[]
arr2=[]
# for i in range(people):
#     arr.append(list(map(int, input().split())))
for i in range(people):
    start, end = map(int, input().split())
    arr1.append(end)
    arr2.append(end-start)
    start -=1
    end -=1
    for j in range(end-start+1):
        if cake[start] =="a":
            cake[start] = i+1
        start +=1
            

tmp = 0
firstanswer = 1
for i in range(people):
    if tmp < arr2[i]:
        tmp = arr2[i]
        firstanswer = i+1
print(firstanswer)
tmp = 0
secoundanswer = 1
for i in range(people):
    if tmp < cake.count(i+1):
        tmp = cake.count(i+1)
        secoundanswer = i+1
print(secoundanswer)