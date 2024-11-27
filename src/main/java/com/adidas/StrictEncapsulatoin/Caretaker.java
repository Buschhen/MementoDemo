package com.adidas.StrictEncapsulatoin;

import java.util.Stack;

public class Caretaker {
    private final Stack<Originator.Memento> mementoList = new Stack<>();

    // Add a Memento to the list
    public void addMemento(Originator.Memento memento) {
        mementoList.push(memento);
    }

    // Retrieve a Memento from the list
    public Originator.Memento getMemento() {
        return mementoList.pop();
    }
}
