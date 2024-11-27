package com.adidas.Nested;
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

    // Creates a new Memento with the current state
    public Memento saveToMemento() {
        return new Memento(state);
    }

    // Restores the state from the given Memento
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
    }

    // Nested Memento class
    public class Memento {
        private final String savedState;

        private Memento(String state) {
            this.savedState = state;
        }

        private String getSavedState() {
            return savedState;
        }
    }
}