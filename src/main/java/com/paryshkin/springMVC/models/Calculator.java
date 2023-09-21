package com.paryshkin.springMVC.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
@XmlRootElement(name = "calculator") // Указываем имя элемента в XML
public class Calculator
{
    private int id;
    private double firstParameter;
    private double secondParameter;
    private double result;
    private String operation;

//    public Calculator(double firstParameter, double secondParameter, String operation)
//    {
//        this.firstParameter = firstParameter;
//        this.secondParameter = secondParameter;
//        this.operation = operation;
//    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getResult()
    {
        return result;
    }

    public double getFirstParameter()
    {
        return firstParameter;
    }

    public void setFirstParameter(double firstParameter)
    {
        this.firstParameter = firstParameter;
    }

    public double getSecondParameter()
    {
        return secondParameter;
    }

    public void setSecondParameter(double secondParameter)
    {
        this.secondParameter = secondParameter;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }
    public void calc()
    {
        switch (operation)
        {
            case "multiplication": result = firstParameter * secondParameter;
                break;
            case "addition": result = firstParameter + secondParameter;
                break;
            case "subtraction": result = firstParameter - secondParameter;
                break;
            case "division":
            {
                if (secondParameter != 0 ) result = firstParameter / secondParameter;

            }
            break;

        }
    }
}
