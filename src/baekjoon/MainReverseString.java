package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainReverseString {
    public static void main(String[] args) throws IOException {
        Stack<Character> stk = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        while (line-- >0){
            String str = br.readLine() + '\n';

            for(char ch : str.toCharArray()){
                if(ch == ' '||ch == '\n'){
                    while(!stk.isEmpty()){
                        //bw.write(stk.pop());
                        sb.append(stk.pop());
                    }
                    sb.append(ch);
                }
                else stk.push(ch);
            }
        }
        System.out.println(sb);
    }
}
