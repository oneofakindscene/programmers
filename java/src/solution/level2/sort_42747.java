// https://programmers.co.kr/learn/courses/30/lessons/42747

package solution.level2;
import java.util.*;

public class sort_42747 {
    public static int solution(int[] citations) {
        int answer = 0; // {0, 0, 0, 0, 0}일떄는 이 값이 출력됨
        Arrays.sort(citations); // citations를 정렬했기 때문에 아래 for문의 logic으로 h-index 산출가능
        // 순서대로 정렬했기 때문에 h = citations.length - i 가 되야함

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // h구하는게 핵심

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] citations = {3, 0, 6, 1, 5};
        Integer answer = solution(citations);
        System.out.println(answer);
    }
}
