package com.wazny.calculator;

public class Calculator {


    private  double operandOne;
    private  double operandTwo;
    private  String  operation;

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResults() {
        return results;
    }


    private  double results;

    public  void performOperation() {

        if (operation.equals("+")) {
            results = operandOne + operandTwo;
        }
        if (operation.equals("-")) {
            results = operandOne - operandTwo;
        }


    }


}
