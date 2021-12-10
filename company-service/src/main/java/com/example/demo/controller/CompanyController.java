package com.example.demo.controller;


import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
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
}
