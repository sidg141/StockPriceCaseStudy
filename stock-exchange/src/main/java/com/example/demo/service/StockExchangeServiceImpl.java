package com.example.demo.service;

import com.example.demo.model.StockExchange;
import com.example.demo.repo.StockExchangeRepository;
import com.example.demo.shared.Company;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockExchangeServiceImpl implements StockExchangeService{
    @Autowired
    private StockExchangeRepository stockExchangeRepository;
    @Override
    public String createSe(StockExchange stockExchange) {
        stockExchangeRepository.save(stockExchange);
        return "Stock exchange saved successfully";
    }

    @Override
    public List<StockExchange> getAllSe() {
        List<StockExchange> ans = (List<StockExchange>) stockExchangeRepository.findAll();
        return ans;
    }

    @Override
    public List<Company> getAllCompanyBySe(String se) {

        return null;
    }
}
