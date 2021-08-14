// https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
// 처음 가격이 떨어진 시점만 체크한다고 생각하면 됨 <- 이부분 문제 이해자체가 어려웠음
package solution.level2;
import java.util.Arrays;
import java.util.Stack;

public class stackNqueue_42584 {
        public static int[] solution(int[] prices) {
            // idx를 활용해서 몇초동안 가격이 안떨어졌는지 계산하는게 핵심
            Stack<Integer> idx_container = new Stack<>();
            int i = 0;
            int[] answer = new int[prices.length];
            idx_container.push(i);

            for(i=1;i<prices.length;i++){
                // while문으로
                // 1) 바로 다음 초에서 가격이 떨어진 경우는 while문에 진입 못함
                // 2) 바로 다음초에 가격이 떨어진 경우가 최초 발견되면 그 idx 기준으로 이전의 idx까지 검사하면서 while문 진입시킴
                while(!idx_container.empty() && prices[idx_container.peek()] > prices[i]){
                    int current_idx = idx_container.pop();
                    answer[current_idx] = i -current_idx; // 몇초동안 가격이 안떨어졌는지 산출(보통 i가 current_idx보다 1크기때문에 값이 1이됨
                }
                idx_container.push(i);
            }
            int prices_length = i;
            // 여기까지 오는 idx들은 끝까지 안떨어진 경우라서 prices_length기준으로 가격이 떨어지지 않은 시간 계산함
            while(!idx_container.empty()){
                int current_idx = idx_container.pop();
                answer[current_idx] = prices_length - current_idx - 1; // length값이니깐 idx값 빼주고 -1 해준다
            }
            return answer;
        }
        public static void main(String[] args){
            int[] prices = {1,2,3,0,1}; // 정답은 [3, 2, 1, 1, 0] 이 나와야함
//            int[] prices = {1,2,3,2,3};
            int[] answer = solution(prices);
            System.out.println(Arrays.toString(answer));
        }
}
