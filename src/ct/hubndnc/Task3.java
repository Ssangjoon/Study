package ct.hubndnc;

public class Task3 {
    public static void main(String[] args) {
        // 양의 정수인 a(최소 4)
        int a = 30;

        System.out.println(solution(a));
    }
    private static int solution(int a){
        int result = 0;
        for (int i = 0; i <= a; i++) {
            if(primeNumber(i)){
                result = result + i;
            }
        }
        return result;
    }
    public static boolean primeNumber(int number) {
        // number가 1인경우 소수가 아니기 때문에 false
        if (number < 2) {
            return false;
        }

        // 2부터 i의 제곱이 넘어온 number변수보다 작을 경우 반복문을 수행
        for (int i = 2; i * i <= number; i++) {
            // 나머지가 0일 경우 소수가 아니므로 false
            if (number % i == 0) {
                return false;
            }
        }

        // 그 외의 경우 number는 소수이기 때문에 true
        return true;
    }

}
