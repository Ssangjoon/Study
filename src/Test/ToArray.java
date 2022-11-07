package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ToArray {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    char[] ch = str.toCharArray();
    System.out.println("ch = " + ch);

    for ( char a : str.toCharArray()){
      System.out.println("a = " + a);
    }
  }
}
