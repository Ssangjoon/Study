package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharAt {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int length = input.length();
    while(length-- > 0) {
      System.out.println(input.charAt(length));
    }
  }

}
