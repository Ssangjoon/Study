package BackJoon;

public class prime {
  public static void main(String [] args) {

    int limit = 50;
    boolean prime = false;
    for(int i=2; i<=50; i++) {

      prime = true;
      System.out.println("I=" + i);
      for(int j=2; j<i; j++) {
        System.out.println("J=" + j);
        if(i%j ==0) {
          prime = false;
          break;
        }
      }
      if(prime == true) {
        System.out.println(i);
      }
    }
  }
}

