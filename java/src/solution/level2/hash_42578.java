// https://programmers.co.kr/learn/courses/30/lessons/42578
package solution.level2;
import java.util.HashMap;
import java.util.Iterator;

// HashMap은 pyhton에서 dictionary와 유사
    // HashMap.put(key, value)
    // HashMap.get(key) 하면 => value값 가져옴
    // HashMap.values() 하면 =>
// Iterator는 list에 담어서 꺼내오는것과 유사함
public class hash_42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            // 계산식 = (Atype 갯수 + 1) x (Btype 갯수 + 1)
                // +1 하는 이유는 안 입는 경우도 포함하기 위함
            answer *= it.next().intValue()+1;
        }
        return answer-1; // 아무것도 안선택한 경우는 제외
    }
    public static void main(String[] args){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer = solution(clothes);
        System.out.println(answer);
    }
}
