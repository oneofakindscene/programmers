// https://programmers.co.kr/learn/courses/30/lessons/42583
package solution.level2;

import java.util.LinkedList;
import java.util.Queue;

public class stackNqueue_42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // answer : 트럭들이 다리 건너느라 걸린 소요시간, sum : 다리에 올라간 트럭무게, truck_idx : truck_weights에서 idx(0번~length-1번까지있음)
        int total_time = 0, weight_sum = 0, truck_idx = 0;

        Queue<Integer> bridge_que = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge_que.offer(0); // 최초에 트럭이 안올라와있으니 0으로 채운다
        }

        while (!bridge_que.isEmpty()) { //bridge_que가 비었다는건 모든 트럭이 다 건넜다는 것을 뜻함
            int popped = bridge_que.poll(); // 1초 지나서 한칸씩 전진해야하니깐 제일 앞에 있는거 하나 뺴줘야함, poll() 해준건 다리 다 지나간거
            weight_sum -= popped; // 다리 다 지나간 것 만큼 무게 뺴줘야함
            if (truck_idx < truck_weights.length) { // truck_idx는 truck_weights의 index를 벗어날 수 없다
                if (weight_sum + truck_weights[truck_idx] <= weight) { // 최대 무게 이하여야함
                    bridge_que.offer(truck_weights[truck_idx]); // 트럭이 다리에 진출 line 18에서 하나 뺴줬으니깐 하나 넣어줘야함
                    weight_sum += truck_weights[truck_idx]; // 다리에 올라와있는 트럭 무게 추가
                    truck_idx++; // 다음에 올릴 truck의 idx
                } else { // else는 무게때문에 트럭을 더 추가할 수 없을때는 0을 채워줌 진입
                    bridge_que.offer(0);
                }
            }
            total_time++; // 1초 지날때마다 1씩 올라감
        }
        return total_time;
    }
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int answer = solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }

}
