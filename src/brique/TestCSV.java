package brique;

import java.util.Arrays;
import java.util.List;

public class TestCSV {

  public static void main(String[] args) {
    int cur = 0;
    float max = 0;
    float min = 10000;
    float sum = 0; 
    float avg;
    float std ;
    float middle = 0;

    String path = "C:/Users/qkqh3/git/practice/src/brique/sample.csv";

    List<List<String>> list = CsvUtils.readToList(path);
    for(int i=1; i<list.size(); i++) {
      List<String> line = list.get(i);
      float[] arrayDouble = new float[line.size()-1];
      try {
        for(int j=0; j<line.size()-1; j++) {

          cur = Integer.parseInt(line.get(j));

          arrayDouble[j] = cur;

          if ( cur > max) {
            max = cur;
          }else if (cur<min) {
            min = cur;
          }
          sum += cur;
        }
        avg = sum/line.size();
        double dis = Math.pow(cur - avg, 2);
        std = (float) Math.sqrt(dis);
        middle = getMedian(arrayDouble);
        System.out.printf("%.1f%.1f%.1f%.1f%.1f%.1f",min,max,sum,avg,std,middle);
        System.out.println();
      }catch(NumberFormatException e) {
      }
    }
  }
  private static float getMedian(float[] arrayInt) {

    Arrays.sort(arrayInt);//오름차순 정렬
    int size = arrayInt.length;
    float result;

    if(size % 2 == 0){ //배열크기가 짝수일경우
      int m = size / 2;
      int n = size / 2 - 1;
      result = (arrayInt[m] + arrayInt[n]) / 2; //중앙값 2개의  평균
    }
    else { //배열크기가 홀수인경우
      int m =size / 2;
      result = arrayInt[m]; //중앙값
    }

    return result;

  }
}
