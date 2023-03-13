package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dao.TermDAO;
import project.models.Term;

@Controller
@RequestMapping("/terms")
public class TermsController {
    private final TermDAO termDAO;

    @Autowired
    public TermsController(TermDAO termDAO) {
        this.termDAO = termDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("terms", termDAO.index());
        return "terms/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("term", termDAO.show(id));
        return "terms/show";
    }

    @GetMapping("/new")
    public String newTerm(@ModelAttribute("term") Term term) {
        return "terms/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("term") Term term,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "terms/new";

        termDAO.save(term);
        return "redirect:/terms";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("term", termDAO.show(id));
        return "terms/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("term") Term term, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "terms/edit";

        termDAO.update(id, term);
        return "redirect:/terms";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        termDAO.delete(id);
        return "redirect:/terms";
    }

}
