# https://programmers.co.kr/learn/courses/30/lessons/42747

# sort를 하면 citations 길이 - idx가 h번 이상 인용된 논문의 갯수라는 점이 핵심
def solution(citations):
    citations.sort()
    l = len(citations)
    for i in range(l):
        if citations[i] >= l - i:
            # 논문이 인용된 횟수(h번 이상) >= 인용된 논문의 개수(h개 == h번)
            return l - i
    return 0

citations = [3, 0, 6, 1, 5]
print(solution(citations))