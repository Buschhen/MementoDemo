package com.adidas.Nested;

import java.util.Stack;

public class Caretaker {
    private final Stack<Originator.Memento> mementoList = new Stack<>();

    // Adds a Memento to the list
    public void addMemento(Originator.Memento memento) {
        mementoList.push(memento);
    }

    // Retrieves a Memento from the list
    public Originator.Memento getMemento() {
        return mementoList.pop();
    }
}
