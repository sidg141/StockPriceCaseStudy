package com.example.demo.service;

import com.example.demo.model.StockPrice;
import com.example.demo.repo.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StockPriceServiceImpl implements StockPriceService{

    private StockPriceRepository stockPriceRepository;

    @Autowired
    public StockPriceServiceImpl(StockPriceRepository stockPriceRepository) {
        this.stockPriceRepository = stockPriceRepository;
    }

    @Override
    public List<StockPrice> getStockPriceByInterval(String frm_date, String to_date, Long id) {
        try {
            return stockPriceRepository.getStockPriceBydateAndId(frm_date, to_date, id);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error occured");
        }
        return  null;
    }

    @Override
    public List<StockPrice> getAllStock(Long id,String code) throws Exception {
        List<StockPrice> ans  = stockPriceRepository.findAllByIdOrCode(id,code);
        if(ans.size()==0){

            return stockPriceRepository.findAllByCode(code);
        }

        return  ans;
    }
}
