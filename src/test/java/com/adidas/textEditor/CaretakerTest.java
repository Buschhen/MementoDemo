package com.adidas.textEditor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaretakerTest {
    @Test
    void testSaveAndGetState() {
        Caretaker caretaker = new Caretaker();
        Memento memento1 = new Memento("State1");
        Memento memento2 = new Memento("State2");

        caretaker.saveState(memento1);
        caretaker.saveState(memento2);

        assertEquals(2, caretaker.getSize());
        assertEquals("State1", caretaker.getState(0).getState());
        assertEquals("State2", caretaker.getState(1).getState());
    }

    @Test
    void testInvalidStateRetrieval() {
        Caretaker caretaker = new Caretaker();
        Memento memento = new Memento("State");

        caretaker.saveState(memento);

        assertNull(caretaker.getState(-1));
        assertNull(caretaker.getState(5));
    }
}