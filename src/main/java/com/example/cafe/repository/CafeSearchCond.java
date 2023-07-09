package com.example.cafe.repository;

import lombok.Data;

@Data
public class CafeSearchCond {
    private String cafeName;
    private String address;
    private Long maxSales;
    private Long minSales;
    private String customer;

    public CafeSearchCond(){
    }
}
