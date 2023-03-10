package project.models;

import java.util.Objects;

public class TermDiscipline {

    private int id;
    private String termName;
    private int duration;
    private String disciplineName;

    public TermDiscipline() {
    }

    public TermDiscipline(int id, String termName, int duration, String disciplineName) {
        this.id = id;
        this.termName = termName;
        this.duration = duration;
        this.disciplineName = disciplineName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermDiscipline that = (TermDiscipline) o;
        return id == that.id && duration == that.duration && Objects.equals(termName, that.termName) && Objects.equals(disciplineName, that.disciplineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, termName, duration, disciplineName);
    }

    @Override
    public String toString() {
        return "TermDiscipline{" +
                "id=" + id +
                ", termName='" + termName + '\'' +
                ", duration=" + duration +
                ", disciplineName='" + disciplineName + '\'' +
                '}';
    }
}
