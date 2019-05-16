package com.ccs.neu;

import com.ccs.neu.observers.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Subject.
 */
public abstract class Subject {
    /**
     * The Observer list.
     */
    private List<Observer> observerList = new ArrayList<>();

    /**
     * Attach.
     *
     * @param observer the observer
     */
    public void attach(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }

        if (observerList.contains(observer)) {
            return;
        }
        observerList.add(observer);
    }

    /**
     * Detach.
     *
     * @param observer the observer
     */
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * Notify observers.
     */
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
