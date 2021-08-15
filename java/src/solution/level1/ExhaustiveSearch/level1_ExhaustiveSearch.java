// 모의고사 : https://programmers.co.kr/learn/courses/30/lessons/42840
package solution.level1.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;

class Solution_42840 {
    public static int[] solution(int[] answers) {
//        int[] answer = {};
        int answer1 = 0, answer2 = 0, answer3 = 0;

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            if (person1[i%person1.length] == answers[i]) answer1++;
            if (person2[i%person2.length] == answers[i]) answer2++;
            if (person3[i%person3.length] == answers[i]) answer3++;
        }

        int max = Math.max(Math.max(answer1, answer2), answer3);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==answer1) {list.add(1);}
        if(max==answer2) {list.add(2);}
        if(max==answer3) {list.add(3);}

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

public class level1_ExhaustiveSearch{
    public static void main(String[] args) {
        int[] answers  = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        int[] answer = Solution_42840.solution(answers2);
        System.out.println(Arrays.toString(answer));
    }
}