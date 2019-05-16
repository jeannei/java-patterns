package com.ccs.neu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type String queue test.
 */
public class StringQueueTest {
    private static final String FIRST = "first";
    private static final String SECOND = "second";
    private static final String THIRD = "third";
    /**
     * Test peek empty queue
     */
    @Test
    public void testPeekEmptyQueue() {
        Queue<String> queue = new QueueAdapter<>();
        assertNull(queue.peek());
    }

    /**
     * Test peek with null
     */
    @Test
    public void testPeekWithNull() {
        Queue<String> queue = new QueueAdapter<>();
        queue.add(null);
        assertNull(queue.peek());
    }

    /**
     * Test remove with queue
     */
    @Test
    public void testRemoveWithNull() {
        Queue<String> queue = new QueueAdapter<>();
        queue.add(null);
        assertNull(queue.remove());
    }

    /**
     * Test remove empty queue
     */
    @Test
    public void testRemoveEmptyQueue() {
        Queue<String> queue = new QueueAdapter<>();
        assertNull(queue.remove());
    }

    /**
     * Test peek with non empty queue
     */
    @Test
    public void testPeekWithNonEmptyQueue() {
        Queue<String> queue = new QueueAdapter<>();
        queue.add(FIRST);
        queue.add(SECOND);
        queue.add(THIRD);

        assertEquals(FIRST, queue.peek());
    }

    /**
     * Test peek doesn't remove element
     */
    @Test
    public void testPeekDoesNotRemove() {
        Queue<String> queue = new QueueAdapter<>();
        queue.add(FIRST);
        queue.add(SECOND);
        queue.add(THIRD);

        assertEquals(FIRST, queue.peek());
        assertEquals(FIRST, queue.peek());
    }

    /**
     * Test remove with non empty queue
     */
    @Test
    public void testRemoveWithNonEmptyQueue() {
        QueueAdapter<String> queue = new QueueAdapter<>();
        queue.add(FIRST);
        queue.add(SECOND);
        queue.add(THIRD);

        assertEquals(FIRST, queue.remove());
        assertEquals(SECOND, queue.peek());

    }

    /**
     * Test remove all elements
     */
    @Test
    public void testRemoveAllElements() {
        Queue<String> queue = new QueueAdapter<>();
        queue.add(FIRST);
        queue.add(SECOND);
        queue.add(THIRD);

        assertEquals(FIRST, queue.remove());
        assertEquals(SECOND, queue.remove());
        assertEquals(THIRD, queue.remove());
        assertNull(queue.remove());
    }
}
