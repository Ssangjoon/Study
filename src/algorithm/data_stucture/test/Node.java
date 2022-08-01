package algorithm.data_stucture.test;

public class Node {
  Node prev;
  Object value; // 어떤 객체의 주소도 받을 수 있도록 Object로 설정 
  Node next;

  public Node() {};
  public Node(Object value) {
    this.value = value;
  }
  public Node(Object vlaue, Node prev, Node next) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}
