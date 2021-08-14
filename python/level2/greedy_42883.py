# https://programmers.co.kr/learn/courses/30/lessons/42883

def solution(number, k):
    stack = [number[0]]
    for num in number[1:]: # 차례 차례 집어 넣어보면서 아랫 줄에서 뺄걸 정해주는거
        # 1) stack이 비어있지않고
        # 2) stack[-1] < num <- 집어 넣을게 더 크다면 이전거 뺴주고 넣어준다는 뜻 <- 이렇게 해야지만 큰수가 만들어짐
        # 3) k > 0 아직 뺴줄 숫자가 남아있다는 뜻
        while len(stack) > 0 and stack[-1] < num and k > 0:
            k -= 1
            stack.pop()
        stack.append(num)
    if k != 0: # 위 로직에서 아직 숫자를 다 빼주지 못하면 가장 뒤에있는 못뺴준만큼 가장 뒷숫자를 빼주면됨
        stack = stack[:-k]
    return ''.join(stack)

# ## 시간 초과된 풀이
# from itertools import *
# def solution(number, k):
#     idx_ls = [i for i in range(len(number))]
#     idx_cases = list(combinations(idx_ls, len(number)-k))
#     container = []
#     for i in idx_cases:
#         temp = []
#         for j in list(i):
#             temp.append(number[j])
#         container.append(''.join(temp))
#     return max(container)

number = "1924"
k = 2
print(solution(number, k))