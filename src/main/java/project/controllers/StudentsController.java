package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.dao.StudentsDAO;
import project.models.Student;


@Controller
@RequestMapping("/students")
public class StudentsController {
    private final StudentsDAO studentsDAO;

@Autowired
    public StudentsController(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("students", studentsDAO.index());
        return "students/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentsDAO.show(id));
        return "students/show";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "students/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") Student student,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "students/new";

        studentsDAO.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentsDAO.show(id));
        return "students/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "students/edit";

        studentsDAO.update(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        studentsDAO.delete(id);
        return "redirect:/students";
    }
}
