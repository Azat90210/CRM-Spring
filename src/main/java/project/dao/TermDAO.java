package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import project.models.Term;

import java.util.List;

@Component
public class TermDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TermDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Term> index() {
        return jdbcTemplate.query("SELECT * FROM term", new BeanPropertyRowMapper<>(Term.class));
    }

    public Term show(int id) {
        return jdbcTemplate.query("SELECT * FROM term WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Term.class))
                .stream().findAny().orElse(null);
    }

    public void save(Term term) {
        jdbcTemplate.update("INSERT INTO term VALUES(1, ?, ?)", term.getName(), term.getDuration());
    }

    public void update(int id, Term updatedTerm) {
        jdbcTemplate.update("UPDATE term SET name=?, duration=? WHERE id=?", updatedTerm.getName(),
                updatedTerm.getDuration(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM term WHERE id=?", id);
    }

}
