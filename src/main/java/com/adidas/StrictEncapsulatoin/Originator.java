package com.adidas.StrictEncapsulatoin;

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

    // Save the current state to a Memento
    public Memento saveToMemento() {
        return new Memento(state);
    }

    // Restore the state from a Memento
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
    }

    // Memento class with strict encapsulation
    public static class Memento {
        private final String state;

        // Private constructor ensures that only the Originator can create Mementos
        private Memento(String state) {
            this.state = state;
        }

        // Private method ensures that only the Originator can access the state
        private String getState() {
            return state;
        }
    }
}
