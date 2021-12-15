package com.example.demo.proxy;


import com.example.demo.shared.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "COMPANY-WS")
public interface CompanyProxy {
    @GetMapping("/company-service/searchBySe/{se}")
    public List<Company> getCompanyDetailsBySe(@PathVariable("se")  String se);
}
