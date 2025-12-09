package queue.src.queue;

import model.Car;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size(); // Add the size method
}