package com.ccs.neu.observers;

import com.ccs.neu.ConcreteSubject;
import com.ccs.neu.PrintUtils;

/**
 * The type Ascii observer.
 */
public class AsciiObserver extends AbstractObserver {


    /**
     * Instantiates a new Ascii observer.
     *
     * @param concreteSubject the concrete subject
     */
    public AsciiObserver(ConcreteSubject concreteSubject) {
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

        String result = convertString(value, ObserverType.ASCII);
        PrintUtils.print(result.trim());
    }
}
