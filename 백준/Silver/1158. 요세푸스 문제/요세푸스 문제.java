import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 요세푸스 문제 풀기
        // 원을 이루며 앉은 N명의 사람을 주어지는 정수 K의 순서대로 제거한다.
        // 한사람이 제거되면 남은 사람들로 이뤄진 원을 따라 계속 제거 한다.
        // 원에서 사랃들이 제거 되는 순서를 구하는 프로그램을 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
        // K와 N을 받는다.
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

        // N만큼의 Int배열 생성 -> list 인터페이스를 쓰자
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
		StringBuilder sb = new StringBuilder();
		sb.append('<');

		int index = 0;	// 리스트에서 삭제할 요소를 참조할 인덱스 변수

		while(N > 1) {
            // 시작과 끝을 지정하고 끝에 도달하면 처음부터 다시 ... -> 나머지 구하는 공식을 구하면 된다.
			index = (index + (K - 1)) % N;

            // queue에 담아서 차례로 출력한다. -> 인덱스를 삭제하고 바로 담는게 더 직관적이다.
			// index위치에 있는 요소를 삭제함과 동시에 출력
			sb.append(list.remove(index)).append(", ");
			N--;
		}

		// 마지막으로 남은 요소 삭제함과 동시에 출력
		sb.append(list.remove()).append('>');
		System.out.println(sb);
    }
}