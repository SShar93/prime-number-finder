package com.find.primenumber.controller;


import com.find.primenumber.model.PrimeNumberResult;
import com.find.primenumber.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumberController {

    private PrimeNumberService primeNumberService;
    @Autowired
    void PrimeNumberController(PrimeNumberService primeNumberService){
        this.primeNumberService = primeNumberService;
    }

    @GetMapping(value = "primes/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrimeNumberResult> findPrimeNumber(@PathVariable  int number){
        PrimeNumberResult primeNumberResult = primeNumberService.findPrimeNumber(number);
        return new ResponseEntity<>(primeNumberResult, HttpStatus.OK);
    }
}
