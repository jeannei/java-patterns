package com.ccs.neu;

import com.ccs.neu.observers.HexObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * The type HexObserverTest test.
 */
public class HexObserverTest {
    private ByteArrayOutputStream outContent = TestUtils.getByteArrayOutputStream();
    private PrintStream originalOut = TestUtils.getSystemOutPrintStream();

    /**
     * Sets up streams.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restore streams.
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Test null input
     */
    @Test
    public void testNullInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue(null);
        assertEquals(TestUtils.stringWithNewLine(""), outContent.toString());
    }

    /**
     * Test empty string input
     */
    @Test
    public void testEmptyStringInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("");
        assertEquals(TestUtils.stringWithNewLine(""), outContent.toString());
    }

    /**
     * Test string with one space
     */
    @Test
    public void testStringWithOneSpace() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue(" ");
        assertEquals(TestUtils.stringWithNewLine("20"), outContent.toString());
    }

    /**
     * Test string with multiple spaces
     */
    @Test
    public void testStringWithMultipleSpace() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("   ");
        assertEquals(TestUtils.stringWithNewLine("20 20 20"), outContent.toString());
    }

    /**
     * Test basic happy path for acii observer
     */
    @Test
    public void testExampleInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("Design Patterns - Hoorah");
        String expected = TestUtils.stringWithNewLine("44 65 73 69 67 6e 20 50 61 74 74 65 72 6e 73 20 2d 20 48 6f 6f 72 61 68");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with only special characters
     */
    @Test
    public void testStringWithOnlySpecialCharacters() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("~`!@#$%^&*()-+=[{]}\\|;:\"<>./?\'");
        String expected = TestUtils.stringWithNewLine("7e 60 21 40 23 24 25 5e 26 2a 28 29 2d 2b 3d 5b 7b 5d 7d 5c 7c 3b 3a 22 3c 3e 2e 2f 3f 27");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with only numbers
     */
    @Test
    public void testStringWithOnlyNumbers() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("0123456789");
        String expected = TestUtils.stringWithNewLine("30 31 32 33 34 35 36 37 38 39");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with special characters and numbers
     */
    @Test
    public void testStringWithSpecialCharsAndNumbers() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("Design P@tterns - H00rah");
        String expected = TestUtils.stringWithNewLine("44 65 73 69 67 6e 20 50 40 74 74 65 72 6e 73 20 2d 20 48 30 30 72 61 68");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test alphabet lowercase
     */
    @Test
    public void testAlphabetLowerCase() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("abcdefghijklmnopqrstuvwxyz");
        String expected = TestUtils.stringWithNewLine("61 62 63 64 65 66 67 68 69 6a 6b 6c 6d 6e 6f 70 71 72 73 74 75 76 77 78 79 7a");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test alphabet uppercase
     */
    @Test
    public void testAlphabetUpperCase() {
        ConcreteSubject subject = new ConcreteSubject();
        new HexObserver(subject);
        subject.setValue("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String expected = TestUtils.stringWithNewLine("41 42 43 44 45 46 47 48 49 4a 4b 4c 4d 4e 4f 50 51 52 53 54 55 56 57 58 59 5a");
        assertEquals(expected, outContent.toString());
    }
}
