package Test;

import java.util.Arrays;

public class Test {

  public static void main(String[] args) {
    Integer[] arr = {1,2,3,4,5,35,2523,8,24};
    //    Arrays.sort(arr); 
    int target = 40;

    //        Arrays.sort(arr, (a, b) -> {
    //          int gap1 = Math.abs(target-a);
    //          int gap2 = Math.abs(target-b);
    //          return gap1>gap2 ? 1 : -1;
    //        });

    Arrays.sort(arr, (a, b) -> Math.abs(target - a)> Math.abs(target - b) ? 1: -1);

    System.out.println(Arrays.toString(arr));
  }

}
