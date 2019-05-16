package com.ccs.neu;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Bit vector with iterator not implemented
 */
public class BitVectorNoIterator extends AbstractBitVector {

    /**
     * Instantiates a new Bit vector.
     */
    public BitVectorNoIterator() {
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

        List<Integer> values = getNumericalValues();
        for (Integer integer : values) {
            b.set(integer);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Integer> iterator() {
        throw new UnsupportedOperationException("Iterator is not supported");
    }

    /**
     * Returns a list of all values that are set in this bitvector
     *
     * @return list
     */
    private List<Integer> getNumericalValues() {
        List<Integer> results = new ArrayList<>();
        int[] bitsCopy = copyBitVector();
        int currentIndex = 0;

        while (currentIndex < bitsCopy.length) {
            if (bitsCopy[currentIndex] == 0) {
                currentIndex += 1;
                continue;
            }

            int currentValue = bitsCopy[currentIndex];
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
            bitsCopy[currentIndex] = currentValue ^ (1 << result) - padding;
            results.add(result);
        }

        return results;
    }

    /**
     * Make a copyBitVector of this bitvector for manipulation
     *
     * @return int[]
     */
    private int[] copyBitVector() {
        int[] result = new int[bits.size()];
        for (int i = 0; i < bits.size(); i++) {
            result[i] = bits.get(i);
        }

        return result;
    }
}
