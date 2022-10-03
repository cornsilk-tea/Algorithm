# 한번 나온 글자가 반복해서 나오거나
# 모든 글자가 다른 단어라면 상관없지만
# 반복되는 글자 중간에 다른 글자가 들어가면 안됨
# 한번 나온 글자가 또 나오면 안됨?
# find함수로 특정 값의 인댁스 위치를 앞 뒤 방향으로 파악
# 그 후 그 값을 뺀 중간 문자열만 새로운 리스트에 저장
# 만약 그 값을 제외한 다른 값이 문자열 중간에 있으면
# 안됨
cnt = 0
for i in range(int(input())):
    dict1={}
    prev = ''
    a = input()
    for i in a:
#         print(dict1)
#         print(i)
        if i == prev:
#             print('if작동')
            continue
        elif len(a) == 1:
            check = True
#             print('elif1작동')
        elif i in dict1:
#             print('elif2작동')
            check = False
            break
        else: 
            dict1[i]=1
            check = True
        prev = i
    if check == True: cnt += 1
#     print(dict1)
#     print(check)
print(cnt)