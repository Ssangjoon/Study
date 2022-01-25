package BackJoon;

public class Prob2 {

  public static void main(String[] args) {
    int month = Integer.parseInt(args[0]);
    new Prob2().printSeason(month);

  }
  public void printSeason(int month) {
    switch(month) {
      case 3,4,5 :
        System.out.println("봄에 태어나셨네요");
      break;
      case 6,7,8 : 
        System.out.println("여름에 태어나셨네요");
      break;
      case 9,10,11 : 
        System.out.println("가을에 태어나셨네요");
      break;
      case 12,1,2 : 
        System.out.println("겨울에 태어나셨네요");
      break;
      default : 
        System.out.println("1~12의 숫자만 입력하셔야 합니다.");
    }
  }

}
