package com.ccs.neu;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Bit vector with iterator implemented
 */
public class BitVector extends AbstractBitVector {

    /**
     * Instantiates a new Bit vector.
     */
    public BitVector() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void copy(IBitVector b) {
        if (b == null) {
            return;
        }

        Iterator<Integer> iterator = iterator();
        while (iterator.hasAnotherElement()) {
            b.set(iterator.nextElement());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    /**
     * Iterator implementation
     */
    private class Itr implements Iterator<Integer> {
        private int currentIndex;
        private int totalSize;
        private int[] bits;

        private Itr() {
            this.currentIndex = 0;
            this.totalSize = getTotalSize();
            this.bits = copy();
            // get the next index with a non zero binary literal
            incrementCurrentIndex();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasAnotherElement() {
            return currentIndex < totalSize;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Integer nextElement() {
            if (currentIndex >= totalSize) {
                throw new NoSuchElementException("No more elements exist");
            }

            int currentValue = bits[currentIndex];
            int lowestValue = currentValue & -currentValue;
            int bitPosition = (int) (Math.log(lowestValue) / Math.log(2));
            int padding = 0;

            // 2^31 is -2147483648, which is bigger than what an int can hold so we need ~(negate) it
            // and grab the next highest bit
            if (lowestValue < 0) {
                padding = 1;
                currentValue = ~currentValue;
                int highestValue = Integer.highestOneBit(currentValue);
                bitPosition = (int) (Math.log(highestValue) / Math.log(2)) + padding;
            }

            int result = bitPosition + currentIndex * DEFAULT_BIT_SIZE;
            bits[currentIndex] = currentValue ^ (1 << result) - padding;
            incrementCurrentIndex();

            return result;
        }

        /**
         * Make a copy of this bitvector for manipulation
         *
         * @return int[]
         */
        private int[] copy() {
            int[] result = new int[getTotalSize()];
            List<Integer> integers = getBits();
            for (int i = 0; i < getTotalSize(); i++) {
                result[i] = integers.get(i);
            }

            return result;
        }

        /**
         * Returns a reference for bits
         *
         * @return List
         */
        private List<Integer> getBits() {
            return BitVector.this.bits;
        }

        /**
         * Returns the size of the list
         *
         * @return int
         */
        private int getTotalSize() {
            return getBits().size();
        }

        /**
         * Increment the current index
         *
         * @return
         */
        private void incrementCurrentIndex() {
            while (currentIndex < totalSize && bits[currentIndex] == 0) {
                currentIndex += 1;
            }
        }
    }
}
