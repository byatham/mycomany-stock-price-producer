package com.sd.tech.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class StockPriceProducerService {
	
	public Double produceStockPrice()
	{
		Random r = new Random(System.currentTimeMillis());
		return  r.nextInt(100000) * 3.19;
		
	}

}
