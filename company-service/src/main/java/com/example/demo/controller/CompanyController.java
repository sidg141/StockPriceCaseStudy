package com.example.demo.controller;


import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company-service")
public class CompanyController {

    @Autowired
    public CompanyService companyService;

    @GetMapping("/status")
    public String getStatus(){
        return "Hello i am up";
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return ResponseEntity.ok("Company profile created");
    }

    @GetMapping("/getCompayDetails/{id}")
    public ResponseEntity<Optional<Company>> getCompanyDetails(@PathVariable Long id){
        Optional<Company> company =companyService.getCompanyDetails(id);
         return ResponseEntity.status(HttpStatus.OK).body(company);
    }

    @GetMapping("/matchpattern/{pattern}")
    public ResponseEntity<List<Company>> getPatternMatching(@PathVariable String pattern) throws Exception {
        return ResponseEntity.ok(companyService.getMatchingCompanies(pattern));
    }

    @GetMapping("/searchBySectorId/{sector}")
    public ResponseEntity<?> getCompanyBySectorId(@PathVariable String sector){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyDetailsBySector(sector));
    }
    @GetMapping("/sectorPrice/{frm_date}/{to_date}/{sector_id}")
    public ResponseEntity<?> getSectorPrice(@PathVariable("frm_date") String frm_date,@PathVariable("to_date") String to_date,@PathVariable("sector_id") String sector){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanySectorPrice(frm_date,to_date,sector));
    }

    @GetMapping("/searchBySe/{se}")
    public ResponseEntity<?> getCompanyDetailsBySe(@PathVariable("se")  String se){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyDetailsBySe(se));
    }

}
