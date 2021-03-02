package com.pruebatecnica.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebatecnica.domain.Market;





public interface MarketRepository extends JpaRepository<Market, String> {

@Query("select AVG(price) from Market")
Integer priceAvg();
}
