package com.find.primenumber.service;

import com.find.primenumber.model.PrimeNumberResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeNumberService {

    public PrimeNumberResult findPrimeNumber(int number){
        return PrimeNumberResult.builder()
            .intial(number)
            .primes(IntStream.rangeClosed(2,number).filter(this::checkPrime).boxed().collect(Collectors.toList())).build();
    }

    private boolean checkPrime(int i) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(i)).allMatch(x-> i % x != 0);
    }
}
