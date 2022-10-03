get = list(input())
i = 0
start = 0
while i < len(get):
    if get[i] =="<":
        while get[i] != ">":
            i += 1
        i+=1
    elif get[i].isalnum():
        start = i
        while i < len(get) and get[i].isalnum():
            i += 1
        tmp = get[start:i]
        tmp.reverse()
        get[start:i] = tmp        
    else:
        i+=1

        
output = "".join(get)
print(output)