# https://programmers.co.kr/learn/courses/30/lessons/42578

def solution(clothes):
    dic = dict()
    for i in range(len(clothes)):
        name = clothes[i][0]
        category = clothes[i][1]
        # 아래 과정에서 옷 종류별 몇가지 옷이있는지 dict에서 정리됨
        if clothes[i][1] in dic:
            dic[category].append(name)
        else:
            dic[category] = [name]
            dic[category].append('')
    temp_value = 1
    # 경우의 수 계산하는 곳
    for i in dic:
        temp_value *= len(dic[i])
    return temp_value-1
## @@ hash로 푸는 경우 @@
# def solution(clothes):
#     from collections import Counter as C
#     answer = 0
#     kindof = []
#     # 1) 옷의 category들을 가져오는 부분
#     for i in clothes:
#         kindof.append(i[1])
#     # 2) 옷의 category들이 각각 몇개씩있는지 가져오는 부분
#     hash = C(kindof)
#     # 3) 옷을 입는 경우의 수를 세는 부분
#     # (참고) +1을 하는 이유는 옷을 안입는 경우를 포함하기 위함
#     for j in list(hash.values()):
#         if answer == 0:
#             answer += j+1
#         else:
#             answer *= j+1
#     # 마지막에 -1을 하는 경우는 아무것도 안입는 경우는 빼주기 위함
#     return answer - 1
clothes = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
print(solution(clothes))

