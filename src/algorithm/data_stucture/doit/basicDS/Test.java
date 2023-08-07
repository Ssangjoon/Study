package algorithm.data_stucture.doit.basicDS;

public class Test {
    public static void main(String[] args) {
        IntQueue iq = new IntQueue(8);
        iq.enque(3);
        iq.enque(7);
        iq.enque(11);
        iq.deque();
        iq.indexOf(8);
    }
}
