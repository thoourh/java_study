package dev.ooae.crud.post;

public class PostDto { //data transfer object?
    private String title;
    private String content;
    private String write;

    public PostDto() {

    }

    public PostDto(String title, String content, String write) {
        this.title = title;
        this.content = content;
        this.write = write;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", write='" + write + '\'' +
                '}';
    }
}
