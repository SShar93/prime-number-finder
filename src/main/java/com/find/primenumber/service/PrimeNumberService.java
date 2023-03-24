package com.find.primenumber.service;

import com.find.primenumber.model.PrimeNumberResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PrimeNumberService {

    public PrimeNumberResult findPrimeNumber(int number){
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 0 ; i <=number ; i++){
            if(checkPrime(i)){
                primes.add(i);
            }
        }
    return PrimeNumberResult.builder().intial(number).primes(primes).build();
    }

    private boolean checkPrime(int i) {
        if(i <= 1)
            return false;
        for(int k = 2 ; k < i ; k++){
            if(i%k == 0)
                return false;
        }
        return  true;
    }
}
