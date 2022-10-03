#짝수번째 그룹은 분모가 n으로 시작하고
#홀수번째 그룹은 분자가 n으로 시작한다
#입력받은 num을 group으로 순차적으로 뺐을때
#0 이하가 되면 그때 group안에 num번쨰 분수 존재
#n번째 그룹은 n으로 시작한다.
#분자 + 분모는 group + 1

# 순서
# 1. num을 group으로 순차적으로 빼며 
#     몇번째 그룹 안에 속하는지 구한다.
# 2. 해당 group을 구하게 되면 
#     그 그룹이 짝수인지 홀수인지 구한다.
# 3. num의 숫자에서 group수열만큼 빼고
#     남은 수를 n으로 지정?
# 그룹이 짝수일때 num=8(그룹=4)
# 분자  : 2 = num-(그룹-1)수열
# 분모n : 3 = (그룹+1)-(num-(그룹-1)수열)
# 그룹이 홀수일때 num=12(그룹 = 5)
# 분자n : 4 = (그룹+1)-(num-(그룹-1)수열)
# 분모  : 2 = num-(그룹-1)수열
def sum(n):
    res = 0
    for i in range(1, n+1):
        res = res + i
    return res

num = int(input())
savenum = num
group = 1#n번쨰 그룹에 있는 원소수는 n개이다
cnt = 1
while True:
    if num - group <= 0:
        break
    num = num - group
    group = group + 1
####################
if group % 2 == 0:
    u = (savenum - sum(group -1))
    d = (group + 1) - (savenum - sum(group -1))
else:
    u = (group + 1) - (savenum - sum(group -1))
    d = (savenum - sum(group -1))
print(str(u) + "/" + str(d))