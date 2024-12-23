package DesignPattern.Behavioural.MementoPattern.Sol3;

public class TextEditorOriginator {
// the object whose state needs to be saved and restore

    private String content;
    private String header;

    public String getData() {
        return "Header " + header + " Content " + content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(header, content);
    }

    public void restore(TextEditorMemento memento) {
        this.header = memento.getHeader();
        this.content = memento.getContent();
    }


}
