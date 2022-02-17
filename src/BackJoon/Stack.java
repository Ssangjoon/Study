package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {
  public static int[] stack;
  public static int size = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    stack = new int[N];


    while(N-- > 0) {
      st = new StringTokenizer(br.readLine(), " ");

      switch(st.nextToken()) {
        case "push":
          push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          System.out.println(pop());
          break;
        case "size":
          System.out.println(size());
          break;
        case "empty":
          System.out.println(empty());
          break;
        case "top":
          System.out.println(top());
          break;
      }

    }
  }

  static void push(int X) {
    stack[size] = X;    
    size++;
  }

  static int pop() {
    if(size == 0) {
      return -1;
    }
    int pop = stack[--size] ;
    stack[size +1] = 0;
    return pop;
  }

  static int size() {
    return size;
  }

  static int empty() {
    if (size == 0) {
      return 1;
    } else return 0;
  }

  static int top() {
    if(size == 0) {
      return -1;
    }
    return stack[size-1];
  }
}
