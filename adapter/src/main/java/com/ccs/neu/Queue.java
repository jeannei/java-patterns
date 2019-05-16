package com.ccs.neu;

/**
 * A generic queue
 *
 * @param <T> the type parameter
 */
public interface Queue<T> {

    /**
     * add an element to the head of the queue
     *
     * @param t the t
     * @return the boolean
     */
    boolean add(T t);

    /**
     * remove an element from the end of the queue. Returns null if queue is empty
     *
     * @return the t
     */
    T remove();

    /**
     * returns the head of the queue. Returns null if queue is empty
     *
     * @return the t
     */
    T peek();
}
