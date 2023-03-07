package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.models.News;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public NewsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<News> index() {
        return jdbcTemplate.query("SELECT * FROM new", new BeanPropertyRowMapper<>(News.class));
    }

    public News show(int id) {
        return jdbcTemplate.query("SELECT * FROM new where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(News.class))
                .stream().findAny().orElse(null);
    }

    public void save (News news){
        jdbcTemplate.update("INSERT INTO new VALUES(1, ?, ?, ?)", news.getName(), news.getStatus(), news.getText());
    }

    public void update (int id, News updateNews){
        jdbcTemplate.update("UPDATE new  SET name=?, status=?, text=? WHERE id=?",
                updateNews.getName(), updateNews.getStatus(), updateNews.getText(), id);
    }

    public void delete (int id){
        jdbcTemplate.update("DELETE FROM new WHERE id=?", id);
    }
}
