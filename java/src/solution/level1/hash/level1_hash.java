// https://programmers.co.kr/learn/courses/30/lessons/42576
package solution.level1.hash;
import java.util.Arrays;

import java.util.Arrays;
class Solution_42576 {
    // 아래와 같이 static method로 만들어주면 인스턴스 만들지 않고 클래스에서 바로 실행가능
        // 당연한 얘기지만 static이 안 붙으면 인스턴스 만들어 줘야함
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for (i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        // line 11을 없애고 line 12에서 int i = 0 이라고하면 => for문에서만 i가 존재해서
            // 아래 코드에서 에러가 발생한다.
        return participant[i];
    }
}
public class level1_hash {
        public static void main(String[] args) {
            // TC 설정
            String[] participant3 = { "mislav", "stanko", "mislav", "ana" };
            String[] completion3 = { "stanko", "ana", "mislav" };

            // (1안) line8에 static 붙었을때
            String answer = Solution_42576.solution(participant3, completion3);
            System.out.println(answer);

            // (2안) line8에 static 안붙었을
//            Solution temp = new Solution();
//            String answer = temp.solution(participant3, completion3);
//            System.out.println(answer);
        }
}
