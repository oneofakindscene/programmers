// https://programmers.co.kr/learn/courses/30/lessons/42577
package solution.level2;
import java.util.Arrays;

// startsWith : 접두사(prefix) 확인하는 method => 비교대상문자열.startsWith("체크할문자열")
// endsWith : 접미사(suffix) 확인하는 method => 비교대상문자열.endsWith("체크할문자열")
public class hash_42577 {
    public static boolean solution(String[] phone_book) {
        // 방법1
        Arrays.sort(phone_book); // sort하면 가장 앞자리 숫자 기준으로 정렬함 "111", "1111" 중에서는 "111"이 먼저 나옴
                                 // 따라서, 접두사로 쓰인다면 접두사로 쓰이는 값이 앞에 올 수 밖에없음
//        System.out.println(Arrays.toString(phone_book));
        for(int i=0; i<phone_book.length-1; i++) {
            // (핵심포인트!) 접두사인 숫자와 접두사를 사용하는 숫자는 idx 1개 차이로 정렬되어있을 수 밖에없음
                // 따라서, for문돌면서 바로 뒤에 있는지만 확인하면 됨
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
        // 방법2 : HashSet 활용 => 현재 이 방법으로는 불합격
//        for (int i = 0; i < phone_book.length - 1; i++) {
//            int hashPhone = phone_book[i].hashCode();
//            int len = phone_book[i].length();
//
//            for (int j = i + 1; j < phone_book.length; j++) {
//                if (phone_book[j].length() >= len
//                        && hashPhone == (phone_book[j].substring(0, len).hashCode())) {
//                    return false;
//                } else if (phone_book[j].length() < len
//                        && phone_book[i].substring(0, phone_book[j].length()).hashCode() == phone_book[j].hashCode()) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123","456","789"};
//        String[] phone_book = {"12","123","1235","567","88"};
        boolean answer = solution(phone_book);
        System.out.println(answer);
    }
}
