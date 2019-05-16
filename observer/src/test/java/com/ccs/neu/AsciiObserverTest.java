package com.ccs.neu;

import com.ccs.neu.observers.AsciiObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * The type AsciiObserverTest test.
 */
public class AsciiObserverTest {
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
        new AsciiObserver(subject);
        subject.setValue(null);
        assertEquals(TestUtils.stringWithNewLine(""), outContent.toString());
    }

    /**
     * Test empty string input
     */
    @Test
    public void testEmptyStringInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("");
        assertEquals(TestUtils.stringWithNewLine(""), outContent.toString());
    }

    /**
     * Test string with one space
     */
    @Test
    public void testStringWithOneSpace() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue(" ");
        assertEquals(TestUtils.stringWithNewLine("32"), outContent.toString());
    }

    /**
     * Test string with multiple spaces
     */
    @Test
    public void testStringWithMultipleSpace() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("   ");
        assertEquals(TestUtils.stringWithNewLine("32 32 32"), outContent.toString());
    }

    /**
     * Test basic happy path for acii observer
     */
    @Test
    public void testExampleInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("Design Patterns - Hoorah");
        String expected = TestUtils.stringWithNewLine("68 101 115 105 103 110 32 80 97 116 116 101 114 110 115 32 45 32 72 111 111 114 97 104");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with only special characters
     */
    @Test
    public void testStringWithOnlySpecialCharacters() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("~`!@#$%^&*()-+=[{]}\\|;:\"<>./?\'");
        String expected = TestUtils.stringWithNewLine("126 96 33 64 35 36 37 94 38 42 40 41 45 43 61 91 123 93 125 92 124 59 58 34 60 62 46 47 63 39");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with only numbers
     */
    @Test
    public void testStringWithOnlyNumbers() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("0123456789");
        String expected = TestUtils.stringWithNewLine("48 49 50 51 52 53 54 55 56 57");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with special characters and numbers
     */
    @Test
    public void testStringWithSpecialCharsAndNumbers() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("Design P@tterns - H00rah");
        String expected = TestUtils.stringWithNewLine("68 101 115 105 103 110 32 80 64 116 116 101 114 110 115 32 45 32 72 48 48 114 97 104");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test alphabet lowercase
     */
    @Test
    public void testAlphabetLowerCase() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("abcdefghijklmnopqrstuvwxyz");
        String expected = TestUtils.stringWithNewLine("97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test alphabet uppercase
     */
    @Test
    public void testAlphabetUpperCase() {
        ConcreteSubject subject = new ConcreteSubject();
        new AsciiObserver(subject);
        subject.setValue("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String expected = TestUtils.stringWithNewLine("65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90");
        assertEquals(expected, outContent.toString());
    }
}
