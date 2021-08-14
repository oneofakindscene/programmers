# https://programmers.co.kr/learn/courses/30/lessons/42577
# (TIP) 한 번호가 다른 번호의 접두사가 된다 => 가장 길이 짧은 것을 기준으로 판단하면 된다는 뜻
# 경우의 수를 고려해야함

from itertools import combinations
def solution(phoneBook):
    # 1) phoneBook에 있는 전화번호를 길이를 기준으로 정렬한다
    sort_by_len = sorted(phoneBook, key = len)
    for (a, b) in combinations(sort_by_len, 2):
        if a == b[:len(a)]:
            return False
    return True

phoneBook = ["119", "97674223", "1195524421"]
print(solution((phoneBook)))