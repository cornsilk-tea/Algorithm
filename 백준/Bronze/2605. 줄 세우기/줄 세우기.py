people = int(input())
order = list(map(int,input().split()))

# people = 5
# order = [0,1,1,3,2]
student = []
answer = []
for i in range(people):
    student.append(i)
    answer.append("a")
# print(student)
for i in range(len(student)):
    if order[i]==0:
        answer[i] = student[i]+1
    else:
        answer.insert(i-order[i], student[i]+1)
answer = answer[:people]
# print(answer)
a = ""
for i in answer:
    a+=str(i)+" "
print(a)