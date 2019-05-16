package com.ccs.neu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * The type Bit vector test.
 */
public class BitVectorTest {

    /**
     * Test empty bitvector
     */
    @Test
    public void testSizeEmptyBitVector() {
        IBitVector bitVector = new BitVector();
        assertEquals(0, bitVector.size());
        assertFalse(bitVector.get(0));
    }

    /**
     * Test empty bitvector with clear
     */
    @Test
    public void testEmptyClearBitVector() {
        IBitVector bitVector = new BitVector();
        bitVector.clear(10);
        assertEquals(0, bitVector.size());
        assertFalse(bitVector.get(10));
    }

    /**
     * Test bitvector input with one set
     */
    @Test
    public void testOneBitVector() {
        IBitVector bitVector = new BitVector();
        bitVector.set(4);

        assertEquals(1, bitVector.size());
        assertTrue(bitVector.get(4));
    }

    /**
     * Test set at the same position
     */
    @Test
    public void testOneBitVectorSetMultipleTimes() {
        IBitVector bitVector = new BitVector();
        bitVector.set(4);
        bitVector.set(4);

        assertEquals(1, bitVector.size());
        assertTrue(bitVector.get(4));
    }

    /**
     * Test bitvector input spread across, crossing binary literal boundary
     */
    @Test
    public void testThreeBitVectorSpread() {
        IBitVector bitVector = new BitVector();
        bitVector.set(30);
        bitVector.set(31);
        bitVector.set(32);

        assertEquals(3, bitVector.size());
        assertTrue(bitVector.get(30));
        assertTrue(bitVector.get(31));
        assertTrue(bitVector.get(32));
    }

    /**
     * Test bitvector boundary
     */
    @Test
    public void testBitVectorBoundary() {
        IBitVector bitVector = new BitVector();
        bitVector.set(Integer.MAX_VALUE);

        assertEquals(1, bitVector.size());
        assertTrue(bitVector.get(Integer.MAX_VALUE));
    }

    /**
     * Test bitvector boundary minus 1
     */
    @Test
    public void testBitVectorBoundaryMinus1() {
        IBitVector bitVector = new BitVector();
        bitVector.set(Integer.MAX_VALUE - 1);

        assertEquals(1, bitVector.size());
        assertTrue(bitVector.get(Integer.MAX_VALUE - 1));
    }

    /**
     * Test example bit vector
     */
    @Test
    public void testProvidedExampleBitVector() {
        IBitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        bitVector.set(7);
        bitVector.set(31);

        assertEquals(5, bitVector.size());
        assertTrue(bitVector.get(0));
        assertTrue(bitVector.get(1));
        assertTrue(bitVector.get(4));
        assertTrue(bitVector.get(7));
        assertTrue(bitVector.get(31));

    }

    /**
     * Test clear bit vector
     */
    @Test
    public void testClearBitVector() {
        IBitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        bitVector.set(7);
        bitVector.set(31);

        bitVector.clear(31);
        bitVector.clear(0);

        assertEquals(3, bitVector.size());
        assertTrue(bitVector.get(1));
        assertTrue(bitVector.get(4));
        assertTrue(bitVector.get(7));
        assertFalse(bitVector.get(0));
        assertFalse(bitVector.get(31));
    }

    /**
     * Test clear bit vector at the same position
     */
    @Test
    public void testClearBitVectorMultipleTimes() {
        IBitVector bitVector = new BitVector();
        bitVector.set(0);
        bitVector.set(31);

        bitVector.clear(0);
        bitVector.clear(0);

        assertEquals(1, bitVector.size());
        assertTrue(bitVector.get(31));
        assertFalse(bitVector.get(0));
    }

    /**
     * Test copy with null bit vector
     */
    @Test
    public void testCopyWithNullBitVector() {
        IBitVector bitVector = new BitVector();
        IBitVector bitVector2 = null;
        bitVector.set(0);
        bitVector.set(10);
        bitVector.copy(bitVector2);
        assertNull(bitVector2);


    }
    /**
     * Test copy with empty bit vector
     */
    @Test
    public void testCopyWithEmptyBitVector() {
        IBitVector bitVector = new BitVector();
        IBitVector bitVector2 = new BitVector();
        bitVector.set(0);
        bitVector.set(1);
        bitVector.set(4);
        bitVector.set(7);
        bitVector.set(31);
        bitVector.copy(bitVector2);

        assertEquals(bitVector.size(), bitVector2.size());
        // bitvector should remain unchanged
        assertTrue(bitVector.get(0));
        assertTrue(bitVector.get(1));
        assertTrue(bitVector.get(4));
        assertTrue(bitVector.get(7));
        assertTrue(bitVector.get(31));

        // bitvector2 should now match bitvector
        assertTrue(bitVector2.get(0));
        assertTrue(bitVector2.get(1));
        assertTrue(bitVector2.get(4));
        assertTrue(bitVector2.get(7));
        assertTrue(bitVector2.get(31));
    }

