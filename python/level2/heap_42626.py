# https://programmers.co.kr/learn/courses/30/lessons/42626?language=python3

import heapq

def solution(scoville, K):
    frame = []
    # 이 과정에서 frame이 힙구조가 되는 것
    for i in scoville:
        heapq.heappush(frame, i)

    solution = 0
    while frame[0] < K:
        try:
            heapq.heappush(frame, heapq.heappop(frame) + (heapq.heappop(frame) * 2))
            solution += 1
        except IndexError:
            return -1
    return solution

scoville = [1, 2, 3, 9, 10, 12]
K = 7
print(solution(scoville, K))