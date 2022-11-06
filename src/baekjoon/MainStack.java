package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainStack {
  private static int[] stack;
  private static int size = 0;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int orderNum = Integer.parseInt(br.readLine());
    stack = new int[orderNum];

    while (orderNum-- > 0) {
      st = new StringTokenizer(br.readLine());

      switch (st.nextToken()){
        case "push":
          push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(pop()).append("\n");
          break;
      }
      System.out.println(sb);
    }

  }
  private static void push(int x){
    //  정수 X를 스택에 넣는 연산이다.
    stack[size] = x;
    size ++;
  }
  private static int pop(){
    // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    if (size == 0) {
      return -1;
    } else {
      int result= stack[size];
      stack[size] = 0;
      size--;
      return result;
    }
  }
  private static int size(){
    // 스택에 들어있는 정수의 개수를 출력한다.
    return size;
  }
  private static int empty() {
    // 스택이 비어있으면 1, 아니면 0을 출력한다.
    return size == 0 ? 1 : 0;
  }
  private static int top(){
    // 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    return size != 0 ? stack[size] : -1;
  }
}