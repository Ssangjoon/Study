package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringReverse {

  public static void main(String[] args) throws  Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    java.util.Stack<Character> stack = new java.util.Stack<Character>();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(num-- > 0) {
      System.out.println(num);
      String input = br.readLine()+"\n";
      for(char ch : input.toCharArray()) {
        if(ch == ' ' || ch == '\n') {
          while(!stack.isEmpty()) {
            bw.write(stack.pop());
          }
          bw.write(ch); // 공백
        } else
          stack.push(ch);
      }
    }
    bw.flush();
    return;
  }
}
