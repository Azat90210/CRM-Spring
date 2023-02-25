package project.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.models.News;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class NewsDAO {
    private static int NEWS_COUNT;
    private List<News> news;

    {
        news = new ArrayList<>();

        news.add(new News(++NEWS_COUNT, "First news", "Text description some news", (byte) 1));
        news.add(new News(++NEWS_COUNT, "Second news", "Text description some news", (byte) 1));
        news.add(new News(++NEWS_COUNT, "Third news", "Text description some news", (byte) 1));

    }

    public List<News> index() {
        return news;
    }

    public News show(int id) {
        return news.stream().filter(news -> news.getId() == id).findAny().orElse(null);
    }
}
