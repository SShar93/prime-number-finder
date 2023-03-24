package com.find.primenumber.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
public class PrimeNumberResult {

    @JsonProperty("Initial")
    private int intial;

    @JsonProperty("Primes")
    private List<Integer> primes;
}
