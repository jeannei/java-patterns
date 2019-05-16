package com.ccs.neu;

import java.util.ArrayList;

/**
 * The type Queue adapter.
 *
 * @param <T> the type parameter
 */
public class QueueAdapter<T> implements Queue<T> {

    private static final int QUEUE_HEAD_INDEX = 0;
    private ArrayList<T> queue;

    /**
     * Instantiates a new Queue adapter.
     */
    public QueueAdapter() {
        this.queue = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(T t) {
        return queue.add(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.remove(QUEUE_HEAD_INDEX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peek() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.get(QUEUE_HEAD_INDEX);
    }
}
