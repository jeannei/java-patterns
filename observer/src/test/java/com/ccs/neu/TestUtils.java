package com.ccs.neu;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The type Test utils.
 */
public class TestUtils {

    private TestUtils() {

    }

    /**
     * String with new line string.
     *
     * @param s the s
     * @return the string
     */
    public static String stringWithNewLine(String s) {
        return s + "\n";
    }

    /**
     * Gets byte array output stream.
     *
     * @return the byte array output stream
     */
    public static ByteArrayOutputStream getByteArrayOutputStream() {
        return new ByteArrayOutputStream();
    }

    /**
     * Gets system out print stream.
     *
     * @return the system out print stream
     */
    // SONARLINT dislikes System.out.println and suggests a logger.
    // For the purposes of this assignment a logger is a lot of overhead
    // so I suppress the warning instead
    @SuppressWarnings("squid:S106")
    public static PrintStream getSystemOutPrintStream() {
        return System.out;
    }

}
