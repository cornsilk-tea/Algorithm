n = int(input())
seat = list(input())
# n = 9
# seat="SLLLLSSLL"
answer = 0
temp = ["*"]
i=0
while i < len(seat):
    if seat[i] == "S":
        temp.append("S")
        temp.append("*")
        i += 1
    else:
        temp.append("L")
        temp.append("L")
        temp.append("*")
        i +=2
# print(temp)
if n >= temp.count("*"):
    print(str(temp.count("*")))
else:
    print(n)