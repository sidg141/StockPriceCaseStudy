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
}
