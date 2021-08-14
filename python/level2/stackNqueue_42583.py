from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque(0 for _ in range(bridge_length)) # bridge 길이만큼 덱(deque)을 만들어준다
    total_weight = 0
    step = 0
    truck_weights.reverse() # pop(0)을 안쓰려고 이렇게 한듯

    while truck_weights:
        total_weight -= bridge.popleft()
        if total_weight + truck_weights[-1] > weight:
            bridge.append(0)
        else:
            truck = truck_weights.pop()
            bridge.append(truck)
            total_weight += truck
        step += 1

    step += bridge_length

    return step

def solution(bridge_length, weight, truck_weights):
    bridge = deque(0 for _ in range(bridge_length))
    answer = 0
    total_weight = 0
    truck_weights.reverse()

    while truck_weights:
        total_weight-=bridge.popleft()
        if total_weight + truck_weights[-1] > weight:
            bridge.append(0)
        else:
            truck = truck_weights.pop()
            bridge.append(truck)
            total_weight += truck
        answer+=1
    answer += bridge_length
    return answer

bridge_length = 2
weight = 10
truck_weights = [7,4,5,6]
print(solution(bridge_length, weight, truck_weights)) # 8이 나와야 정답