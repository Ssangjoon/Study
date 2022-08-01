package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> queue = new LinkedList<>(); 
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append('<');

    while(queue.size() > 1) {
      for (int i=0; i< k-1; i++) {
        queue.offer(queue.poll());
      }
      sb.append(queue.poll()).append(", ");
    }

    sb.append(queue.poll()).append('>');
    System.out.println(sb);
  }
}
