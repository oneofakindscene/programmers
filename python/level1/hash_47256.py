# https://programmers.co.kr/learn/courses/30/lessons/42576?language=python3
# idea 빈 딕셔너리에 hash 값 key, 사람이름을 value로 저장해주고
# 특정 변수에다가 hash값들을 더하고 뺴주다보면 결국엔 하나의 hash 값만 나오게되서
# 그 남은 딕셔너리에서 hash값으로 value 가져오면 그게 정답
def solution(participant, completion):
    answer = ''
    temp = 0
    dic = dict()
    for i in participant:
        dic[hash(i)] = i
        temp += hash(i)
    for j in completion:
        temp -= hash(j)
    return dic[temp]

participant = ["marina", "josipa", "nikola", "vinko", "filipa"]
completion = ["josipa", "filipa", "marina", "nikola"]
print(solution(participant, completion))

# collections를 활용한 문제풀이
# def solution(participant, completion):
#     import collections
#     answer = collections.Counter(participant) - collections.Counter(completion)
#     return list(answer.keys())[0]