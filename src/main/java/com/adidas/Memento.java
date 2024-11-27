package com.adidas;
// Memento class that stores the state
public final class Memento {
    private final String state;

    // Constructor accepts state and makes it immutable
    public Memento(String state) {
        this.state = state;
    }

    // State retrieval method
    public String getState() {
        return state;
    }
}
