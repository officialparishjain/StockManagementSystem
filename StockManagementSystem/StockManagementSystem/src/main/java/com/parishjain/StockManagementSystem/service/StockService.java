package com.parishjain.StockManagementSystem.service;

import com.parishjain.StockManagementSystem.models.Stocks;
import com.parishjain.StockManagementSystem.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;



    // Crud Repo
    public List<Stocks> fetchStockBySector(String stockSector) {
        return stockRepository.findByStockSector(stockSector);
    }


    // Implicit Methods in Crud Repo
    public String addStockList(List<Stocks> stocks) {
        Iterable<Stocks> list = stockRepository.saveAll(stocks);
        if(list != null) return "Added list of stocks...";
        else return "Not Added";
    }

    public List<Stocks> fetchByPriceAndDate(Double price, LocalDateTime date) {
        return stockRepository.findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockNameDesc(price,date);
    }

    public Iterable<Stocks> fetchAllStock() {
        Iterable<Stocks> stockList= stockRepository.findAll();
        return stockList;
    }

    public List<Stocks> getStocksByCap(Double capPercentage) {
        return stockRepository.getAllStocksAboveCertainMarketCap(capPercentage);
    }


    // @Transactional is an annotation in Spring Framework that allows you to manage transactions in your application.
    // Transactions are a way to group a set of operations into a single atomic unit of work, which means that either
    // all of the operations are committed to the database or none of them are.

    // In Spring Boot, you can use @Transactional to define transactional behavior for a specific method or a whole class.
    // When you add the @Transactional annotation to a method, Spring will automatically create a transaction and commit
    // or roll back the transaction based on the outcome of the method.

    // BASED ON THE ACID PROPERTY RULE ATOMICITY CONSISTENCY ISOLATION DURABILITY
    @Transactional
    public String updateMarketCap(Double marketCap, Integer id) {
        stockRepository.updateMarketCap(marketCap,id);
        return "Updated";
    }
}
