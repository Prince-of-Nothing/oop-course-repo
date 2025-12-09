package queue.src.queue;

import java.util.ArrayList;

public class ArrayQueue<T> implements Queue<T> {
    private ArrayList<T> queue;

    public ArrayQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public void enqueue(T item) {
        queue.add(item);
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            return queue.remove(0);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size(); // Return the size of the underlying list
    }
}