package com.example.demo.controller;


import com.example.demo.model.StockExchange;
import com.example.demo.proxy.CompanyProxy;
import com.example.demo.service.StockExchangeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock-exchange")
public class StockExchangeController {


    private Environment environment;
    private StockExchangeService stockExchangeService;
    private CompanyProxy companyProxy;

    @Autowired
    public StockExchangeController(Environment environment, StockExchangeService stockExchangeService,CompanyProxy companyProxy) {
        this.environment = environment;
        this.stockExchangeService = stockExchangeService;
        this.companyProxy = companyProxy;
    }

    @PostMapping("/create")
    public String create(@RequestBody StockExchange stockExchange){
        return stockExchangeService.createSe(stockExchange);
    }

    @GetMapping("/allse")
    public ResponseEntity<?> getAllSe(){
        return ResponseEntity.status(HttpStatus.OK).body(stockExchangeService.getAllSe());
    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("SE_WS is up and running on port: "+environment.getProperty("local.server.port"));
    }

    @GetMapping("/companybySe/{se}")
    @CircuitBreaker(name = "myCircuitBreaker",fallbackMethod = "myTestFallBack")
    public ResponseEntity<?> getCompanyBySe(@PathVariable("se") String se){
        return ResponseEntity.status(HttpStatus.OK).body(companyProxy.getCompanyDetailsBySe(se));
    }

    public ResponseEntity<?> myTestFallBack(Exception e)
    {
        return ResponseEntity.ok("within myTestFallBack method. SE-WS is down"+e.toString());
    }



}
