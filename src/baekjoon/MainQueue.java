package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainQueue {
    // 링크드리스트와 arraydequeue로도 한번 해보기?
    private static int[] queue;
    private  static int size = 0;
    private static int front = 0;
    private static int back = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order){
                case "push":
                    offer(Integer.parseInt(st.nextToken()));
                    break;
                case "poll":
                    poll();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
    }

    static void offer(int x){
        //정수 X를 큐에 넣는 연산이다.
        queue[back] = x;
        back++;
        size++;
    }

    static int poll(){
        // 큐에서 가장 앞에 있는 정수를 빼고,
        // 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size > 0){
            int that = queue[front];
            queue[front] = 0;
            size--;
            front++;
            return that;
        }
        return -1;
    }

    static int front(){
        // 큐의 가장 앞에 있는 정수를 출력한다.
        // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size == 0) {
            return -1;
        } else {
            return queue[front];
        }
    }

    static int back(){
        // 큐의 가장 뒤에 있는 정수를 출력한다.
        // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size == 0){
            return -1;
        } else {
            return queue[back];
        }
    }

    static int size(){
        // 큐에 들어있는 정수의 개수를 출력한다.
        return size;
    }

    static int empty(){
        // 큐가 비어있으면 1, 아니면 0을 출력한다.
        if(size > 0 ){
            return 0;
        } else{
            return 1;
        }
    }
}
