package main.java.oop.practice.queue;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private static class Node<T> {
        private final T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;

    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = head.getData();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {return head == null;}

    @Override
    public int size() {return size;}
}