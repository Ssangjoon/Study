package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDequeue {
        // 에디터 마냥 배열을 두개 만드는 방법밖에 떠오르지 않았다... 너무 쉽게 생각했는데 생각보다 어려웠음
        // 봐도 무슨 말인지... 내일의 나는 힘내렴.

        static int[] dequeue;
        static int front = 0;
        static int back = 0;
        static int size = 0;
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                int N = Integer.parseInt(br.readLine());
                dequeue = new int[N];

                while(N-- > 0){
                        st = new StringTokenizer(br.readLine());

                        switch (st.nextToken()){
                                case "push_front": offerFirst(Integer.parseInt(st.nextToken())); break;
                                case "push_back": offer(Integer.parseInt(st.nextToken())); break;
                                case "poo_front": poll(); break;
                                case "poo_back": pollFirst(); break;
                                case "size": size(); break;
                                case "empty": emtpy(); break;
                                case "front": front(); break;
                                case "back": back(); break;
                        }
                }
        }

        static void offerFirst(int x) {
                // push_front X: 정수 X를 덱의 앞에 넣는다.
                dequeue[front] = x;
                front = (front - 1 + dequeue.length) % dequeue.length;
                size++;
        }

        static void offer(int x) {
                // push_back X: 정수 X를 덱의 뒤에 넣는다.
                dequeue[back] = x;
                size++;
                back++;
        }

        static int poll() {
                // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                int result = dequeue[front];
                dequeue[front] = 0;
                size--;
                front++;
                return result;
        }

        static void pollFirst() {
                // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

        }

        static int size() {
                // size: 덱에 들어있는 정수의 개수를 출력한다.
                return 1;
        }

        static int emtpy() {
                // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
                return 1;
        }

        static int front() {
                // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                return 1;
        }

        static int back() {
                // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                return 1;
        }
}
