package com.wazny.calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setOperandOne(5);
        c.setOperation("-");
        c.setOperandTwo(3);
        c.performOperation();
        System.out.println(c.getResults());
    }
}
