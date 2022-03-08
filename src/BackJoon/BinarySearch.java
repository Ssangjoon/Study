package BackJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {
  int lo = 0;
  int hi = arr.length -1;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] N = new int[Integer.parseInt(br.readLine())];
    StringBuilder A = sb.append(br.readLine());

    for (int i = 0; i < N.length; i++) {
      N[i] = A.charAt(i);
    }
    int[] T = new int[Integer.parseInt(br.readLine())];
    StringBuilder B = sb.append(br.readLine());
    for (int i = 0; i < T.length; i++) {
      T[i] = B.charAt(i);
    }
    System.out.println(N.length/2);
  }
}
