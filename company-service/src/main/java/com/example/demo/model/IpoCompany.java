package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "I")
public class IpoCompany
{
    @Id
    private Long id;
    private String companyCode;
    private String stockExchangeName;
    private double price;
    private String date;
    private String time;
}
