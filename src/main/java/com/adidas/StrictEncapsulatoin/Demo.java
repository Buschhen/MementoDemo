package com.adidas.StrictEncapsulatoin;

public class Demo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // Set initial state and save it
        originator.setState("State #1");
        caretaker.addMemento(originator.saveToMemento());

        // Change state and save it
        originator.setState("State #2");
        caretaker.addMemento(originator.saveToMemento());

        // Change state again
        originator.setState("State #3");
        System.out.println("Current State: " + originator.getState());

        // Restore to the first saved state
        originator.restoreFromMemento(caretaker.getMemento());
        System.out.println("Restored to First State: " + originator.getState());

        // Restore to the second saved state
        originator.restoreFromMemento(caretaker.getMemento());
        System.out.println("Restored to Second State: " + originator.getState());
    }
}
