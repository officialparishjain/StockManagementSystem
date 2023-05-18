package com.parishjain.StockManagementSystem.controller;

import com.parishjain.StockManagementSystem.models.Stocks;
import com.parishjain.StockManagementSystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    // Get stock by sector
    @GetMapping(value = "/sector/{stockSector}")
    public List<Stocks> getStockBySector(@PathVariable String stockSector){
        return stockService.fetchStockBySector(stockSector);
    }

    // Add Stocks
    @PostMapping(value = "/addStock")
    public String insertStocks(@RequestBody List<Stocks> stocks){

        return stockService.addStockList(stocks);
    }

    // Get using custom finder
    @GetMapping(value = "/abovePrice/price/{price}/lowerDate/date/{date}")
    public List<Stocks> getStockAbovePriceAndLowerDate(@PathVariable Double price ,@PathVariable LocalDateTime date){
        return stockService.fetchByPriceAndDate(price,date);
    }

    // Get All Users
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public Iterable<Stocks> getAllStocks(){
        return stockService.fetchAllStock();
    }

    @GetMapping(value="/cap/{capPercentage}")
    public List<Stocks> getAllStockWithMarketCapAbove(@PathVariable Double capPercentage){
        return stockService.getStocksByCap(capPercentage);
    }

    @PutMapping(value = "/updateCap/{marketCap}/id/{id}")
    public String updateStockMarketCapById(@PathVariable Double marketCap,@PathVariable Integer id){
        return stockService.updateMarketCap(marketCap,id);
    }



}
