package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements  CompanyService{


    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        companyRepository.save(company);
        return company;
    }

    @Override
    public List<Company> getMatchingCompanies(String pattern) throws Exception{
        try{
            System.out.println("%"+pattern+"%");

            List<Company> companies = companyRepository.findMatchPatternCompanies("%"+pattern+"%");
            if(companies.size() == 0){
                throw new Exception("NO company found");
            }
            return  companies;
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello 2");
        return null;
    }

    @Override
    public Optional<Company> getCompanyDetails(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company;
    }

   public List<Company> getCompanyDetailsBySector(String sector){
        List<Company> ans = companyRepository.findAllBySector(sector);
        return ans;
   }

    @Override
    public List<Company> getCompanySectorPrice(String frm_date, String to_date, String sector) {
        List<Company> ans = companyRepository.findAllBySectorByDate(frm_date,to_date,sector);
        return ans;
    }

    @Override
    public List<Company> getCompanyDetailsBySe(String se) {
        return companyRepository.findAllBySe(se);
    }
}
