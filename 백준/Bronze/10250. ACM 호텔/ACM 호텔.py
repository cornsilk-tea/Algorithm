T = int(input())
for i in range(T):
    H, W, N = list(map(int,input().split()))
    if N%H == 0:
        floor = H
        num = N//H
    else:
        floor = N%H
        num = (N//H)+1
#     print(floor)
#     print(num)
    answer=floor*pow(10,2)+num
    print(answer)