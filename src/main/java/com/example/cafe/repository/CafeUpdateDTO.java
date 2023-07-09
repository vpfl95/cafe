package com.example.cafe.repository;

import lombok.Data;

@Data
public class CafeUpdateDTO {

    private Long maxSales;
    private Long minSales;
    private String customer;

    public CafeUpdateDTO(){
    }
}
