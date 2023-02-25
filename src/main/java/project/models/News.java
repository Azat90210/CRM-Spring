package project.models;

import java.util.Objects;

public class News {
    private int id;
    private String name;
    private String text;
    private byte status;

    public News() {
    }

    public News(int id, String name, String text, byte status) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && status == news.status && Objects.equals(name, news.name) && Objects.equals(text, news.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, status);
    }

    @Override
    public String toString() {
        return "news{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", status=" + status +
                '}';
    }
}
