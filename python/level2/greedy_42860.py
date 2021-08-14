# https://programmers.co.kr/learn/courses/30/lessons/42860
## 풀이 : https://bellog.tistory.com/152

# (팁1) 첫 번째로는 상, 하 방향의 관점이다. A부터 오름차순으로 알파벳을 찾는 것이 빠른지, 아니면 Z부터 내림차순으로 찾는 것이 빠른지 비교
# (팁2) 두 번째로 좌, 우 방향의 관점이다. 문제에서 A로만 이루어진 상태에서 문자열을 찾는 것이기 때문에
        # 마지막에 남은 문자열들이 연속된 A로 이루어져있다면 이동하지 않고 문자열을 완성시킬 수 있기때문.
def solution(name):
    answer = 0
    min_move = len(name) - 1 # 첫글자에서 끝끌짜로 "->" 이방향으로만 움직일떄 필요한 조이스틱 사용횟수
    next = 0

    # (팁1)에 해당하는 내용
    for i, char in enumerate(name):
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1) #일단 Z로 가려면 한번 움직여야하니 +1 해주는거

        # (팁2)에 해당하는 내용
        next = i + 1
        # while문을 통해서 끝까지 갔는지 & 다음글자가 A인지 확인해서 연속해서 A가 있는 경우 계속해서 옆칸을 보게함
            # nex < len(name) : index 범위 안넘어가게함(끝까지 갔는지 확인)
            # name[next]=='A' : 옆글자가 A인지 확인
        while next < len(name) and name[next] == 'A':
            next += 1
        min_move = min(min_move, i + i + len(name) - next)
    answer += min_move
    return answer

name = "JEROEN"
print(solution(name))

## ord()를 통해서 알파벳 순서에 따른 숫자값을 알 수 있음
# print(ord('A'))
# print(ord('B'))
# print(ord('Z'))