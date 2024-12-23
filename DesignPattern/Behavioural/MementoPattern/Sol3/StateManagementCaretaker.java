package DesignPattern.Behavioural.MementoPattern.Sol3;

import java.util.Stack;

public class StateManagementCaretaker {
    //Manage state without modifying the item
    Stack<TextEditorMemento> history = new Stack<>();
    Stack<TextEditorMemento> redoHistory = new Stack<>();

    public void save(TextEditorOriginator originator) {
        history.push(originator.save());
        redoHistory.clear();
    }

    public void redo(TextEditorOriginator originator) {
        if (!redoHistory.isEmpty()) {
            history.push(redoHistory.pop());
            originator.restore(history.peek());
        }
    }

    public void undo(TextEditorOriginator originator) {
        if (!history.isEmpty()) {
            redoHistory.push(history.pop());
            originator.restore(history.peek());
        }
    }


}
