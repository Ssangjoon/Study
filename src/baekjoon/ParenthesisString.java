package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisString {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int num = Integer.parseInt(br.readLine());

    for(int i = 0; i<num; i++) {
      sb.append(solve(br.readLine())).append('\n');
    }

  }

  public static String solve(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c =='(') {
        stack.push(c);
      }
      else if (stack.empty()) {
        return "NO";
      }
      else {
        stack.pop();
      }
    }
    if (stack.empty()) {
      return "YES";
    }
    else {
      return "NO";
    }
  }

}
