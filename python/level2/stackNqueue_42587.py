# https://programmers.co.kr/learn/courses/30/lessons/42587

def solution(priorities, location): # location 값은 0부터 시작함 => idx값과 유사하다는 뜻
    queue =  [(i,p) for i,p in enumerate(priorities)]
    answer = 0
    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue): # 제일 앞에거(cur) 우선순위랑 비교했을때, 우선순위가 높은게(숫자 큼) 있다면 맨뒤로 보냄
            queue.append(cur) # 맨뒤로 보내는 행위
        else:
            answer += 1
            if cur[0] == location: #찾고있는 인쇄물
                return answer

priorities = [2, 1, 3, 2]
location = 2
print(solution(priorities, location)) # 1이 나와야 정답

## 예전에 혼자 풀었던 풀이
#     idxList = list(range(0, len(priorities)))
#     cnt = 0
#     a = True
#     while a:
#         standard = priorities[0]
#         # 1)인쇄할 차례가 된 경우
#         if standard == max(priorities):
#             del priorities[0]
#             del idxList[0]
#             cnt += 1
#             if location == 0:
#                 a = False
#                 return cnt
#             else:
#                 location -= 1
#         # 2)인쇄할 차례가 안된 경우
#         else:
#             if location == 0:
#                 location = len(priorities) - 1
#             else :
#                 location -= 1
#             priorities.append(priorities.pop(0))
#             idxList.append(idxList.pop(0))