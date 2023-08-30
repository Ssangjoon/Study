
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String initialStr = br.readLine();
        int m = Integer.parseInt(br.readLine());

        for (int i=0;i<initialStr.length();i++) {
            leftStack.push(initialStr.charAt(i));
        }

        for (int i=0;i<m;i++) {
            String commandLine = br.readLine();
            char command = commandLine.charAt(0);

            switch (command) {
                case 'P':
                    leftStack.push(commandLine.charAt(2));
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                case 'L':
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (!rightStack.empty()) leftStack.push(rightStack.pop());
                    break;
                default: break;
            }
        }
        while(!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.empty()) {
            bw.write(rightStack.pop());
        }
        bw.close();
        br.close();
    }
}