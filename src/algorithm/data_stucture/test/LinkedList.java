package algorithm.data_stucture.test;

public class LinkedList {
  Node head; 
  Node tail;
  int size; 

  public void add(Object value) {
    Node node = new Node(value);

    if (head == null) {
      tail = head = node;
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node; 
    }
    size++;
  }
  public int size() {
    return size; 
  }

  public Object get(int index) {
    Node node = getNode(index);
    return node.value; 
  }

  public Object remove(int index) {
    Node node = getNode(index);

    if(size == 1) {
      head = tail = null;
    } else if (node == head){
      head = node.next;
    } else if (node == tail){
      tail = node.prev;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev; 
    }

    // 삭제된 노드는 다른 노드나 객체를 참조하지 않도록 초기화시킨다. 
    // => 삭제된 노드끼리 참조함으로써 가비지가 되지 않는 문제를 방지함.
    node.prev = null; 
    node.next = null; 
    Object deleted = node.value;
    node.value = null;
    --size;

    return deleted;
  }

  private Node getNode(int index) { // 이 메서드는 공개할 필요가 없으므로 private로 설정한다. 
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node node = head; 
    int count = 0;
    while (count < index) {
      node = node.next;
      count++;
    }
    return node;
  }

  public void add(int index, Object value) {
    Node node = getNode(index);

    Node newNode = new Node(value);

    if (node.prev != null) { 
      node.prev.next = newNode;
    }
    newNode.prev = node.prev;
    node.prev = newNode;
    newNode.next = node;

    if (node == head) {
      head = newNode;
    }
    size++;
  }
  public Object set(int index, Object value) {
    Node node = getNode(index);
    Object old = node.value;
    node.value = value;
    return old;
  }

}
