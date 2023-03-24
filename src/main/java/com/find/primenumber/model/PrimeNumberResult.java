package com.find.primenumber.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;


@Builder
@Data
public class PrimeNumberResult {

    @JsonProperty("Initial")
    private int intial;

    @JsonProperty("Primes")
    private ArrayList<Integer> primes;
}
