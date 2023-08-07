package ct.nullySoft;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

//        guguExclude();
//        lotto();
        System.out.println(checkAnagram("apple", "pplea"));
//        System.out.println(fibo(7));
//        System.out.println(memoFibo(7));
//        System.out.println(fact(5));
        randomQuiz();
    }
    public static void gugu(){
        for (int i = 1; i <= 9; i++) {
            System.out.println(">" + i + "단");
            for (int j = 0; j <= 9; j++) {
                System.out.println(i + "*" + j + "=" + i*j);
            }
        }
    }
    public static void guguExclude(){
        for (int i = 0; i <= 9; i++) {
            if(!((3*i)%4==0)){
                System.out.println(3*i);
            }
        }
    }
    public static void lotto(){
        int[] ball = new int[45];
        for (int i = 0; i < ball.length; i++) {
            ball[i] = i+1;
        }
        int tmp = 0;
        int lotto = 0;
        int count= 0;
        for (int i = 0; i < 777; i++) {
            lotto = (int)(Math.random() * 45);
            tmp = ball[0];
            ball[0] = ball[lotto];
            ball[lotto] = tmp;
            count++;
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(ball[i] + "/");
        }
    }
    public static boolean checkAnagram(String str1, String str2){
        // 공백 제거
        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s","");

        // 미리 문자열의 길이가 같은지 계산하여 1차적인 결과 수행
        if(str1.length() != str2.length()){
            return false;
        }

        // 두 단어 다 소문자로 변환 후 char 형식으로 변환해주는 toCharArray() 메서드 활용
        char[] char1 = str1.toLowerCase().toCharArray();
        char[] char2 = str2.toLowerCase().toCharArray();

        // Array.sort()를 이용하여 정렬한다.
        Arrays.sort(char1);
        Arrays.sort(char2);

        // String 비교를 위해 character배열을 String으로 변환한다.
        String _str1 = new String(char1);
        String _str2 = new String(char2);

        // 결과를 리턴한다.
        return _str1.equals(_str2);
    }

    //피보나치
    public static int fibo(int data) {
        if(data <= 1) {
            return 1;
        }

        return fibo(data-1) + fibo(data-2);
    }


    //factorial
    public static int fact(int data) {
        if(data <= 1)
            return 1;

        return fact(data-1) * data;
    }

    //Math.Random();
    public static void randomQuiz() {

        for(int i=0; i < 50; i++) {

            int randomValue = (int)(Math.random()*10)+1;
            System.out.println(randomValue);
        }
    }
}
