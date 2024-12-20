package DesignPattern.Behavioural.MementoPattern.Sol1;

import java.util.Stack;

public class StateManagement {

    Stack<TextEditor> stack = new Stack<>();
    Stack<TextEditor> redostack = new Stack<>();


    //    Deep Copying States
//    Ensure the TextEditor objects are deeply copied
//    when pushed to the stacks to avoid unintentional modifications.
//    This would prevent reference-based issues.
    public void write(String header, String content) {
        TextEditor textEditor = new TextEditor();
        textEditor.setContent(content);
        textEditor.setHeader(header);
        stack.push(textEditor);
        redostack.clear(); // Clear redo stack when a new state is added
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("Nothing to show");
        } else {
            TextEditor textEditor = stack.peek();
            System.out.println("Header " + textEditor.getHeader());
            System.out.println("Content " + textEditor.getContent());
        }
    }

    public void undo() {
        if (stack.isEmpty() && redostack.isEmpty()) {
            display();
        } else if (stack.isEmpty()) {
            System.out.println("No previous data present");
        } else {
            redostack.push(stack.pop());
        }
        display();
    }

    public void redo() {
        if (stack.isEmpty() && redostack.isEmpty()) {
            display();
        } else if (redostack.isEmpty()) {
            System.out.println("This is a last data");
        } else {
            stack.push(redostack.pop());
        }
        display();
    }
}
