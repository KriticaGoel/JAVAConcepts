package DesignPattern.Behavioural.MementoPattern.Problem;

public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.setContent("Hello World");
        textEditor.setHeader("My Header");
        //Hello World
        System.out.println(textEditor.getContent());
        textEditor.setContent("Hello Everyone");
        //Hello Everyone
        System.out.println(textEditor.getContent());

        //Problem: I want to undo the content.
    }
}
