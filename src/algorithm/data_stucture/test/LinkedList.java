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

    return deleted; // 삭제 되기 전 값 리턴
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
    return old; // 변경되기 전 값 리턴
  }

  public Iterator iterator() { // inner-class의 경우 자동으로 생성된 생성자를 파라미터로 쓸 수 없고, 앞으로 넘겨야 함 
    // local class 활용 예 
    // => 특정 메서드 안에서만 사용될 때
    // 
    return new Iterator(){
      int cursor;
      @Override
      public boolean hasNext() {
        return cursor < LinkedList.this.size();
      }

      @Override
      public Object next() {
        return LinkedList.this.get(cursor++);
      }
    };
  }

  // static nested class 활용 예
  // => 특정 클래스 안에서만 사용되는 클래스일 때 
  // => 바깥 클래스의 인스턴스 멤버를 사용하지 않을 때 
  private static class Node {
    Node prev;
    Object value; // 어떤 객체의 주소도 받을 수 있도록 Object로 설정 
    Node next;

    public Node(Object value) {
      this.value = value;
    }
  }

  //  // Non-Static Nested Class(= inner class) 활용 예 
  //  // => 특정 클래스의 안에서만 사용될 때
  //  // => 바깥 클래스의 인스턴스 멤버를 사용할 떄 
  //  private class ListIterator implements Iterator{
  //    //이터레이터는 컬렉션의 값을 조회하는 일을 한다. 
  //    //컬렉션의 종류(리스트, 스택, 큐)에 따라 데이터를 꺼내는 방법이 다르다. 
  //    //데이터를 꺼내는 일을 별도의 객체에게 맡긴다. 
  //
  //    int cursor;
  //
  //    @Override
  //    public boolean hasNext() {
  //      return cursor < LinkedList.this.size();
  //    }
  //
  //    @Override
  //    public Object next() {
  //      return LinkedList.this.get(cursor++);
  //    }
  //  }

}
