package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainEditor {
    static Stack<Character> stk = new Stack<>();
    static Stack<Character> stk2 = new Stack<>();
    static int cursor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        String S = br.readLine();
        cursor = S.length()+1;
        for (char s:S.toCharArray()){
            stk.push(s);
        }

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "P" :
                    P(st.nextToken().charAt(0));
                    break;
                case "L":
                    L();
                case "D":
                    D();
                case "B":
                    B();
            }
        }
        System.out.println(stk.toString());
    }
    static void L(){
        if(cursor > 0)
        cursor--;
    }
    static void D(){
        if (cursor < stk.size()+2)
        cursor++;
    }
    static void B(){
        int len = stk.size() - (cursor - 1);
        for (int i = 0; i < len; i++) {
            stk2.push(stk.pop());
        }
        stk.remove(cursor-1);
        for (int i = 0; i < len; i++) {
            stk.push(stk2.pop());
        }
    }
    static void P(Character x){
        int len = stk.size() - cursor - 1;
        for (int i = 0; i < len; i++) {
            stk2.push(stk.pop());
        }
        stk.push(x);
        for (int i = 0; i < len; i++) {
            stk.push(stk2.pop());
        }
        cursor++;
    }
}
