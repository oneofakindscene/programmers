// https://programmers.co.kr/learn/courses/30/lessons/42578
package solution.level2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

// HashMap은 pyhton에서 dictionary와 유사
    // HashMap.put(key, value)
    // HashMap.get(key) 하면 => value값 가져옴
    // HashMap.values() 하면 => value값들 모두 가져옴
// Iterator는 list에 담어서 꺼내오는것과 유사함
public class hash_42578 {
    public static int solution(String[][] clothes) {
        int answer = 1; // 곱셈해야하니깐 초기값이 1이 되어야함
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)) { // key가 없으면 최초니깐 key값 만들어주고 값은 1로 해준다
                map.put(key, 1); //
            } else {
                map.put(key, map.get(key) + 1); // key가 있는 경우니깐 key값에 종류가 하나더 추가됐다는 의미로 +1 해준다.
            }
        }
//        System.out.println(map.values()); // map.values()가 value들을 array형태로 가져온다는 것을 확인 가능
//        System.out.println(map.keySet()); // map.keySet()이 key값들을 array형태로 가져온다는 것을 확인 가능
        Iterator<Integer> iter = map.values().iterator(); // value들로 iterator로 만들어주는 부분 but keySet()으로는 iterator() 못함
        while(iter.hasNext()) {
            // 계산식 = (Atype 갯수 + 1) x (Btype 갯수 + 1)
                // +1 하는 이유는 안 입는 경우도 포함하기 위함
            answer *= iter.next()+1;
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
