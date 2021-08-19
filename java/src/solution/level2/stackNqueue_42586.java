// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
package solution.level2;
import java.util.*;
// 문제 핵심조건
    // progresses, speeds의 idx는 업무갯수를 뜻하고 idx가 빠른것 부터 무조건 먼저 배포되어야함
    // 따라서, 뒷순번 idx의 업무가 빠르게 개발되더라도 앞순번 개발이 완료될때 함께 배포되야함

// LinkedList는 왜 어떤 Queue지? => 가장 일반적인 FIFO Queue라고 생각하자
    // peek() : queue에 맨위에 값이 있는지 확인할때 사
    // offer() : queue에 element를 넣을때 사용
    // poll() : 가장 먼저 보관한 자료를 꺼낼 때는 poll 메서드를
// ArrayList
    // add() : Queue의 offer()처럼 element 집어넣을때 사용
public class stackNqueue_42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>(); // 조건문에서 empty(), peek(), size() 등을 사용하기 위해 필요
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int workday = (int) Math.ceil(remain); //
            // 아래 if문은 q가 안비어있고, q 맨 마지막에 들어온 값이 date값보다 작을때 실행됨
            // q.peek() : 직전의 workday값이 담겨있음
            if (!q.isEmpty() && q.peek() < workday) { // 이 로직에 걸리면 배포되는거
                answerList.add(q.size()); // 배포될때 몇개가 배포되는지 answerList에 넣어줌
                q.clear();
            }
            q.offer(workday); // 비우지 않고 쌓아주는 경우 => 나중에 같이 배포하기 위해
        }
        answerList.add(q.size()); // 맨마지막꺼는 여기서 배포한 것으로 처리해줘야함

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = solution(progresses, speeds);
        System.out.println(Arrays.toString(answer));

    }
}
