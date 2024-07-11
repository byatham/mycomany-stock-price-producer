package com.sd.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tech.model.StockPrice;
import com.sd.tech.service.StockPriceProducerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockPriceProducerController {
	
	private StockPriceProducerService stockPriceProducerService; 
	
	@Autowired
	public StockPriceProducerController(StockPriceProducerService stockPriceProducerService) {
		this.stockPriceProducerService=stockPriceProducerService;
		
	}
	
	@GetMapping(value = "/price/{name}",
			    produces = { "application/json","application/xml" })
	public ResponseEntity<StockPrice> getStock(@PathVariable("name") String name) {
		log.info("name of the company requested for company "+name);

		try {
			
			Double producedStockPrice = stockPriceProducerService.produceStockPrice();
			
			return ResponseEntity.status(HttpStatus.OK).body(new StockPrice(name, producedStockPrice));
		} catch (Exception e) {
			log.info(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StockPrice());
		}
	}}
