import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		// 오큰수 문제 풀기
		// 크기가 N인 수열이 있다.
        // 수열의 각 원소에 대해 오른쪽에 있으면서 해당 원소보다 큰 수중에서 가장 왼쪽에 있는 수를 구한다.
        // 없는 경우는 -1이다.

		// 인덱스를 기준으로 문제를 푸는게 신박하다.
		// 수열을 탐색하면서 현재 원소가 이전의 원소보다 작을 때까지 stack에 수열의 index를 stack에 추가 한다.
		// 그러다가 오큰수를 만나면 stack의 원소를 pop하면서 해당 인덱스에 해당하는 원소들의 현재의 원소로 바꾼다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

        for(int i = 0; i < N; i++) {

			/*
			 * 스택이 비어있지 않으면서
			 * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			 * 해당 인덱스의 값을 현재 원소로 바꿔준다.
			 */
			while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}

			stack.push(i);
		}

        /*
		 * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
		 * -1로 초기화한다.
		 */
		while(!stack.isEmpty()) {
			seq[stack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(seq[i]).append(' ');
		}

		System.out.println(sb);

        // ============================================= //
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        Queue<Integer> q = new ArrayDeque<>();
//        Queue<Integer> q2 = new ArrayDeque<>();
//
//        // N 입력 받기
//        int N = Integer.parseInt(br.readLine());
//
//        // 수열 입력 받기
//        String command = br.readLine();
//
//        // 수열을 큐에 담기
//        String[] numbers = command.split(" ");
//        // 배열에 저장된 숫자를 큐에 순서대로 추가
//        for (String numberStr : numbers) {
//            int number = Integer.parseInt(numberStr);
//            q.offer(number);
//        }
//
//        // 문자 하나를 꺼내어 스택의 가장 위, 남은 수열의 가장 좌측과 비교한다
//        for (int i = 0; i < N -1; i++) {
//            int c = q.poll(); // 비교하기 위해 뺀값
//            boolean check = true;
//            for (int j = i; j < N; j++) {
//                int d = q.poll();
//                if (c < d){
//                    sb.append(d);
//                    check = !check;
//                    q.offer(d);
//                    break;
//                }
//                q.offer(d);
//            }
//            if(check){
//                sb.append(-1);
//                sb.append(" ");
//            }
//        }
//        System.out.println(sb.toString());
    }
}
