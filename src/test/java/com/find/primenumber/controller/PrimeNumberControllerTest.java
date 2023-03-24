package com.find.primenumber.controller;

import com.find.primenumber.model.PrimeNumberResult;
import com.find.primenumber.service.PrimeNumberService;
import com.find.primenumber.util.TestUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.regex.Matcher;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrimeNumberService service;

    @Test
    @DisplayName("Test for Get endpoint call for Success Scenario")
    void testFindPrimNumber() throws Exception {
        PrimeNumberResult primeNumberResult = TestUtils.buildPrimeNumberResult();
        Mockito.when(service.findPrimeNumber(10)).thenReturn(primeNumberResult);
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{number}",10))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Initial", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Primes", Matchers.is(TestUtils.buildPrimeNumberResult().getPrimes())))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Test for Get endpoint call for failure Scenario")
    void testFindPrimNumberFailure() throws Exception {
        PrimeNumberResult primeNumberResult = TestUtils.buildPrimeNumberResult();
        Mockito.when(service.findPrimeNumber(10)).thenReturn(primeNumberResult);
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{number}","string"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
}
