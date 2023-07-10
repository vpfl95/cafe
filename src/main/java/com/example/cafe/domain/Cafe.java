package com.example.cafe.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Cafe {

    @Id
    private String cafeName;
    private String address;
    private Long maxSales;
    private Long minSales;
    private String customer;
    private String lat;
    private String lng;
    public Cafe(){
    }
}
