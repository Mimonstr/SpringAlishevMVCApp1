package com.paryshkin.springMVC;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Component
public class HelloController
{
    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello_world";
    }
}
