package com.adidas.Interface;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> mementos = new Stack<>();

    // Add a Memento to the list
    public void addMemento(Memento memento) {
        mementos.push(memento);
    }

    // Retrieve a Memento from the list
    public Memento getMemento() {
        return mementos.pop();
    }
}
