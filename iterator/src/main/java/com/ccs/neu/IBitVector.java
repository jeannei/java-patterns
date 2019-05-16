package com.ccs.neu;

/**
 * The interface Bit vector.
 */
public interface IBitVector {

    /**
     * Determine if the bit at position i is set.
     *
     * @param i the
     * @return the boolean
     */
    boolean get(int i);

    /**
     * Set the bit at position i.
     *
     * @param i the
     */
    void set(int i);

    /**
     * Clear the bit at position i.
     *
     * @param i the
     */
    void clear(int i);

    /**
     * Set the bits in the argument BitVector b.
     *
     * @param b the b
     */
    void copy(IBitVector b);

    /**
     * Determine the number of non-zero bits in the BitVector.
     *
     * @return the int
     */
    int size();

    /**
     * Iterator over the Integer values represented by this BitVector.
     *
     * @return the iterator
     */
    Iterator<Integer> iterator();
}
