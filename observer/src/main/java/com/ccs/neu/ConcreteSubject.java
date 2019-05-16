package com.ccs.neu;

/**
 * The type Concrete subject.
 */
public class ConcreteSubject extends Subject {
    private String value;

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
        notifyObservers();
    }

}
