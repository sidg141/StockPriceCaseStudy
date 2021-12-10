package com.example.demo.service;

import com.example.demo.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    public Company createCompany(Company customer);
    public List<Company>  getMatchingCompanies(String pattern) throws Exception;
    public Optional<Company> getCompanyDetails(Long id);
}
