package com.paryshkin.springMVC.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController
{
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model)
    {
        model.addAttribute("message", "Hello, " + name + " " + surname);
       // System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage()
    {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Double a,
                             @RequestParam(value = "b",required = false) Double b,
                             @RequestParam(value = "operation",required = false) String operation, Model model)
    {
        switch (operation)
        {
            case "multiplication": model.addAttribute("message", "Получаем что, " + a + " * " + b + " = " + (a*b) );
                break;
            case "addition": model.addAttribute("message", "Получаем что, " + a + " + " + b + " = " + (a+b) );
                break;
            case "subtraction": model.addAttribute("message", "Получаем что, " + a + " - " + b + " = " + (a-b) );
                break;
            case "division":
            {
                if (b != 0 ) model.addAttribute("message", "Получаем что, " + a + " / " + b + " = " + (a/b) );
                else model.addAttribute("message", "Делить на ноль нельзя! " + "b" + " = " + b );
            }
                break;
            default: model.addAttribute("message", "Операция введена неккоректно! ");

        }
        return "first/calculator";
    }
}
