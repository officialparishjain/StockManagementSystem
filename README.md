# Project Name
Stock Management System

# Frameworks and Language Used
**Spring Boot** 2.1.0
**Java** 17.0
**Maven** 3.8.1

# Data Flow
The following functions are used in the data flow of this project:

_**Models:**_

The code represents a Java class named "Stocks" with the following attributes:

stockId: An Integer representing the stock's unique identifier.
stockName: A String representing the stock's name, with a unique constraint.
stockPrice: A Double representing the current price of the stock.
stockSector: A String representing the sector to which the stock belongs.
stockOwnerCount: An Integer representing the number of owners for the stock.
stockMarketCap: A Double representing the market capitalization of the stock.
stockBirthTimeStamp: A LocalDateTime object representing the timestamp of when the stock was created.

The class uses annotations such as "@Id" and "@GeneratedValue" to define the stockId attribute as the primary key and specify the generation strategy for its values. The "@Column" annotation with the "unique = true" parameter indicates that the stockName attribute should have a unique constraint in the database.

_**Controller:**_ 

Here's a summary of the controller's functionality:

The controller is responsible for managing stocks and interacts with the StockService.
It is annotated with "@RestController" to indicate that it handles RESTful requests.
The base URL for the controller is "/stock".
It has an autowired dependency of StockService.
Endpoints:

GET "/sector/{stockSector}": Retrieves a list of stocks by their sector.
POST "/addStock": Inserts a list of stocks into the system.
GET "/abovePrice/price/{price}/lowerDate/date/{date}": Retrieves stocks with a price above a specified value and a creation date lower than a specified date.
GET "/getAll": Retrieves all stocks.
GET "/cap/{capPercentage}": Retrieves stocks with a market capitalization above a specified percentage.
PUT "/updateCap/{marketCap}/id/{id}": Updates the market capitalization of a stock identified by its ID.
The controller delegates the actual business logic to the StockService, which provides the implementation for these operations.



_**Services**:_ 

Methods:

"fetchStockBySector": Retrieves a list of stocks by their sector using the stockRepository.
"addStockList": Inserts a list of stocks into the database using the stockRepository's saveAll method.
"fetchByPriceAndDate": Retrieves stocks with a price above a specified value and a creation date lower than a specified date using the stockRepository's findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockNameDesc method.
"fetchAllStock": Retrieves all stocks from the database using the stockRepository's findAll method.
"getStocksByCap": Retrieves stocks with a market capitalization above a specified percentage using the stockRepository's getAllStocksAboveCertainMarketCap method.
"updateMarketCap": Updates the market capitalization of a stock identified by its ID using the stockRepository's updateMarketCap method. The method is annotated with "@Transactional" to ensure atomicity, consistency, isolation, and durability of the transaction.
The service class encapsulates the database operations and provides an interface between the controller and the repository for managing stock-related functionality.


_**Repository**:_ 

Here's a summary of the repository interface functionality:

The interface extends the "CrudRepository" interface, which provides basic CRUD (Create, Read, Update, Delete) operations for the Stocks entity.
Methods:

"findByStockSector": Retrieves a list of stocks by their sector.
"findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockNameDesc": Retrieves stocks with a price above a specified value and a creation date lower than a specified date. The results are ordered by stock name in descending order.
"getAllStocksAboveCertainMarketCap": Retrieves stocks with a market capitalization above a specified percentage using a native SQL query.
"updateMarketCap": Updates the market capitalization of a stock identified by its ID using a native SQL query. The method is annotated with "@Modifying" to indicate that it modifies the data.

# Database Structure Used
I have H2 Database

# Project Summary
In this project i have create different endpoints like and used differet vaalidation for the end ponits



