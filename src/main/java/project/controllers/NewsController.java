package project.controllers;

import project.dao.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsDAO newsDAO;

    @Autowired
    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }


    @GetMapping("news-controller")
    private String index(Model model) {
        model.addAttribute("news", newsDAO.index());
        return "news/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("news", newsDAO.show(id));
        return "news/show";
    }
}
