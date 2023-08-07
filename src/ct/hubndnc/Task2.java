package ct.hubndnc;


public class Task2 {
    public static void main(String[] args) {
        // 최소 길이 3이 양의 정수 배열 arr (중복x)
        int[] arr = {6,2,12,14};

        // 모든 원소들을 둘씩 짝짓고
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.println(arr[i] + ","+ arr[j]);
                // 최소공배수를 구한다.
                System.out.println("calLCM => " + calLCM(arr[i],arr[j]));
            }
        }

    }
    private static int calLCM(int i, int j){
        int gcd = calGCD(i,j);

        return (i*j)/gcd;
    }
    private static int calGCD(int min, int max){
        if(min<max){
            int temp = min;
            min = max;
            max = temp;
        }
        while(max != 0){
            int rest = min%max;
            min=max;
            max=rest;
        }
        return min;
    }
}
