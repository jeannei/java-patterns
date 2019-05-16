package com.ccs.neu;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBitVector implements IBitVector {
    protected static final Integer DEFAULT_BIT_SIZE = 32;
    protected static final int INIT = 0;
    protected int size = 0;
    protected List<Integer> bits;

    /**
     * Instantiates a new Bit vector.
     */
    public AbstractBitVector() {
        this.bits = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean get(int i) {
        validateNaturalNumber(i);
        int index = getIndex(i);
        if (isIndexNotAvailable(index)) {
            return false;
        }

        int currentValue = bits.get(index);
        return (currentValue & (1 << getPosition(i))) != 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void set(int i) {
        if (get(i)) {
            return;
        }

        int index = getIndex(i);
        while (isIndexNotAvailable(index)) {
            bits.add(INIT);
        }

        int currentValue = bits.get(index);
        int newValue = currentValue | (1 << getPosition(i));

        bits.set(index, newValue);
        size += 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear(int i) {
        if (get(i)) {
            int index = getIndex(i);
            int currentValue = bits.get(index);
            int newValue = currentValue ^ (1 << getPosition(i));

            bits.set(index, newValue);
            size -= 1;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Get the appropriate index for placing i
     *
     * @param i int
     * @return int
     */
    private int getIndex(int i) {
        return i / DEFAULT_BIT_SIZE;
    }

    /**
     * Get the appropriate position for placing in the binary literal
     *
     * @param i int
     * @return int
     */
    private int getPosition(int i) {
        return i % DEFAULT_BIT_SIZE;
    }

    /**
     * Validates that we are dealing positive integers
     *
     * @param i int
     */
    private void validateNaturalNumber(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Must be natural number.");
        }
    }

    /**
     * Determines if index is available in the array
     *
     * @param index int
     * @return boolean
     */
    private boolean isIndexNotAvailable(int index) {
        return bits.isEmpty() || bits.size() <= index;
    }

}
