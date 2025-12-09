package queue;

import java.util.ArrayList;

public class DynamicListQueue<T> implements Queue<T> {
    private ArrayList<T> list;

    public DynamicListQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(T element) {
        list.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0); // Removes and returns the first element
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}