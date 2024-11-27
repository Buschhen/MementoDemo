package com.adidas;
import java.util.ArrayList;
import java.util.List;

// Caretaker class that manages Mementos
public class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    // Adds a Memento to the list
    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    // Retrieves a Memento from the list
    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}
