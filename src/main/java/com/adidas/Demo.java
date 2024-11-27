package com.adidas;

public class Demo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // Setting and saving initial states
        originator.setState("State #1");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State #2");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State #3");
        System.out.println("Current State: " + originator.getState());

        // Restoring previous states
        originator.restoreStateFromMemento(caretaker.getMemento(0));
        System.out.println("First saved State: " + originator.getState());

        originator.restoreStateFromMemento(caretaker.getMemento(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
