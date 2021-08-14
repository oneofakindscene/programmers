# https://programmers.co.kr/learn/courses/30/lessons/42584

def solution(prices):
    answer = [0] * len(prices)
    for i in range(len(prices)-1):
        for j in range(i+1, len(prices)):
            if prices[i] > prices[j]:
                answer[i] = j-i
                break
            if j == len(prices) - 1 and answer[i] == 0:
                answer[i] = j - i
    return answer

## 대소비교를 하지 않고 아래와 같이 해결할수도 있따
'''
def solution(prices):
    answer = [0] * len(prices)
    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            if prices[i] <= prices[j]:
                answer[i] += 1
            else:
                answer[i] += 1
                break
    return answer
'''

prices = [1, 2, 3, 2, 3]
print(solution(prices))