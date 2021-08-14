# https://programmers.co.kr/learn/courses/30/lessons/42748
def solution(array, commands):
    container = []
    for i in commands:
        temp = array[i[0]-1:i[1]]
        temp.sort()
        container.append(temp[i[2]-1])
    return container

array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
print(solution(array, commands))