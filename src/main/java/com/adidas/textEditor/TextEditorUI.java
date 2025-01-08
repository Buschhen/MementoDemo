package com.adidas.textEditor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;


// Memento Class
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator Class
class TextEditor {
    private String content = "";

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        this.content = memento.getState();
    }
}

// Caretaker Class
class Caretaker {
    final List<Memento> mementos = new ArrayList<>();

    public void saveState(Memento memento) {
        mementos.add(memento);
    }

    public Memento getState(int index) {
        if (index >= 0 && index < mementos.size()) {
            return mementos.get(index);
        }
        return null;
    }

    public int getSize() {
        return mementos.size();
    }
}

public class TextEditorUI {
    private final TextEditor textEditor = new TextEditor();
    private final Caretaker caretaker = new Caretaker();
    private int currentState = -1;
    private int actionFlag = 0;

    public TextEditorUI() {
        // Create UI Components
        JFrame frame = new JFrame("Text Editor");
        JTextArea textArea = new JTextArea(10, 30);
        JButton undoButton = new JButton("Undo");
        JButton redoButton = new JButton("Redo");

        textEditor.setContent(textArea.getText());
        caretaker.saveState(textEditor.save());
        currentState++;

        // Add Listeners
        undoButton.addActionListener(e -> {
            if (currentState > 0) {
                actionFlag = 1;
                currentState--;
                textEditor.restore(caretaker.getState(currentState));
                textArea.setText(textEditor.getContent());
                actionFlag = 0;
            } else {
                JOptionPane.showMessageDialog(frame, "No more undo actions available!");
            }
        });

        redoButton.addActionListener(e -> {
            if (currentState < caretaker.getSize() - 1) {
                actionFlag = 1;
                currentState++;
                textEditor.restore(caretaker.getState(currentState));
                textArea.setText(textEditor.getContent());
                actionFlag = 0;
            } else {
                JOptionPane.showMessageDialog(frame, "No more redo actions available!");
            }
        });

        textArea.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (actionFlag == 0){
                        saveStateAutomatically();
                        System.out.println("Inserted");
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if (actionFlag == 0){
                        saveStateAutomatically();
                        System.out.println("Deleted");
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                }
                private void saveStateAutomatically() {
                    textEditor.setContent(textArea.getText());
                    caretaker.saveState(textEditor.save());
                    currentState++;
                }
            }
        );

        // Setup Frame
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(textArea));
        panel.add(undoButton);
        panel.add(redoButton);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditorUI::new);
    }
}