package com.find.primenumber.service;

import com.find.primenumber.model.PrimeNumberResult;
import com.find.primenumber.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class PrimeNumberServiceTest {

    @Autowired
    private PrimeNumberService primeNumberService;


    @Test
    @DisplayName("Return Prime Number for succesfull senario")
    void testPrimeNumber(){
        PrimeNumberResult expectedPrimeNumberResult = TestUtils.buildPrimeNumberResult();
        PrimeNumberResult result = primeNumberService.findPrimeNumber(10);
        Assertions.assertEquals(expectedPrimeNumberResult,result);
    }
}
