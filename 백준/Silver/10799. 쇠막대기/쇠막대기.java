
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		// 쇠 막대기 문제 풀기
		// 여러 쇠 막대기를 겹쳐 놓고 위에서 레이저를 발사하여 자른다.
		// 올라갈수록 짧은 막대기이며
		// 올릴 때는 아래 막대기에 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.

		// 레이저는 적어도 하나이상 존재하며, 어떤 쇠막대기의 양 끝점과 겹치지 않는다.
		// 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍'()' 으로 표현된다.
		// 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.
		// 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String command = br.readLine();

        int ironCount = 0;

        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == '('){
                stack.push(command.charAt(i));
            }
            if(command.charAt(i) == ')'){
                stack.pop();
                if(command.charAt(i-1) == '('){
                    ironCount += stack.size(); // 레이저를 쐈다. 현재 남아있는 iron의 갯수가 두배로
                } else {
                    ironCount++; // 하나의 아이언
                }
            }
        }
        System.out.println(ironCount);
    }
}