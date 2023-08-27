package baekjoon.deque;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64;// 최소(기본) 용적 크기

    private Object[] array; // 요소를 담을 배열
    private int size; // 요소 개수

    private int front; // 시작 인덱스를 가리키는 변수 (빈 공간임을 유의)
    private int rear; // 마지막 요소의 인덱스를 가리키는 변수

    // 생성자1 (초기 용적 할당을 안할 경우)
    public ArrayDeque(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    // 생성자2 (초기 용적 할당을 할 경우)
    public ArrayDeque(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    // 동적 할당을 위한 resize 메서드
    private void resize(int newCapaticy){
        int arrayCapacity = array.length; // 현재 용적 크기

        Object[] newArray = new Object[newCapaticy];// 용적을 변경한 배열

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }

        array = null;
        array = newArray; // 새 배열을 기존 array의 배열로 덮어씌움.

        front = 0;
        rear = size;
    }
    @Override
    public boolean offer(E item){
        return offerLast(item);
    }
    public boolean offerLast(E item){
        // 용적이 찼을 경우
        if((rear +1) % array.length == front ){
            resize(array.length * 2);
        }
        rear = (rear + 1) % array.length; // rear을 rear의 다음 위치로 갱신

        array[rear] = item;
        size ++;

        return true;
    }

    public boolean offerFirst(E item){
        // 용적이 가득 찼을 경우
        if((front -1 + array.length)% array.length == rear){
            resize(array.length * 2);
        }
        array[front] = item;
        front = (front -1 + array.length)%array.length;
        size ++;
        return true;
    }

    @Override
    public E poll(){
        return pollFirst();
    }
    public E pollFirst(){
        if(size == 0){ // 요소가 없을 때 null 반환
            return null;
        }

        front = (front + 1) % array.length; // front 한칸 옮기기

        @SuppressWarnings("unchecked")
        E item  = (E) array[front]; // 변한할 데이터 임시저장

        array[front] = null; // 해당 front 의 데이터 삭제

        // 용적이 최소 크기(64)보다 크고 요소 개수가 1/4미만일 경우
        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)){
            // 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다.
            resize(Math.max(DEFAULT_CAPACITY,array.length / 2));
        }
        return item;
    }
    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[(front + 1) % array.length];
        return item;
    }
    public E remove() {
        return removeFirst();	// 예외는 removeFirst()에서 던져준다.
    }

    public E removeFirst() {
        E item = pollFirst();	// pollFirst()을 호출한다.

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }
    public E pollLast() {
        if(size == 0) {	// 삭제할 요소가 없을 경우 null 반환
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[rear];	// 반환할 데이터 임시 저장

        array[rear] = null;	// 해당 rear의 데이터 삭제

        rear = (rear - 1 + array.length) % array.length; // rear 를 한 칸 옮긴다.
        size--;	// 사이즈 감소


        // 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

            // 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다.
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E removeLast() {
        E item = pollLast();

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

}
