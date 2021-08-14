//https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
package solution.level2;
import java.util.Arrays;

// 규칙
// x : 가로, y: 세로
// brown 갯수 = 2x + 2y - 4  <- -4는 꼭지점 가로세로 2x, 2y로 갯수 구하면 겹치는 부분 @@@ 이 공식 구하는게 핵심@@@
    // 위 식에서 x = (brown갯수 + 4) / 2 - y ---> line 17
    // 위 식에서 y 값은 (brown + 4) / 2 보다는 무조건 작아야함을 알 수 있다 ---> line 16에 사용
// yellow 갯수 = (x-2) * (y-2)
// 카펫 세로길이 <= 가로길이 ---> 이부분을 응용해서 line 1
// height 최소값 = 3
public class exhaustiveSearch_42842 {
    public static int[] solution(int brown, int yellow) {
        int height = 0;
        int width = 0;
        for (height = 3; height < (int) (brown + 4) / 2; height++) {

            width = ((brown + 4) / 2) - height;
            if (width < height) { // 이조건에 걸리면 for문 반복하는 의미가 없음
                System.out.println("height greater than width. Impossible condition");
                break;
            }

            int yellowCount = (width - 2) * (height - 2);
            if (yellow == yellowCount) { // 이조건이 안맞으면 for 문 다시 돌아야함
                break;
            }
        }
        int[] answer = new int[] { width, height };
        return answer;
    }
    public static void main(String[] args){
        int brown = 24;
        int yellow = 24;
        int[] answer = solution(brown, yellow);
        System.out.println(Arrays.toString(answer));
    }
}
