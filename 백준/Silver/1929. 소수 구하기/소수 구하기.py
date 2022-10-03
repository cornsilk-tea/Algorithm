#소수리스트 만들어주기
prime_ox = [True for _ in range(1000000)]

for i in range(2, int(1000000 ** 0.5)):
    if prime_ox[i] == True:
        for j in range(i+i, 1000000, i):
            prime_ox[j] = False 

prime_list = [i for i, j in enumerate(prime_ox) if j == True and i >=2 ]


#소수 출력하기
M, N = map(int, input().split())

for i in prime_list:
    if i < M :
        continue
    elif N >= i >= M:
        print(i)
    else:
        break