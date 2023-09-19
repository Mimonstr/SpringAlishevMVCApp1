package com.paryshkin.springMVC.dao;

import com.paryshkin.springMVC.models.Calculator;
import com.paryshkin.springMVC.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorDAO
{
    private static int EXPRESSIONS_COUNT;
    private List<Calculator> expressions = new ArrayList<>();

    public List<Calculator> index()
    {
        return expressions;
    }

    public Calculator show(int id)
    {
        return expressions.stream().filter(expression -> expression.getId() == id).findAny().orElse(null);
    }

    public void save(Calculator expression)
    {
        expression.setId(++EXPRESSIONS_COUNT);
        expressions.add(expression);
    }

    public void update(int id, Calculator updatedExpression)
    {
        Calculator expressionToBeUpdated = show(id);
        expressionToBeUpdated.setFirstParameter(updatedExpression.getFirstParameter());
        expressionToBeUpdated.setSecondParameter(updatedExpression.getSecondParameter());
        expressionToBeUpdated.setOperation(updatedExpression.getOperation());
    }
    public void delete(int id)
    {
        expressions.removeIf(expression -> expression.getId() == id);
    }

}
