package solution.level2;

public class dfsbfs_43165 {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    static int dfs(int[] numbers, int n, int sum, int target) {
        if (n==numbers.length){
            if(sum==target){
                return 1; // recursive하니깐 1들을 합치면 몇가지로 가능한지 알 수 있음
            }
            return 0; // recusrisve 되는데 sum == target 안되는 애들은 count 안되게하기위해 return 0 해줌
        }
        return dfs(numbers, n+1, sum + numbers[n], target) + dfs(numbers, n+1, sum - numbers[n], target);
    }
    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1}; // 5가 나와야 정답
        int target = 3;
        int answer = solution(numbers, target);
        System.out.println(answer);
    }
}
