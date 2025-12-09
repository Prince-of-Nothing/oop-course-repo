package queuetest;

import queue.*;

public class QueueTest {
    public static void main(String[] args) {
        testQueue(new ArrayQueue<>());
        testQueue(new LinkedListQueue<>());
        testQueue(new DynamicListQueue<>());
    }

    public static void testQueue(Queue<Integer> queue) {
        System.out.println("Testing " + queue.getClass().getSimpleName());

        // Test enqueue and dequeue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued: " + queue.dequeue()); // Should print 1
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 2

        // Test size
        System.out.println("Queue size: " + queue.size()); // Should print 1

        // Test dequeue the last item
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 3
        System.out.println("Queue empty: " + queue.isEmpty()); // Should print true
    }
}