

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*stack 을 while 문 밖에 선언하여 이전 값이 남아 계속 no가 뜨는 현상이 발생하였다.
    위치를 바꾸니 정상작동*/
    /*아래 if 문은 계속 실행을 해버린다.
    if 를 한번 더 썼는데 ,,, 스트레인지 아저씨 처럼 메서드로 뺴는게 더 깔끔한거 같다.*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        while(line-- > 0){
            Stack<Character> stk = new Stack<>();
            String ps = br.readLine();

            for(char c:ps.toCharArray()){
                if (c == '(') {
                    stk.push(c);
                } else {
					if(stk.isEmpty()) {
						stk.push(c);
						break;
					}else {
						stk.pop();
					}
                }
            }

            if(stk.isEmpty()){
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }
}

