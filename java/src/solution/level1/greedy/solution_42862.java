// https://programmers.co.kr/learn/courses/30/lessons/42862
package solution.level1.greedy;

public class solution_42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] all = new int[n]; // 학생수 만큼의 array를 만든다
        for (int i : reserve) // 여분있는 학생들은 +1로 표시
            all[i - 1]++;
        for (int i : lost) // 도난당한 학생들은 -1로 표시
            all[i - 1]--;

        for (int i = 0; i < all.length; i++)
            if (all[i] < 0) // 도난당한 학생이라면??
                // 마지막 학생이 아니고, 뒤에 학생이 체육복이 있다면 => 뒤에 빌려보는 로직
                if (i != all.length - 1 && all[i + 1] > 0) {
                    all[i]++;
                    all[i + 1]--;
                    // 첫번째 학생이아니고 앞에 학생이 체육복이 있다면 => 앞에 빌려보는 로직
                } else if (i != 0 && all[i - 1] > 0) {
                    all[i]++;
                    all[i - 1]--;
                }

        int answer = 0;
        for (int i = 0; i < all.length; i++)
            if (!(all[i] < 0)) // 체육복 입고나간애들만 구하기 위한 부분
                answer++;
        return answer;
    }
    public static void main(String[] args){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        int answer = solution(n, lost, reserve);
        System.out.println(answer);
    }
}
