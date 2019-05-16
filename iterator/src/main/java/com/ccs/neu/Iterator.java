package com.ccs.neu;

/**
 * The interface Iterator.
 */
public interface Iterator<T> {

    /**
     * Check if there are more elements
     *
     * @return the boolean
     */
    boolean hasAnotherElement();

    /**
     * Return the next element
     *
     * @return the t
     */
    T nextElement();
}
