package DesignPattern.Behavioural.MementoPattern.Sol1;

public class TextEditor {

    private String content;
    private String header;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        if (header == null || header.isEmpty()) {
            throw new IllegalArgumentException("Header cannot be null or empty");
        }
        this.header = header;
    }

    @Override
    public String toString() {
        return "TextEditor [header=" + header + ", content=" + content + "]";
    }
}
