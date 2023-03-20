package project.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dao.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import project.models.News;
import project.models.Student;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsDAO newsDAO;

    @Autowired
    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("news", newsDAO.index());
        return "new/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("new", newsDAO.show(id));
        return "new/show";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("new") Student student) {
        return "new/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("new") @Valid News news,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new/new";

        newsDAO.save(news);
        return "redirect:/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("new", newsDAO.show(id));
        return "new/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("new") @Valid News news, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "new/edit";

        newsDAO.update(id, news);
        return "redirect:/new";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        newsDAO.delete(id);
        return "redirect:/new";
    }
}
