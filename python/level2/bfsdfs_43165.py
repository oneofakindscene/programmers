# https://programmers.co.kr/learn/courses/30/lessons/43165
import itertools
# 모든 경우의 수를 만들어서 조합하여 계산한후 타겟과 같은숫자가 만들어지는 조합이 몇개인지 count한다
def solution(numbers, target):
    # 1) 부호들의 조합 만들기
    answer = 0
    case = list(itertools.product(["-", "+"], repeat=len(numbers)))
    # 2) 부호들과 숫자들을 결합해주기
    for i in case:
        sumNum = 0
        for z in zip(i, map(str,numbers)):
            sumNum += int(z[0] + z[1])
        if sumNum == target:
            answer += 1
    return answer

numbers = [1, 1, 1, 1, 1]
target = 3
print(solution(numbers, target))

## (시간초과된 풀이)
# import itertools
# def solution(numbers, target):
#     container = []
#     answer = 0
#     plusMinus_list = list(itertools.product(['+','-'], repeat=len(numbers)))
#     for i in plusMinus_list:
#         ls = list(i)
#         for j in range(len(numbers)):
#             container.append(int(ls[j] + str(numbers[j])))
#         if sum(container) == target:
#             answer+=1
#         container = []
#     return answer

