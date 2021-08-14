package solution.level2;

import java.util.*;

public class Heap_42746 {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] str_container = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            str_container[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str_container, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (str_container[0].equals("0")) return "0";
        for(String s: str_container) answer += s;
        return answer;
    }
    public static void main(String[] args){
        int[] numbers = {3, 30, 34, 5, 9}; // 정답은 "6210" 이 나와야함
//            int[] prices = {1,2,3,2,3};
        String answer = solution(numbers);
        System.out.println(answer);
    }
}
