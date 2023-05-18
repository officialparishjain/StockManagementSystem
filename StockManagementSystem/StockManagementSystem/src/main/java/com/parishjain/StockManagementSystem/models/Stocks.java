package com.parishjain.StockManagementSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Stocks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;
    @Column(unique = true)
    private String stockName;

    private Double stockPrice;

    private String stockSector;

    private Integer stockOwnerCount;

    private Double stockMarketCap;

    private LocalDateTime stockBirthTimeStamp;

}
