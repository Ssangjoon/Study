package BackJoon;

public class fibonacci {
  public static int fibo(int input) {

    if(input == 1) {
      return 1;
    } else if (input == 2 ) {
      return 2;
    }
    else {
      return fibo(input -1) + fibo(input-2);
    }// return (input -1) + (input-2); 왜 다르지?

  }

  public static void main(String[] args) {
    System.out.println(fibo(6));

  }

}
