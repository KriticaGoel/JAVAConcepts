package DesignPattern.Behavioural.MementoPattern.Sol3;

public class TextEditorMemento {

    //Capture and store the internal state of objects

    private String content;
    private String header;

    TextEditorMemento(String header, String content) {
        this.content = content;
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public String getHeader() {
        return header;
    }
}
