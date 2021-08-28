// https://programmers.co.kr/learn/courses/30/lessons/42746
package solution.level2;

import java.util.*;

public class sort_42746 {
    public static String solution(int[] numbers) {
        String answer = "";
        //문자열 리턴을 해줄 스트링배열 생성
        String[] str_container = new String[numbers.length];

        //int배열 String배열로 변환
        // String.valueOf() 메소드 활용
        for(int i = 0; i < numbers.length; i++){
            str_container[i] = String.valueOf(numbers[i]);
        }

        //내림차순 정렬
        Arrays.sort(str_container, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 내림차순이 맞게됐다 => 즉 return이 1이 나와야한다
                // 문자화된 두 수 a,b가 주어졌을때 => 문자로 생각했을때 a,b 문자로 ab, ba를 만들 수 있는데
                // 내림차순이 올바로 됐을땐 ba가 나와야함 즉 ba - ab를 했을때 양수여야지만 됨
                // 따라서 (b+a).compareTo(a+b)가 내림차순, (a+b).compareTo(b+a)가 오름차순
                return (b+a).compareTo(a+b);
                // (참고) 오름차순 정렬 (o1+o2).compareTo(o2+o1);
            }
        });

        //0값이 중복일경우 ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴, 0으로 시작하면이 아니라 그냥 str_container idx0번 값이 0인 경우를 뜻함
        if (str_container[0].equals("0")) return "0";

        //0이 아니면 = 즉, 위 if문에서 끝나지 않았다면 => 문자열을 더해준다.
        for(String s: str_container) answer += s;

        return answer;
    }
    public static void main(String[] args){
        int[] numbers = {3, 30, 34, 5, 9}; // 정답은 "9534330" 이 나와야함
//            int[] prices = {1,2,3,2,3};
        String answer = solution(numbers);
        System.out.println(answer);
    }
}
