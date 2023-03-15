package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import project.models.Student;

import java.util.List;

@Component
public class StudentsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
    }

    public Student show(int id) {
        return jdbcTemplate.query("SELECT * FROM student WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }

    public void save(Student student) {
        jdbcTemplate.update("INSERT INTO student VALUES(1, ?, ?, ?, ?, ?)", student.getName(), student.getSurname(),
                student.getGroup(), student.getStatus(), student.getData_enter());
    }

    public void update(int id, Student updatedStudent) {
        jdbcTemplate.update("UPDATE student SET name=?, surname=?, group=?, status=?, data_enter=? WHERE id=?", updatedStudent.getName(),
                updatedStudent.getSurname(), updatedStudent.getGroup(), updatedStudent.getStatus(), updatedStudent.getData_enter(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM student WHERE id=?", id);
    }
}
