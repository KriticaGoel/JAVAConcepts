package DesignPattern.Behavioural.MementoPattern.Sol1;

import java.util.Stack;

public class StateManagement {

    Stack<TextEditor> history = new Stack<>();
    Stack<TextEditor> redostack = new Stack<>();

    public void write(String header, String content) {
        TextEditor textEditor = new TextEditor();
        textEditor.setContent(content);
        textEditor.setHeader(header);
        history.push(textEditor);
        redostack.clear(); // Clear redo stack when a new state is added
    }

    public void display() {
        if (history.isEmpty()) {
            System.out.println("Nothing to show");
        } else {
            TextEditor textEditor = history.peek();
            System.out.println("Header " + textEditor.getHeader());
            System.out.println("Content " + textEditor.getContent());
        }
    }

    public void undo() {
        if (history.isEmpty() && redostack.isEmpty()) {
            display();
        } else if (history.isEmpty()) {
            System.out.println("No previous data present");
        } else {
            redostack.push(history.pop());
        }
        display();
    }

    public void redo() {
        if (history.isEmpty() && redostack.isEmpty()) {
            display();
        } else if (redostack.isEmpty()) {
            System.out.println("This is a last data");
        } else {
            history.push(redostack.pop());
        }
        display();
    }
}
