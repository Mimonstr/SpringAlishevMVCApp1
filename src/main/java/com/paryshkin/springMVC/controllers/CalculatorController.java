package com.paryshkin.springMVC.controllers;

import com.paryshkin.springMVC.dao.CalculatorDAO;
import com.paryshkin.springMVC.models.Calculator;
import com.paryshkin.springMVC.models.XMLHandler;
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
        System.out.println(calculator.getResult());
        try
        {
            XMLHandler.saveToXML(calculator, "C:\\Users\\tupik\\Desktop\\monstr566\\calculation.xml");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "calculator/total";
    }
}
