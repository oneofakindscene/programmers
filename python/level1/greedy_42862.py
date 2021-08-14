# https://programmers.co.kr/learn/courses/30/lessons/42862
# 핵심포인트 양쪽다 빌릴 수 있을때는 어떻게 해야할까??
    # : 1번 학생부터 ~ n번까지 살펴볼거니깐 즉, 맨 앞에있는 학생부터 왼쪽/오른쪽 살펴보고 빌려주기 때문에
    # 비효율적으로 분배되어 빌릴수있는애가 못빌리게 되는 경우는 없음
    # 조건에 왼쪽/오른쪽 사람에게만 받을 수 있다고 명시되어있음
def solution(n, lost, reserve):
    # 1) pureLost : lost 명단에는 있고 reserve 명단에는 없는 경우
    pure_lost = set(lost) - set(reserve)
    # 2) pureRes : reserve 명단에는 있고 lost 명단에는 없는 경우
    pure_res = set(reserve) - set(lost)
    pure_cnt = n - len(pure_lost)
    # 3) pureRes 기준으로 왼쪽 오른쪽 살펴보고 왼쪽 사람이 없으면 왼쪽 빌려준다
    for i in pure_res:
        if i-1 in pure_lost:
            pure_lost.remove(i-1)
            pure_cnt += 1
        elif i+1 in pure_lost:
            pure_lost.remove(i+1)
            pure_cnt += 1
    return pure_cnt

n = 5
lost = [2, 4]
reserve = [1, 3, 5]
print(solution(n, lost, reserve))