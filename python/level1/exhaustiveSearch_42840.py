# https://programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    person1 = [1,2,3,4,5]
    person2 = [2,1,2,3,2,4,2,5]
    person3 = [3,3,1,1,2,2,4,4,5,5]
    container = [0, 0, 0]
    for i in range(len(answers)):
        if person1[i%5] == answers[i]:
            container[0] += 1
        if person2[i%8] == answers[i]:
            container[1] += 1
        if person3[i%10] == answers[i]:
            container[2] += 1
    answer = []
    maxValue = max(container)
    for idx, value in enumerate(container):
        if maxValue == value:
            answer.append(idx+1)
    return answer

def solution(answers):
    person1 = [1,2,3,4,5]
    person2 = [2,1,2,3,2,4,2,5]
    person3 = [3,3,1,1,2,2,4,4,5,5]
    container = [0, 0, 0]
    answer = []
    for i in range(len(answers)):
        if answers[i] == person1[i % 5]:
            container[0] += 1
        if answers[i] == person2[i % 8]:
            container[1] += 1
        if answers[i] == person3[i % 10]:
            container[2] += 1
    maxValue = max(container)
    for idx, value in enumerate(container):
        if maxValue == value:
            answer.append(idx+1)
    return answer













answers = [1,3,2,4,2]
print(solution(answers))
