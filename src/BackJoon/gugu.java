package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class gugu {

  public static void main(String[] args) throws IOException{ 

    //      Scanner sc = new Scanner(System.in);
    //      int go = sc.nextInt();
    //      sc.close();
    //      for(int i=0; i<10; i++) {
    //          System.out.println(go+" * "+i+" = "+(go*i));
    //      }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine()); // BufferedReader or readLine()의 기본타입은 문자열
    br.close();
    for (int i=0; i<10; i++) {
      System.out.println(a+" * "+i+" = "+(a*i));
    }


  }

}
