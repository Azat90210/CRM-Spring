package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import project.models.Disciplin;
import project.models.Student;

import java.util.List;

@Component
public class DisciplinesDAO {
    private final JdbcTemplate jdbcTemplate;

@Autowired
    public DisciplinesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Disciplin> index() {
        return jdbcTemplate.query("SELECT * FROM discipline", new BeanPropertyRowMapper<>(Disciplin.class));
    }

    public Disciplin show(int id) {
        return jdbcTemplate.query("SELECT * FROM discipline WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Disciplin.class))
                .stream().findAny().orElse(null);
    }

    public void save(Disciplin disciplin) {
        jdbcTemplate.update("INSERT INTO discipline VALUES(1, ?, ?)", disciplin.getName(), disciplin.getStatus());
    }

    public void update(int id, Disciplin updatedDisciplin) {
        jdbcTemplate.update("UPDATE discipline SET name=?, status=? WHERE id=?", updatedDisciplin.getName(), updatedDisciplin.getStatus(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM discipline WHERE id=?", id);
    }
}
