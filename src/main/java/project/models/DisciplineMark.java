package project.models;

import java.util.Objects;

public class DisciplineMark {
    private int id;
    private String name;
    private byte status;
    private String mark;

    public DisciplineMark() {
    }

    public DisciplineMark(int id, String name, byte status, String mark) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.mark = mark;
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineMark that = (DisciplineMark) o;
        return id == that.id && status == that.status && Objects.equals(name, that.name) && Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, mark);
    }

    @Override
    public String toString() {
        return "DisciplineMark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", mark='" + mark + '\'' +
                '}';
    }
}
