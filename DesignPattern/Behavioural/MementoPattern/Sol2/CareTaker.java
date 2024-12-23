package DesignPattern.Behavioural.MementoPattern.Sol2;

import java.util.Stack;

public class CareTaker {

    Stack<TextEditor> history = new Stack<>();
    Stack<TextEditor> redostack = new Stack<>();

    public void write(String header, String content) {
        TextEditor textEditor = new TextEditor();
        textEditor.setContent(content);
        textEditor.setHeader(header);
        history.push(textEditor);
        redostack.clear(); // Clear redo stack when a new state is added
    }

//    public TextEditor display() {
//
//        if (history.isEmpty()) {
//            return new TextEditor();
//        } else {
//            return history.peek();
//              }
//    }

    public void undo() {
        redostack.push(history.pop());
        //  display();
    }


    public void redo() {
        history.push(redostack.pop());
        //  display();
    }
}
