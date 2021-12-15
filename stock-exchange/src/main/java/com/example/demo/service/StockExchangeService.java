package com.example.demo.service;


import com.example.demo.model.StockExchange;
import com.example.demo.shared.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockExchangeService {
    public String createSe(StockExchange stockExchange);
    public List<StockExchange> getAllSe();
    public List<Company> getAllCompanyBySe(String se);
}
