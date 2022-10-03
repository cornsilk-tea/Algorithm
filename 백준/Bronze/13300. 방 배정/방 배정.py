# N = 수학여행에 참가하는 학생 수를 나타내는 정수
# K = 한방에 배정할 수 있는 최대 인원 수
# 성별 S는 0, 1중 하나로서 여학생인 경우에 0, 남학생인 경우에 1로 나타낸다. 
# Y = 학년
# n = 16
# k = 2
n,k = map(int, input().split())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))
# arr = [[1, 1], [0, 1], [1, 1], [0, 2], [1, 2], [0, 2], [0, 3], [1, 3], [1, 4], [1, 3], [1, 3], [0, 6], [1, 5], [0, 5], [1, 5], [1, 6]]
arr.sort()
# print(arr)
# for i in range(len(arr)-1): # 현재위치와 +1위치를 비교해서 있다면 넘김
i = 0
# 일단 여자리스트와 남자리스트를 분리하기
temp = 0 # 남자 리스트 시작하는 인덱스
for i in arr:
    if i[0] ==1:
        temp = arr.index(i)
        break
# print(arr[:temp])
# print(arr[temp:])

def calcroom(people):
    if len(people) == 0:
        return 0
    else:
        sex = people[0][0]
        answer = 0
        for i in range(1,7):
            # [[0, 1], [0, 2], [0, 2], [0, 3], [0, 5], [0, 6]]
            cnt = people.count([sex,i])
            # print("성별은 {0}, 학년은 {1}cnt = {2}".format(sex,i,cnt))
            if cnt%k != 0:
                answer += cnt// k+1
            else:
                answer += cnt//k
    return answer
            


answer = calcroom(arr[:temp])
answer += calcroom(arr[temp:])
print(answer)








