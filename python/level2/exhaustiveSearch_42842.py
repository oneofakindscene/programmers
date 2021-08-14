# https://programmers.co.kr/learn/courses/30/lessons/42842

# 브라운 : 2x + 2y - 4
# 노랑 : (x-2)*(y-2)
# 전체 = x*y = 가로*세로 => 따라서 전체는 가로로 나누어진다고 볼 수 있음
def solution(brown, yellow):
    total = brown + yellow
    for width in range(total, 2, -1): # 가로
        if total % width == 0:
            height = total // width # 세로를 탐색하는거라서 굳이 나머지가 0인지는 따지지않고 몫만 가져와서 아래에서 따져봄
            if yellow == (width - 2) * (height - 2):
                return [width, height]

# 근의 공식으로 해결
# x : 가로, y : 세로
# x*y = brown + yellow
# (x-2)*(y-2) = yellow
# def solution(brown, yellow):
#     x = (brown + 4 +((brown+4) ** 2- 16*(brown+red)**0.5)/4)
#     y = (brown + red) // width
#     return [max(x, y), min(x, y)]

brown = 24
yellow = 24
print(solution(brown, yellow))