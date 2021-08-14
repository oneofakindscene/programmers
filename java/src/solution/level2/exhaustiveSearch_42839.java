//https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
package solution.level2;
import java.util.HashSet;

// 필요한 내용
// 1) prime 판별 메소드 만들어야함
// 2) 경우의 수를 만들어내는 메소드 만들어야함
// 3) main인 solution 메소드에서
public class exhaustiveSearch_42839 {
    // Prime이 아닌 경우 false를 return 나머지 경우는 true를 return
    // solution 함수에서 짝수인 경우는 제외시키고 들어올거임
    public static boolean isPrime(int n){
        if (n==0 || n==1) return false;
        for (int i=3; i<=(int) Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    // if문들 지나면 무조건 for문을 돈다
        // 첫번째 for문 돌때는 숫자 하나하나씩이 prefix가 되면서 set에 담김 "4834"이면 => 4, 8, 3, 4가 담김
            // 재귀한번 일어난 다음 두번째 for문돌떄는 str에서의 첫번쨰 숫자가 prefix랑 결합됨
            // 따라서 prefix가 4인 경우, str값으로 834가 오게되는데 => 두번째 for문 후에는 prefix에 48이 오게되고 이게 set에 담김
        // 이러한 과정이 반복되면서 모든 경우의 수의 조합을 만들 수 있게됨
    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i=0; i<n; i++){
            permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, n), set);
        }
    }

    public static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++; // 빠뜨리기쉬운 엣지 케이스 => 2는 짝수지만 소수이다
            if (a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String numbers = "17";
        int answer = solution(numbers);
        System.out.println(answer);
    }
}
