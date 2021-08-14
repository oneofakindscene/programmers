# https://programmers.co.kr/learn/courses/30/lessons/42839

from itertools import *
def is_prime(number):
    if number in (0, 1):
        return False
    elif number == 2:
        return True
    elif number % 2 == 0:
        return False
    for i in range(3, int(number**0.5+1)):
        if number % i == 0:
            return False
    else:
        return True

def solution(numbers):
    all_cases = []
    cnt = 0
    for i in range(len(numbers)):
        candidate = list(permutations(numbers, i+1))
        for j in candidate:
            all_cases.append(''.join(list(j)))
    all_cases = set(list(map(int, all_cases)))
    # print(all_cases)
    for i in all_cases:
        # print(i)
        if is_prime(int(i)):
            cnt+=1
    return cnt


numbers = "011"
print(solution(numbers))
