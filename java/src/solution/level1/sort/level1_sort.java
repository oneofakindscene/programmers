// k번째 수 : https://programmers.co.kr/learn/courses/30/lessons/42748
package solution.level1.sort;

import java.util.Arrays;
public class level1_sort {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(array, commands);
        // line 6에 static을 없애려면 아래와 같이 해줘야함
//            level1_sort temp = new level1_sort();
//            int[] answer = temp.solution(array, commands);
        System.out.println(Arrays.toString(answer));
        // 정답 : [5, 6, 3]
    }
}
