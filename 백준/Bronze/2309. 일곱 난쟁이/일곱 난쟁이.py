arr = []
for i in range(9):
    arr.append(int(input()))
# arr = [20, 7, 23, 19, 10, 15, 25, 8, 13]
x = 0
y = 0
total = 0
for i in arr:
    total += i
# print(arr)
for i in range(len(arr)-1):
    for j in range(len(arr)):
        if arr[i]+arr[j] == (total-100) and arr[i] != arr[j]:
            # print("i =" + str(arr[i]) + " j = "+str(arr[j]))
            x = arr[i]
            y = arr[j]
arr.remove(x)
arr.remove(y)
arr.sort()
# print(arr)
for i in arr:
    print(str(i))
