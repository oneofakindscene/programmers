// https://programmers.co.kr/learn/courses/30/lessons/42626
package solution.level2;

import java.util.PriorityQueue;

public class heap_42626 {
    public static int solution(int[] scoville, int K){
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i=0; i < scoville.length; i++){
            heap.offer(scoville[i]); // heap에 scoville을 집어 넣음

            // .add vs .offer 차이는 둘다 큐에 자료 넣을때 쓰는데
            // 이미 큐가 꽉 찬 경우 add는 예외를 발생
            // offer는 추가 실패를 의미하는 false를 return
        }

        while(heap.peek() < K){ // heap.peek() 맨위의 객체를 반환 poll() 과 달리 객체를 꺼내지 않음
            if(heap.size() < 2) {
                return -1;
            }
            int f1 = heap.poll();
            int f2 = heap.poll();

            int newFood = f1 + (f2 * 2);
            heap.offer(newFood);
            answer++;
        }
        return answer;
    }
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10, 12}; // 정답은 2
        int K = 7;
        Integer answer = solution(scoville, K);
        System.out.println(answer);
    }
}
