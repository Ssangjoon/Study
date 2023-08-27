package algorithm.data_stucture.doit.basicDS;

// 재귀에 대한 이해를 돕는 순수 재귀 메서드

import java.util.Scanner;
import java.util.Stack;

class Recur {

    static void recur(int n) {
        Stack<Integer> st = new Stack<>();
        while (true){
            if (n > 0) {
                st.push(n);
                n = n - 1;
                continue;
            }
            if(st.isEmpty() != true){
                n = st.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
