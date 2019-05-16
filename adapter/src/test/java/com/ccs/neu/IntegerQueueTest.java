package com.ccs.neu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Integer queue test.
 */
public class IntegerQueueTest {

    /**
     * Test peek empty queue
     */
    @Test
    public void testPeekEmptyQueue() {
        Queue<Integer> queue = new QueueAdapter<>();
        assertNull(queue.peek());
    }

    /**
     * Test peek with null
     */
    @Test
    public void testPeekWithNull() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(null);
        assertNull(queue.peek());
    }

    /**
     * Test remove with queue
     */
    @Test
    public void testRemoveWithNull() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(null);
        assertNull(queue.remove());
    }

    /**
     * Test remove empty queue
     */
    @Test
    public void testRemoveEmptyQueue() {
        Queue<Integer> queue = new QueueAdapter<>();
        assertNull(queue.remove());
    }

    /**
     * Test peek with non empty queue
     */
    @Test
    public void testPeekWithNonEmptyQueue() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);

        assertEquals(createInteger(0), queue.peek());
    }

    /**
     * Test peek doesn't remove element
     */
    @Test
    public void testPeekDoesNotRemove() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);

        assertEquals(createInteger(0), queue.peek());
        assertEquals(createInteger(0), queue.peek());
    }

    /**
     * Test remove with non empty queue
     */
    @Test
    public void testRemoveWithNonEmptyQueue() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);

        assertEquals(createInteger(0), queue.remove());
        assertEquals(createInteger(1), queue.peek());
    }

    /**
     * Test remove all elements
     */
    @Test
    public void testRemoveAllElements() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(0);
        queue.add(-1);
        queue.add(2);

        assertEquals(createInteger(0), queue.remove());
        assertEquals(createInteger(-1), queue.remove());
        assertEquals(createInteger(2), queue.remove());
        assertNull(queue.remove());
    }

    /**
     * Test remove all elements
     */
    @Test
    public void testRemoveAllElements2() {
        Queue<Integer> queue = new QueueAdapter<>();
        queue.add(Integer.MIN_VALUE);
        queue.add(Integer.MAX_VALUE);
        queue.add(-1);
        queue.add(1);
        queue.add(Integer.MAX_VALUE + 1);
        queue.add(Integer.MIN_VALUE - 1);

        assertEquals(createInteger(Integer.MIN_VALUE), queue.remove());
        assertEquals(createInteger(Integer.MAX_VALUE), queue.remove());
        assertEquals(createInteger(-1), queue.remove());
        assertEquals(createInteger(1), queue.remove());
        assertEquals(createInteger(Integer.MAX_VALUE + 1), queue.remove());
        assertEquals(createInteger(Integer.MIN_VALUE - 1), queue.remove());
        assertNull(queue.remove());
    }

    /**
     * junit needs the objects to match so we create a convenience method to create integer
     */
    private Integer createInteger(int i) {
        return Integer.valueOf(i);
    }
}
