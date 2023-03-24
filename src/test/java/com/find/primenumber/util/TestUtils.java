package com.find.primenumber.util;

import com.find.primenumber.model.PrimeNumberResult;

import java.util.ArrayList;

public class TestUtils {

    public static PrimeNumberResult buildPrimeNumberResult(){
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        return PrimeNumberResult.builder().intial(10).primes(primes).build();
    }
}
