package com.example.demo.repo;


import com.example.demo.model.StockPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice,Long> {
    @Transactional
    @Query(value ="selct * from Stock_price ",nativeQuery = true)
    public List<StockPrice> getStockPriceBydateAndId(@Param("frm_date") String frm_date, @Param("to_date") String to_date, @Param("id") Long id);
}
