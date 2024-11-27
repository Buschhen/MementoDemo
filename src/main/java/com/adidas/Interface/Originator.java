package com.adidas.Interface;

public class Originator {
    private String state;

    // Set the current state
    public void setState(String state) {
        this.state = state;
    }

    // Get the current state
    public String getState() {
        return state;
    }

    // Save the state to a ConcreteMemento
    public Memento saveToMemento() {
        return new ConcreteMemento(state);
    }

    // Restore the state from a Memento
    public void restoreFromMemento(Memento memento) {
        if (memento instanceof ConcreteMemento) {
            this.state = ((ConcreteMemento) memento).getState();
        }
    }
}
