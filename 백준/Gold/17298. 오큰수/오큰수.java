import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < N; i++) {

            /*
             * 스택이 비어있지 않으면서
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
             */
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                input[stack.pop()] = input[i];
            }

            stack.push(i);
        }

        /*
         * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
         * -1로 초기화한다.
         */
        while (!stack.isEmpty()) {
            input[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(input[i]).append(' ');
        }

        System.out.println(sb);

    }
}