    /**
     * Test copy with empty bit vector, multiple boundaries
     */
    @Test
    public void testCopyWithEmptyBitVectorSpread() {
        IBitVector bitVector = new BitVector();
        IBitVector bitVector2 = new BitVector();
        bitVector.set(31);
        bitVector.set(63);
        bitVector.set(95);
        bitVector.set(127);
        bitVector.set(150);
        bitVector.copy(bitVector2);

        assertEquals(bitVector.size(), bitVector2.size());
        // bitvector should remain unchanged
        assertTrue(bitVector.get(31));
        assertTrue(bitVector.get(63));
        assertTrue(bitVector.get(95));
        assertTrue(bitVector.get(127));
        assertTrue(bitVector.get(150));

        // bitvector2 should now match bitvector
        assertTrue(bitVector2.get(31));
        assertTrue(bitVector2.get(63));
        assertTrue(bitVector2.get(95));
        assertTrue(bitVector2.get(127));
        assertTrue(bitVector2.get(150));
    }

    /**
     * Test copy with non empty bit vector, multiple boundaries
     */
    @Test
    public void testCopyNonEmptyBitVector() {
        IBitVector bitVector = new BitVector();
        IBitVector bitVector2 = new BitVector();
        bitVector.set(31);
        bitVector.set(63);
        bitVector.set(95);
        bitVector.set(127);
        bitVector.set(150);

        bitVector2.set(0);
        bitVector2.set(7);
        bitVector2.set(63);
        bitVector2.set(1000);

        bitVector.copy(bitVector2);

        // the bit vectors should not match in size
        assertNotEquals(bitVector.size(), bitVector2.size());

        // bitvector should remain unchanged
        assertEquals(5, bitVector.size());
        assertTrue(bitVector.get(31));
        assertTrue(bitVector.get(63));
        assertTrue(bitVector.get(95));
        assertTrue(bitVector.get(127));
        assertTrue(bitVector.get(150));

        // bitvector2 should now match bitvector and still have its own values
        assertEquals(8, bitVector2.size());
        assertTrue(bitVector2.get(0));
        assertTrue(bitVector2.get(7));
        assertTrue(bitVector2.get(31));
        assertTrue(bitVector2.get(63));
        assertTrue(bitVector2.get(95));
        assertTrue(bitVector2.get(127));
        assertTrue(bitVector2.get(150));
        assertTrue(bitVector2.get(1000));
    }

    /**
     * Test iterator with empty vector
     */
    @Test
    public void testIteratorWithEmptyVector() {
        IBitVector bitVector = new BitVector();
        assertFalse(bitVector.iterator().hasAnotherElement());
    }

    /**
     * Test iterator with non empty vector
     */
    @Test
    public void testIteratorWithNonEmptyVector() {
        IBitVector bitVector = new BitVector();
        List<Integer> integers = new ArrayList<>();
        bitVector.set(0);
        bitVector.set(31);
        bitVector.set(63);
        bitVector.set(1000);
        bitVector.set(65000);
        bitVector.set(Integer.MAX_VALUE);

        Iterator<Integer> iterator = bitVector.iterator();
        while (iterator.hasAnotherElement()) {
            integers.add(iterator.nextElement());
        }

        assertEquals(Arrays.asList(0, 31, 63, 1000, 65000, Integer.MAX_VALUE), integers);
    }

    /**
     * Test iterator while unsetting binary literal at the start and end
     */
    @Test
    public void testIteratorWithGaps() {
        IBitVector bitVector = new BitVector();
        List<Integer> integers = new ArrayList<>();
        bitVector.set(33);
        bitVector.set(500);
        bitVector.set(5000);

        bitVector.clear(33);
        bitVector.clear(5000);

        Iterator<Integer> iterator = bitVector.iterator();
        while (iterator.hasAnotherElement()) {
            integers.add(iterator.nextElement());
        }

        assertEquals(Arrays.asList(500), integers);
    }

    /**
     * After calling iterator, and modifications should not impact the iterator
     */
    @Test
    public void testIteratorAndModifyBitVector() {
        IBitVector bitVector = new BitVector();
        List<Integer> integers = new ArrayList<>();
        bitVector.set(3);
        bitVector.set(500);

        Iterator<Integer> iterator = bitVector.iterator();
        while (iterator.hasAnotherElement()) {
            integers.add(iterator.nextElement());
        }

        bitVector.set(10);

        assertEquals(3, bitVector.size());
        assertEquals(Arrays.asList(3, 500), integers);
    }

    /**
     * Test invalid set, using negative number
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSet() {
        IBitVector bitVector = new BitVector();
        bitVector.set(-1);
    }

    /**
     * Test invalid set, using negative max number
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSet2() {
        IBitVector bitVector = new BitVector();
        bitVector.set(Integer.MIN_VALUE);
    }

    /**
     * Test invalid set, using negative max number
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSet3() {
        IBitVector bitVector = new BitVector();
        bitVector.set(Integer.MAX_VALUE + 1);
    }

    /**
     * Test get next element with empty iterator
     */
    @Test(expected = NoSuchElementException.class)
    public void testInvalidIteratorAccess() {
        IBitVector bitVector = new BitVector();
        bitVector.iterator().nextElement();
    }

    /**
     * Test get next element with empty iterator
     */
    @Test(expected = NoSuchElementException.class)
    public void testInvalidIteratorAccess2() {
        IBitVector bitVector = new BitVector();
        Iterator<Integer> iterator = bitVector.iterator();
        bitVector.set(1);
        bitVector.set(3);

        iterator.nextElement();
        iterator.nextElement();
        iterator.nextElement();
    }
}
