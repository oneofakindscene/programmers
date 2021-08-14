// https://programmers.co.kr/learn/courses/30/lessons/42587
package solution.level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class stackNqueue_42587 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i:priorities){
            que.offer(i);
        }
        int size = que.size();
        Loop:while(true){
            for (Integer j : que){
                if (que.peek() < j){
                    if (location == 0){
                        que.offer(que.poll());
                        location = que.size() - 1;
                    } else {
                        que.offer(que.poll());
                        location--;
                    }
                    continue Loop;
                }
            }
            que.poll();
            if (location == 0){
                answer = size - que.size();
                break;
            }
            location --;
        }
        return answer;
    }
    public static void main(String[] args){
        int[] priorities = {2,1,3,1};
        int location = 3;
        int answer = solution(priorities, location);
        System.out.println(answer);
    }
}
