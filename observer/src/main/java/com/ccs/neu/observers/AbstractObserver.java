package com.ccs.neu.observers;

import com.ccs.neu.ConcreteSubject;

/**
 * The type Abstract observer.
 */
public abstract class AbstractObserver implements Observer {
    /**
     * The Concrete subject.
     */
    protected ConcreteSubject concreteSubject;

    /**
     * Instantiates a new Ascii observer.
     *
     * @param concreteSubject the concrete subject
     */
    public AbstractObserver(ConcreteSubject concreteSubject) {
        concreteSubject.attach(this);
        this.concreteSubject = concreteSubject;
    }

    /**
     * Convert string string.
     *
     * @param value        the value
     * @param observerType the observer type
     * @return the string
     */
    public String convertString(String value, ObserverType observerType) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = value.toCharArray();
        for (char character : chars) {
            int asciiValue = character;
            if (ObserverType.ASCII.equals(observerType)) {
                stringBuilder.append(asciiValue);
            } else {
                stringBuilder.append(Integer.toHexString(asciiValue));
            }
            stringBuilder.append(' ');
        }

        return stringBuilder.toString();
    }
}
