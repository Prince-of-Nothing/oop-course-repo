package queue;

import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        array = (T[]) new Object[10]; // initial capacity
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == array.length) {
            resize();
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = array[front];
        front = (front + 1) % array.length;
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

    private void resize() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }
}