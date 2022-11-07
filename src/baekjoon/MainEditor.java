package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainEditor {
    // 맞는거 같은데 결과가 자꾸 달라서 보니 case에 break를 붙이지 않아서 그런거 였다 .. 촴..
    // 아니 근데 두번쨰 예제는 답이 안나옴
    static Stack<Character> stk = new Stack<>();
    static Stack<Character> stk2 = new Stack<>();
    static int cursor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        String str = br.readLine();
        // 맨오른쪽에 커서는 위치한다.
        cursor = str.length()+1;
        for (char s:str.toCharArray()){
            stk.push(s);
        }

        // 명령어 개수
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "P" :
                    P(st.nextToken().charAt(0));
                    break;
                case "L":
                    L();
                    break;
                case "D":
                    D();
                    break;
                case "B":
                    B();
                    break;
                default:
                    System.out.println(cursor);
                    System.out.println(stk.toString());
            }
        }
        System.out.println("result => " + stk.toString());
    }
    static void L(){
        // 커서를 왼쪽으로 한칸 (맨앞이면 무시)
        if(cursor >= 1)
        cursor--;
    }
    static void D(){
        // 커서를 오른쪽으로 한칸 (맨 뒤면 무시)
        if (cursor <= stk.size())
        cursor++;
    }
    static void B(){
        // 커서 왼쪽에 있는 문자를 삭제함 (맨 앞이면 무시)
        // 삭제로 인해 커서는 왼쪽으로 이동 한듯 보이나 , 실제로 커서 오른쪽에 있던 문자는 그대로
        if (cursor != 0){
            // pop할 횟수
            int len = stk.size() - (cursor - 1);
            for (int i = 0; i < len; i++) {
                stk2.push(stk.pop());
            }
            stk.remove(cursor-2);
            for (int i = 0; i < len; i++) {
                stk.push(stk2.pop());
            }
        }
    }
    static void P(Character x){
        // x를 커서 왼쪽에 추가
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
