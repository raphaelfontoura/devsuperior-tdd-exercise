package com.devsuperior.core.fabrics;

import com.devsuperior.core.Financing;

import javax.management.InvalidAttributeValueException;

public class FinancingFabric {

    public static Financing createFinancingWithValidValues() throws InvalidAttributeValueException {
        return new Financing(1000.00,1000.00,10);
    }

    public static Financing createFinancingWithTotalAmount(double totalAmount) throws InvalidAttributeValueException {
        return new Financing(totalAmount, 1000.00, 10);
    }
}
