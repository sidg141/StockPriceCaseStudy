package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="stock_price")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockPrice {
    @Id
    private Long id;
    @Column(name = "company_code")
    private String company_code;
    @Column(name = "se_name")
    private String se_name;
    @Column(name = "price")
    private float price;
    @Column(name="share")
    private float share;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
}
