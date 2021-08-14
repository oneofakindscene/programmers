# https://programmers.co.kr/learn/courses/30/lessons/42746

# (참고 x*3하는 이유)
# 0~1000까지의 숫자 준다고했으니 1000을보고 x*3을 한거 10000이었으면 x*4로 줬을 것
# ['9', '88', '1000']이 주어지면 => x*3하면 => 999, 888888, 100010001000=> 이걸 문자열 상태에서 내림차순 정렬하면 999가 먼저나와서 큰수 조합하기 적합
# ['99', '991']이 주어지면 그냥 내림차순 정렬하면 => ['991', '99']가 나오는데 => x*3해줘서 ['991991991', '999999']비교하면 => ['99', '991'] 순으로 나옴
def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    return str(int(''.join(numbers)))

## 시간초과된 문제 풀이
# from itertools import permutations
# def solution(numbers):
#     all_cases = list(permutations(numbers, r=len(numbers)))
#     for idx, value in enumerate(all_cases):
#         value = map(str, value)
#         cur = ''.join(value)
#         if idx == 0:
#             max_value = cur
#         elif int(max_value) < int(cur):
#             max_value = cur
#     return max_value



numbers = [3, 30, 34, 5, 9]
print(solution(numbers))

# numbers = ['9', '991']
# numbers.sort(reverse=True)
# print(numbers)
