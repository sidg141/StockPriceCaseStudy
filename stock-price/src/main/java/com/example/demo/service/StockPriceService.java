package com.example.demo.service;

import com.example.demo.model.StockPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockPriceService {
    public List<StockPrice> getStockPriceByInterval(String frm_date, String to_date, Long id);
    public List<StockPrice> getAllStock(Long id,String code) throws Exception;
}
