package com.devsuperior.core;

import com.devsuperior.core.fabrics.FinancingFabric;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.InvalidAttributeValueException;


public class FinancingTests {

    @Test
    void createNewFinancingShouldSaveTotalAmountWhenTotalAmountAndIncomingAndMonthsInformed() throws InvalidAttributeValueException {

        var financing = FinancingFabric.createFinancingWithValidValues();

        Assertions.assertNotNull(financing);
        Assertions.assertNotNull(financing.getTotalAmount());
        Assertions.assertNotNull(financing.getIncome());
        Assertions.assertNotNull(financing.getMonths());
    }

    @Test
    void entryValueShouldReturn20PercentOfTotalAmount() throws InvalidAttributeValueException {
        var totalAmount = 1000.00;

        var financing = FinancingFabric.createFinancingWithTotalAmount(totalAmount);
        Double result = financing.entry();

        Assertions.assertEquals(200.00, result);
    }

    @Test
    void getQuotaShouldReturnValueOf80PercentTotalAmoutDivideByMonths() throws InvalidAttributeValueException {
        var financing = FinancingFabric.createFinancingWithValidValues();
        var expectedQuota = financing.getTotalAmount()*.80/financing.getMonths();

        Double result = financing.quota();

        Assertions.assertEquals(expectedQuota, result);
    }

    @Test
    void getQuotaShouldReturnExceptionWhenQuotaGreaterThen50percentIncome() throws InvalidAttributeValueException {
        var financing = new Financing(1000,100,10);

        Assertions.assertThrows(InvalidAttributeValueException.class, financing::quota);
    }

    @Test
    void invalidTotalAmountShouldReturnInvalidAttributeException() {
        Assertions.assertThrows(InvalidAttributeValueException.class, () -> new Financing(-50.0,100,10));
    }

    @Test
    void invalidIncomeShouldReturnInvalidAttributeException() {
        Assertions.assertThrows(InvalidAttributeValueException.class, () -> new Financing(1000.0,0,10));
    }

    @Test
    void invalidMonthsShouldReturnInvalidAttributeException() {
        Assertions.assertThrows(InvalidAttributeValueException.class, () -> new Financing(1000.0,200,0));
    }

    @Test
    void invalidTotalAmountShouldReturnInvalidAttributeExceptionWhenSetTotalAmount() throws InvalidAttributeValueException {
        var financing = FinancingFabric.createFinancingWithValidValues();
        Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setTotalAmount(0.0));
    }

    @Test
    void invalidIncomeShouldReturnInvalidAttributeExceptionWhenSetInvalidIncome() throws InvalidAttributeValueException {
        var financing = FinancingFabric.createFinancingWithValidValues();

        Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setIncome(10.0));
    }

    @Test
    void invalidMonthsShouldReturnInvalidAttributeExceptionWhenSetInvalidMonths() throws InvalidAttributeValueException {
        var financing = FinancingFabric.createFinancingWithValidValues();

        Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setMonths(1));
    }

}
