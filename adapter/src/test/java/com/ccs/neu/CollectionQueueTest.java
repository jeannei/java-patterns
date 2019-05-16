package com.ccs.neu;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Collection queue test.
 */
public class CollectionQueueTest {

    /**
     * Test peek empty queue
     */
    @Test
    public void testPeekEmptyQueue() {
        Queue<Collection> queue = new QueueAdapter<>();
        assertNull(queue.peek());
    }

    /**
     * Test peek with null
     */
    @Test
    public void testPeekWithNull() {
        Queue<Collection> queue = new QueueAdapter<>();
        queue.add(null);
        assertNull(queue.peek());
    }

    /**
     * Test remove with queue
     */
    @Test
    public void testRemoveWithNull() {
        Queue<Collection> queue = new QueueAdapter<>();
        queue.add(null);
        assertNull(queue.remove());
    }

    /**
     * Test remove empty queue
     */
    @Test
    public void testRemoveEmptyQueue() {
        Queue<Collection> queue = new QueueAdapter<>();
        assertNull(queue.remove());
    }

    /**
     * Test peek with non empty queue
     */
    @Test
    public void testPeekWithNonEmptyQueue() {
        Queue<Collection> queue = new QueueAdapter<>();
        List<String> collection1 = new ArrayList<>();
        List<Integer> collection2 = new ArrayList<>();
        collection1.add("key");
        collection1.add("key2");
        collection2.add(1);
        collection2.add(3);
        queue.add(collection1);
        queue.add(collection2);

        assertEquals(collection1, queue.peek());
    }

    /**
     * Test peek doesn't remove element
     */
    @Test
    public void testPeekDoesNotRemove() {
        Queue<Collection> queue = new QueueAdapter<>();
        List<String> collection1 = new ArrayList<>();
        List<Integer> collection2 = new ArrayList<>();
        collection1.add("key");
        collection1.add("key2");
        collection2.add(1);
        collection2.add(3);
        queue.add(collection1);
        queue.add(collection2);

        assertEquals(collection1, queue.peek());
        assertEquals(collection1, queue.peek());
    }

    /**
     * Test remove with non empty queue
     */
    @Test
    public void testRemoveWithNonEmptyQueue() {
        Queue<Collection> queue = new QueueAdapter<>();
        List<String> collection1 = new ArrayList<>();
        List<Integer> collection2 = new ArrayList<>();
        collection1.add("key");
        collection1.add("key2");
        collection2.add(1);
        collection2.add(3);
        queue.add(collection1);
        queue.add(collection2);

        assertEquals(collection1, queue.remove());
        assertEquals(collection2, queue.peek());
    }

    /**
     * Test remove all elements
     */
    @Test
    public void testRemoveAllElements() {
        Queue<Collection> queue = new QueueAdapter<>();
        List<String> collection1 = new ArrayList<>();
        List<Integer> collection2 = new ArrayList<>();
        collection1.add("key");
        collection1.add("key2");
        collection2.add(1);
        collection2.add(3);
        queue.add(collection1);
        queue.add(collection2);

        assertEquals(collection1, queue.remove());
        assertEquals(collection2, queue.remove());
        assertNull(queue.remove());
    }
}
