package queue;

public interface Queue<T> {
    void enqueue(T element); // Adds an element to the queue
    T dequeue();             // Removes and returns the front element from the queue
    boolean isEmpty();       // Checks if the queue is empty
    int size();              // Returns the number of elements in the queue
}