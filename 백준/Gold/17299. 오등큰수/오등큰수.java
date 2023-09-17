import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] cnt = new int[1_000_001];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            cnt[input[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && cnt[input[stack.peek()]] < cnt[input[i]]) {
                answer[stack.pop()] = input[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty())
            answer[stack.pop()] = -1;

        for (int i = 0; i < N; i++)
            sb.append(answer[i]).append(" ");

        System.out.println(sb);

    }
}