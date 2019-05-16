package com.ccs.neu;

/**
 * The type Print utils.
 */
public class PrintUtils {

    private PrintUtils() {

    }

    /**
     * Prints the message to system out.
     *
     * @param message the message
     */
    // SONARLINT dislikes System.out.println and suggests a logger.
    // For the purposes of this assignment a logger is a lot of overhead
    // so I suppress the warning instead
    @SuppressWarnings("squid:S106")
    public static void print(String message) {
        System.out.println(message);
    }

    /**
     * Print empty string iff the value is null.
     *
     * @param value the value
     * @return the boolean
     */
    public static boolean printEmpty(String value) {
        if (value == null) {
            PrintUtils.print("");
            return true;
        }

        return false;
    }
}
