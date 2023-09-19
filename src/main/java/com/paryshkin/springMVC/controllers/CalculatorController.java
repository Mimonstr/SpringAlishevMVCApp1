package com.paryshkin.springMVC.controllers;

import com.paryshkin.springMVC.dao.CalculatorDAO;
import com.paryshkin.springMVC.models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController
{
    private final CalculatorDAO calculatorDAO;

    public CalculatorController(CalculatorDAO calculatorDAO)
    {
        this.calculatorDAO = calculatorDAO;
    }
    @GetMapping("/show")
    public String index(Model model)
    {
        // Получим все выражения из DAO и передадим на отображение в представление
        model.addAttribute("expressions", calculatorDAO.index());
        return "calculator/index";
    }

    @GetMapping()
    public String index(@ModelAttribute Calculator calculator)
    {
        return "calculator/enter";
    }
    @PostMapping()
    public String create(@ModelAttribute("calculator") Calculator calculator)
    {
        calculator.calc();
        return "calculator/total";
    }
}
