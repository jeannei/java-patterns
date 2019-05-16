package com.ccs.neu.observers;

import com.ccs.neu.ConcreteSubject;
import com.ccs.neu.PrintUtils;

/**
 * The type Hex observer.
 */
public class HexObserver extends AbstractObserver {

    /**
     * Instantiates a new Hex observer.
     *
     * @param concreteSubject the concrete subject
     */
    public HexObserver(ConcreteSubject concreteSubject) {
        super(concreteSubject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        String value = concreteSubject.getValue();
        if (PrintUtils.printEmpty(value)) {
            return;
        }

        String result = convertString(value, ObserverType.HEX);
        PrintUtils.print(result.trim());
    }
}
