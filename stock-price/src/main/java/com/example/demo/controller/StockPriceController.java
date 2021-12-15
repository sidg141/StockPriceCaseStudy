package com.example.demo.controller;


import com.example.demo.model.StockPrice;
import com.example.demo.request.StockPriceObj;
import com.example.demo.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock-price")
public class StockPriceController {
    private Environment environment;
    private StockPriceService stockPriceService;

    public StockPriceController() {
    }

    @Autowired
    public StockPriceController(Environment environment, StockPriceService stockPriceService) {
        this.environment = environment;
        this.stockPriceService = stockPriceService;
    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus(){
        return ResponseEntity.status(HttpStatus.OK).body("stcok-price-ws is up and running at"+environment.getProperty("local.server.port"));
    }

    @PostMapping("/get-rec/")
    public ResponseEntity<?> getRecBydate(@RequestBody StockPriceObj obj){
        String frm_date = obj.getFrm_date();
        String to_date = obj.getTo_date();
        Long id = obj.getId();
        return ResponseEntity.status(HttpStatus.OK).body(stockPriceService.getStockPriceByInterval(frm_date,to_date,id));
    }

    @PostMapping("/getAll/")
    public ResponseEntity<?> getAll(@RequestBody StockPriceObj obj) throws Exception{
        Long id = obj.getId();
        return ResponseEntity.status(HttpStatus.OK).body(stockPriceService.getAllStock(id, obj.getCompany_code()));
    }
}

