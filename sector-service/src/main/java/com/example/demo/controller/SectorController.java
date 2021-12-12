package com.example.demo.controller;


import com.example.demo.proxy.CompanyProxy;
import com.example.demo.shared.Company;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sector")
public class SectorController {
    private Environment environment;
    private CompanyProxy companyProxy;

    public SectorController() {
    }

    @Autowired
    public SectorController(Environment environment, CompanyProxy companyProxy) {
        this.environment = environment;
        this.companyProxy = companyProxy;
    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("SECTOR_WS is up and running on port: "+environment.getProperty("local.server.port"));
    }

    @GetMapping("/companybySector/{sname}")
    @CircuitBreaker(name = "myCircuitBreaker",fallbackMethod = "myTestFallBack")
    public ResponseEntity<?> getCompanyBySec(@PathVariable("sname") String sname){
        return ResponseEntity.status(HttpStatus.OK).body(companyProxy.getCompanyDetails(sname));
    }

    public ResponseEntity<?> myTestFallBack(Exception e)
    {
        return ResponseEntity.ok("within myTestFallBack method. Company-WS is down"+e.toString());
    }
}
