package com.example.demo.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockPriceObj {

    private Long id;
    private  String company_code;
    private String frm_date;
    private String to_date;
}
