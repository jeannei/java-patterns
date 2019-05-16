package com.ccs.neu.observers;

import com.ccs.neu.ConcreteSubject;
import com.ccs.neu.PrintUtils;

/**
 * The type Reverse observer.
 */
public class ReverseObserver extends AbstractObserver {

    /**
     * Instantiates a new Reverse observer.
     *
     * @param concreteSubject the concrete subject
     */
    public ReverseObserver(ConcreteSubject concreteSubject) {
        super(concreteSubject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        String value = concreteSubject.getValue();
        if (PrintUtils.printEmpty(concreteSubject.getValue())) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }

        PrintUtils.print(stringBuilder.toString());
    }
}
