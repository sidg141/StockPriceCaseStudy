package com.example.demo.repo;

import com.example.demo.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query(value = "select * from company c where c.company_name  like :pattern",
            nativeQuery = true)
    List<Company> findMatchPatternCompanies(@Param("pattern") String pattern);
    @Query
    List<Company> findAllBySector(String sector);
    @Query(value="select * from company where ")
    List<Company> findAllBySectorByDate(String frm_date, String to_date, String sector);
}
