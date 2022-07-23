package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ToArray {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    char[] ch = s.toCharArray();
    System.out.println(ch[0]);
  }
}
