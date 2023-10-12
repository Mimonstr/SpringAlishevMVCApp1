package com.paryshkin.springMVC.controllers;

import com.google.gson.Gson;
import com.paryshkin.springMVC.models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController
{

    public CalculatorController() {}

    @GetMapping()
    public String index(@ModelAttribute Calculator calculator)
    {
        return "calculator/enter";
    }
    @PostMapping()
    public String create(@ModelAttribute("calculator") Calculator calculator)
    {
        calculator.calculateResult(); // Вычисляем результат
        String jsonResult = new Gson().toJson(calculator); // Преобразуем объект в JSON
        // Отправьте jsonExpression куда вам нужно

        return "calculator/total";
    }

}
