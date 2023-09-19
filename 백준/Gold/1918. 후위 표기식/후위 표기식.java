
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 주어진 중위 표기식을 연산자의 우선순위에 따라 괄호로 묶어준다.
        // 그런 다음에 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨준다.
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String command = br.readLine();
        for (int i = 0; i < command.length(); i++) {
            char now = command.charAt(i);
            switch (now) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.push(now);
                    break;
                case '(':
                    stack.push(now);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(now);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }

    public static int priority(char op) {
        switch (op) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}