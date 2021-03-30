/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.test;

/**
 *
 * @author olivi
 */
import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

import uts.isd.model.Calculator;

public class CalculatorTest {

 

    private Calculator calculator;

     

    public CalculatorTest() {

        calculator = new Calculator();

    }

 

    @Test

    public void evaluatesExpression() {       

        int sum = calculator.evaluate("1+2+3");

        assertEquals(6, sum);

    }

     

    @Test

    public void testAdd(){

        int res = calculator.add(2,5);

        assertEquals(7,res);

    }

     

    @Test

    public void testSub(){

        int res = calculator.subtract(5,3);

        assertEquals(2,res);

    }

     

    @Test

    public void testMul(){

        int res = calculator.mul(2,4);

        assertEquals(8,res);

    }

     

    @Test

    public void testPow(){

        double res = calculator.power(2, 3);

        Assert.assertEquals(8.00,res,0.001);

    }

}