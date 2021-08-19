// https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
// 처음 가격이 떨어진 시점만 체크한다고 생각하면 됨 <- 이부분 문제 이해자체가 어려웠음
package solution.level2;
import java.util.Arrays;
import java.util.Stack;
// (중요 point)
    // 기준idx - 가격떨어진idx = 얼마만에 떨어졌는지 나옴
public class stackNqueue_42584 {
    public static int[] solution(int[] prices) {
        // idx를 활용해서 몇초동안 가격이 안떨어졌는지 계산하는게 핵심
        Stack<Integer> idx_container = new Stack<>();
        int i = 0;
        int[] answer = new int[prices.length];
        idx_container.push(i);

        for(i=1;i<prices.length;i++){
            // while문으로
                // 1) 가격이 떨어진 경우는 while문에 진입
                // 2) (중요!!!) 가격이 떨어진 경우가 발생하면 while문 내에서 pop()을 반복하면서
               //     여러 기준이 되는 가격들 vs 가격이 떨어진 지점 을 비교해서 몇초만에 떨어짔는지 계산해서 answer array에 적어줌
            while(!idx_container.empty() && prices[idx_container.peek()] > prices[i]){
                int current_idx = idx_container.pop();
                answer[current_idx] = i - current_idx; // 몇초동안 가격이 안떨어졌는지 산출(보통 i가 current_idx보다 1크기때문에 값이 1이됨
            }
            idx_container.push(i);
        }
        int prices_length = i;
        // 여기까지 오는 idx들은 끝까지 안떨어진 경우라서 prices_length기준으로 가격이 떨어지지 않은 시간 계산함
        while(!idx_container.empty()){
            int current_idx = idx_container.pop();
            // 마지막 idx - 현재 idx 해줘야 하기 떄문에
            // 즉, idx끼리 비교해야하기때문에 length값에서 -1 해서 current_idx 값을 뺴준다.
            answer[current_idx] = (prices_length - 1) - current_idx ;
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
