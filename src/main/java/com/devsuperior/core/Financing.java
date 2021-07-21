package com.devsuperior.core;

import javax.management.InvalidAttributeValueException;

public class Financing {

    private Double totalAmount;
    private Double income;
    private Integer months;


    public Financing(double totalAmount, double income, int months) throws InvalidAttributeValueException {
        checkValues(totalAmount, income, months);
        this.totalAmount = totalAmount;
        this.income = income;
        this.months = months;
    }

    private void checkValues(double totalAmount, double income, int months) throws InvalidAttributeValueException {
        if (totalAmount <= 0) throw new InvalidAttributeValueException("Montante deve ser maior que 0.");
        if (income <= 0) throw new InvalidAttributeValueException("Renda mensal deve ser maior que 0.");
        if (months <= 0) throw new InvalidAttributeValueException("Quantidade de meses precisa ser 1 mês ou mais.");
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        if (totalAmount <= 0) throw new IllegalArgumentException("Valor do montante deve ser maior que zero.");
        this.totalAmount = totalAmount;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        var quota = this.totalAmount * 0.8 / this.months;
        if (income <= 0 || income * 0.5 < quota) {
            throw new IllegalArgumentException("Renda mensal não compatível com o financiamento.");
        }
        this.income = income;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        var quota = this.totalAmount * 0.8 / months;
        if (months <= 0 || quota > this.income * 0.5) {
            throw new IllegalArgumentException("Quantidade de meses inferior ao permitido para este financiamento.");
        }
        this.months = months;
    }

    public Double entry() {
        return totalAmount * 0.2;
    }

    public Double quota() throws InvalidAttributeValueException {
        var quota = totalAmount * 0.8 / months;
        if (quota > income * 0.5) throw new InvalidAttributeValueException("Valor da cota é maior que o limite permitido.");
        return totalAmount * 0.8 / months;
    }

}
