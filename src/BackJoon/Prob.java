package BackJoon;

public class Prob {

  public static void main(String[] args) {
    int num1 = 6;
    int num2 = 15;

    Prob prob = new Prob();
    System.out.println("두수의 차는: "+ prob.abs(num1,num2));

  }
  public int abs(int num1,int num2) {
    int result = num1-num2;
    if (result < 0) {
      result *=  -1; 
    }
    return result;

  }

}
