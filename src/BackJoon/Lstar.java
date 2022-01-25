package BackJoon;
import java.util.Scanner;
public class Lstar {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int star = sc.nextInt();

    for(int i=1; i<=star; i++) {
      for(int j=0;j<i;j++) {
        System.out.print('*');
      }
      System.out.println();
    }

  }

}
