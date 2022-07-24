package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue {
  public static int[] queue;
  public static int size = 0;
  public static int front = 0; // pop 기준
  public static int rear = 0; // push 기준

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    queue = new int[N];

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
        case "front":
          System.out.println(front());
          break;
        case "back":
          System.out.println(back());
          break;
        case "empty":
          System.out.println(empty());
          break;
      }
    }
  }
  static void push(int X){
    rear = (rear+1)%queue.length;
    queue[rear] = X;
    size ++;
  }

  static int pop() {
    if (size == 0) {
      return -1;
    } else {
      int item = queue[front+1]; 
      queue[front+1] = 0;
      front++;size--;
      return item;
    }
  }

  static int size() {
    return size;
  }

  static int empty () {
    return size == 0 ? 1 : 0;
  }

  static int front() {
    if(empty() == 1) {
      return -1;
    } else return queue[front+1];
  }

  static int back() {
    if(empty() == 1) {
      return -1;
    } else return queue[rear];
  }
}