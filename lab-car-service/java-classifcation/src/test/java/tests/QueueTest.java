package test.java.tests;


import main.java.oop.practice.cars.dining.*;
import main.java.oop.practice.cars.refueling.*;
import main.java.oop.practice.cars.model.*;
import main.java.oop.practice.queue.*;
import main.java.oop.practice.station.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    void testQueueOperations() {
        Queue<Integer> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(3, queue.dequeue());

        assertTrue(queue.isEmpty());
    }
}