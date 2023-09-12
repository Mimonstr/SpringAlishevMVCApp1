package com.paryshkin.springMVC.controllers;

import com.paryshkin.springMVC.dao.PersonDAO;
import com.paryshkin.springMVC.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController
{
    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO)
    {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model)
    {
        // Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        // Получим одного человека по его id из DAO и передадимна отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model)
    {
        model.addAttribute("person", new Person());

        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person)
    {
        personDAO.save(person);
        return "redirect:/people";
    }
}
