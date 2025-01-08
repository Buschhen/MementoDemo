package com.adidas.textEditor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {
    @Test
    void testSetAndGetContent() {
        TextEditor textEditor = new TextEditor();
        textEditor.setContent("Hello, World!");
        assertEquals("Hello, World!", textEditor.getContent());
    }

    @Test
    void testSaveAndRestoreState() {
        TextEditor textEditor = new TextEditor();
        textEditor.setContent("First State");
        Memento savedState = textEditor.save();

        textEditor.setContent("Second State");
        textEditor.restore(savedState);

        assertEquals("First State", textEditor.getContent());
    }
}