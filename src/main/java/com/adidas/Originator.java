package com.adidas;
// Originator class that creates and restores its state using Mementos
public class Originator {
    private String state;

    // Method to set the state
    public void setState(String state) {
        this.state = state;
    }

    // Method to get the current state
    public String getState() {
        return state;
    }

    // Creates a new Memento containing the current state
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    // Restores the state from the given Memento
    public void restoreStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
