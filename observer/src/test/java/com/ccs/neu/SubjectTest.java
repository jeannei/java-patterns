package com.ccs.neu;

import com.ccs.neu.observers.AsciiObserver;
import com.ccs.neu.observers.Observer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * The type Subject test.
 */
public class SubjectTest {
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
     * Test detach observer
     */
    @Test
    public void testDetachObserver() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new AsciiObserver(subject);
        subject.detach(observer);
        subject.setValue("Nothing should be printed");
        assertEquals("", outContent.toString());
    }

    /**
     * Test detach observer with null
     */
    @Test
    public void testDetachObserverWithNull() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.detach(null);
        subject.setValue("Nothing should be printed");
        assertEquals("", outContent.toString());
    }

    /**
     * Test attach observer with null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAttachObserverWithNull() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(null);
    }

    /**
     * Test detach observer
     */
    @Test
    public void testAttachTheSameObserver() {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new AsciiObserver(subject);
        subject.attach(observer);
        subject.setValue(" ");
        assertEquals(TestUtils.stringWithNewLine("32"), outContent.toString());
    }
}
