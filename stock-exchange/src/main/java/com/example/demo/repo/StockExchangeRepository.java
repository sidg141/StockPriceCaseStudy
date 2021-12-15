package com.example.demo.repo;

import com.example.demo.model.StockExchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchange,Long> {
}
