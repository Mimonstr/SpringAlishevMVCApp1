package com.paryshkin.springMVC.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
    public double calc()
    {
        switch (operation)
        {
            case "multiplication": return (result = firstParameter * secondParameter);
            case "addition": return (result = firstParameter + secondParameter);
            case "subtraction": return (result = firstParameter - secondParameter);
            case "division":
            {
                if (secondParameter != 0 ) return (result = firstParameter / secondParameter);
                else return -1; //model.addAttribute("message", "You can not divide by zero! " + "b" + " = " + b );
            }
            //default: //model.addAttribute("message", "The operation was entered incorrectly! ");

        }
        return 0;
    }
}
