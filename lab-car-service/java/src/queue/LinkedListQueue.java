package queue;

public class LinkedListQueue<T> implements Queue<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        front = rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = front.data;
        front = front.next;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}