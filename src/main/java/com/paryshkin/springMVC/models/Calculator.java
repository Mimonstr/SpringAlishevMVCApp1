package com.paryshkin.springMVC.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.File;

@Component
@XmlRootElement(name = "Expression") // Указываем имя элемента в XML
@XmlType(propOrder = {"id", "firstParameter", "secondParameter", "operation", "result", "file"})
public class Calculator
{
    private String expression;
    private int result;

    public String getExpression()
    {
        return expression;
    }

    public void setExpression(String expression)
    {
        this.expression = expression;
    }

    public int getResult()
    {
        return result;
    }

    public void setResult(int result)
    {
        this.result = result;
    }

    public void calculateResult()
    {
        String[] parts = expression.split("[\\+\\-\\*/]"); // Разбиваем выражение на числа
        int num1 = Integer.parseInt(parts[0]); // Парсим первое число
        int num2 = Integer.parseInt(parts[1]); // Парсим второе число
        char operator = expression.charAt(parts[0].length()); // Получаем оператор

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Unsupported operator: " + operator);
        }
    }


}
