# https://programmers.co.kr/learn/courses/30/lessons/42885

# (중요조건) 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
# (아이디어)
    # 2명밖에 못태우니 가벼운애 + 무거운애 조합으로 태울 수 있으면 태운다
    # 가벼운애 + 무거운애 못태우면 => 무거운애만 태워서 보낸다 => 즉 무거운애들만 태워서 보내다보면 가벼운애랑 같이 탈 수 있는 애들을 찾게되서 2명씩 태울 수 있음
from collections import deque

def solution(people, limit):
    boat_cnt = 0
    people.sort()
    q = deque(people)
    while q:
        if len(q) >= 2:
            if q[0] + q[-1] <= limit:
                q.pop()
                q.popleft()
                boat_cnt += 1
            elif q[0] + q[-1] > limit:
                q.pop()
                boat_cnt += 1
        else:
            if q[0] <= limit:
                q.pop()
                boat_cnt += 1
    return boat_cnt


