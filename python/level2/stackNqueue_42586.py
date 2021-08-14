# https://programmers.co.kr/learn/courses/30/lessons/42586

def solution(progresses, speeds):
    answer = []
    time = 0
    count = 0
    while len(progresses)> 0:
        # 작업이 완료됐을 경우
        if (progresses[0] + time*speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1 # 나가야할 작업 갯수 count
        # 작업이 완료되지 않았을경우
        else:
            if count > 0: # 여기 조건에 걸린다는건 릴리즈 할게 있다는 뜻
                answer.append(count)
                count = 0 # 릴리즈 시키고 다시 0으로 둠
            time += 1 # @@@time은 여기서만 카운트 되야한다는게 핵심, 작업완료된거있을땐 시간 안흐르고 카운트만 해주고 그외의 경우에만 시간올라감@@@
    answer.append(count) # 마지막에 작업완료된것들 여기서 추가되야함
    return answer

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]
print(solution(progresses, speeds))