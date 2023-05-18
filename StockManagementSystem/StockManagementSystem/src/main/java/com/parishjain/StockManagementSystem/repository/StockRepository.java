package com.parishjain.StockManagementSystem.repository;

import com.parishjain.StockManagementSystem.models.Stocks;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface StockRepository extends CrudRepository<Stocks,Integer> {


    public List<Stocks> findByStockSector(String stockSector);

    // Custom Finder
    public List<Stocks> findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockNameDesc(Double price, LocalDateTime date);

    // Custom Queries : native

    @Query(value = "select * from stocks where STOCK_MARKET_CAP> :capPercentage",nativeQuery = true)
    public List<Stocks> getAllStocksAboveCertainMarketCap(Double capPercentage);


    // Update bu custom Query
    @Modifying
    @Query(value = "update STOCKS set STOCK_MARKET_CAP = :capPercentage where STOCK_ID= :id",nativeQuery = true)
    public void updateMarketCap(Double capPercentage,Integer id);



}
