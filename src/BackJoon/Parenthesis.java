package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis  {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Character> st = new Stack<>();

    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n; i++) {
      StringBuilder pts = sb.append(br.readLine());
      for(int j = 0; j < pts.length(); j++) {
        char c = pts.charAt(j);//String으로 저장된 문자열 중에서 한 글자만 선택해서 
        //char타입으로 변환해주는 녀석

        if (c == '(') {
          st.push(c);
        } else if (st.empty()) {
          System.out.println("NO");
        } else {
          st.pop();
        }
      }
    }
    if (st.empty()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    //    while (n > 0) {
    //      StringBuilder pt = sb.append(br.readLine());
    //      char[] c = null;
    //      for (int i = 0; i < pt.length(); i++) {
    //        c[i] = pt.charAt(i);
    //        switch(c[i]) {
    //          case '(':
    //            st.push(c[i]);
    //            break;
    //          case ')':
    //            st.pop();
    //            break;
    //          default :
    //            break;
    //        }
    //      }
    //      n--;
    //    }

  }

}