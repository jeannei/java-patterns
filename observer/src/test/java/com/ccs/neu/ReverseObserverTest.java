package com.ccs.neu;

import com.ccs.neu.observers.ReverseObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * The type ReverseObserverTest test.
 */
public class ReverseObserverTest {
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
        new ReverseObserver(subject);
        subject.setValue(null);
        assertEquals(TestUtils.stringWithNewLine(""), outContent.toString());
    }

    /**
     * Test empty string input
     */
    @Test
    public void testEmptyStringInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("");
        assertEquals(TestUtils.stringWithNewLine(""), outContent.toString());
    }

    /**
     * Test string with one space
     */
    @Test
    public void testStringWithOneSpace() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue(" ");
        assertEquals(TestUtils.stringWithNewLine(" "), outContent.toString());
    }

    /**
     * Test string with multiple spaces
     */
    @Test
    public void testStringWithMultipleSpace() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("   ");
        assertEquals(TestUtils.stringWithNewLine("   "), outContent.toString());
    }

    /**
     * Test basic happy path for acii observer
     */
    @Test
    public void testExampleInput() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("Design Patterns - Hoorah");
        String expected = TestUtils.stringWithNewLine("harooH - snrettaP ngiseD");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with only special characters
     */
    @Test
    public void testStringWithOnlySpecialCharacters() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("~`!@#$%^&*()-+=[{]}\\|;:\"<>./?\'");
        String expected = TestUtils.stringWithNewLine("\'?/.><\":;|\\}]{[=+-)(*&^%$#@!`~");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with only numbers
     */
    @Test
    public void testStringWithOnlyNumbers() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("0123456789");
        String expected = TestUtils.stringWithNewLine("9876543210");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test input string with special characters and numbers
     */
    @Test
    public void testStringWithSpecialCharsAndNumbers() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("Design P@tterns - H00rah");
        String expected = TestUtils.stringWithNewLine("har00H - snrett@P ngiseD");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test alphabet lowercase
     */
    @Test
    public void testAlphabetLowerCase() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("abcdefghijklmnopqrstuvwxyz");
        String expected = TestUtils.stringWithNewLine("zyxwvutsrqponmlkjihgfedcba");
        assertEquals(expected, outContent.toString());
    }

    /**
     * Test alphabet uppercase
     */
    @Test
    public void testAlphabetUpperCase() {
        ConcreteSubject subject = new ConcreteSubject();
        new ReverseObserver(subject);
        subject.setValue("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String expected = TestUtils.stringWithNewLine("ZYXWVUTSRQPONMLKJIHGFEDCBA");
        assertEquals(expected, outContent.toString());
    }
}
