arr = []
for i in range(10):
    arr.append(int(input()))
# arr = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
# arr = [1,2,3,5,8,13,21,34,55,89]
# arr = [40 for _ in range(10)]
# arr = [1,2,3,4,5,6,7,8,9,10]
temp = []
res = 0
scores = 0
for i in range(10):
    score = arr[i]
    pre_scores = scores
    scores += score
    if scores >= 100:
        if abs(100-scores) > abs(100-pre_scores):
            scores = pre_scores
        break
print(scores)
