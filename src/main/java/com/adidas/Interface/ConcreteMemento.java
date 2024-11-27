package com.adidas.Interface;

public class ConcreteMemento implements Memento {
    private final String state;

    public ConcreteMemento(String state) {
        this.state = state;
    }

    // Method to retrieve the saved state (accessible only by Originator)
    public String getState() {
        return state;
    }

    @Override
    public String getName() {
        return "Memento: " + state;
    }
}
