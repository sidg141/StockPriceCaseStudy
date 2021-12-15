package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stock_exchange")
public class StockExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "se")
    private String se;
    @Column(name = "brief")
    private String brief;
    @Column(name = "address")
    private String address;
    @Column(name = "remarks")
    private String remarks;

}
