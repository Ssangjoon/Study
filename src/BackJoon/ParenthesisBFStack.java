package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisBFStack{

  public static int size = 0;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int T = Integer.parseInt(br.readLine());

    for(int i = 0; i < T; i++) {
      StringBuilder pts = sb.append(br.readLine());
      for(int j = 0; j < pts.length() ;j++) {
        char c = pts.charAt(j); //String으로 저장된 문자열 중에서 한 글자만 선택해서 
        //char타입으로 변환해주는 녀석

        if (c =='(') {
          stack.push(c);
        } else if (stack.empty()) {
          System.out.println("NO");
        } else {
          stack.pop();
        }
      }
    }
    if (stack.empty()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
