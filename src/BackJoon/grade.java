package BackJoon;
import java.util.Scanner;

public class grade {

  public static void main(String[] args) {

    //점수와 시험 성적을 표시하기 위한 변수 선언
    int score;
    String grade;
    //점수 입력 
    Scanner sc = new Scanner(System.in);
    score = sc.nextInt();

    //점수에 따른 시험 성적을 구함
    if (score>=90) 
      grade = "A";
    else if (score >=80)
      grade="B";
    else if (score>=70)
      grade="C";
    else if(score>=60)
      grade="D";
    else
      grade="F";

    System.out.println(grade);
    /*
    Scanner sc = new Scanner(System.in);
    int score = sc.nextInt();

    if (score >=90 && score <=100) {
      System.out.println('A');
    } else if (score >=80 && score <=89) {
      System.out.println('B');
    } else if (score >=70 && score <=79) {
      System.out.println('C');
    }else if (score >= 60 && score <=69) {
      System.out.println('D');
    } else {
      System.out.println('F');
    } */



  }

}
