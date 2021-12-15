package com.example.demo.shared;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Company {
    private Long id;
    private String ceo;
    private String about;
    private String directors;
    private String company_name;
    private String sector;
    private Boolean is_listed_in_stock;
    private String stock_code;
}
