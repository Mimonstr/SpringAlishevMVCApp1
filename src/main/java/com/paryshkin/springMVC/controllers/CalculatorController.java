package com.paryshkin.springMVC.controllers;

import com.paryshkin.springMVC.models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController
{

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
