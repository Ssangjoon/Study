package BackJoon;
import java.util.Scanner;
public class Rstar {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    boolean stop = true;
    for(int i=1; i<=input; i++) {
      //      System.out.println("i="+i);
      stop = true;

      for(int j=0; j<i;j++) {
        //        System.out.print("j="+j);
        for(int k=input;k>i;k--) {
          //     System.out.print("k="+k);
          if(stop == false) {break;}
          System.out.print(" ");

        }
        System.out.print("*");
        stop = false;
      }

      System.out.println();

    }

  }}


