package com.sd.tech;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/stock")
public class MycomanyStockPriceApplication {
	StringBuilder company;

	public static void main(String[] args) {
		SpringApplication.run(MycomanyStockPriceApplication.class, args);
	}

	@GetMapping("/price")
	public ResponseEntity<Map<String, Double>> getStock(@RequestParam String name) {
		Map<String, Double> companyStockMap = new HashMap<>();

		try {
			Random r = new Random(System.currentTimeMillis());
			Double stockPrice = r.nextInt(100000) * 3.19;
			companyStockMap.put(name.toUpperCase(), stockPrice);

			System.out.println(
					"******************** stockPrice in MycomanyStockPriceApplication *********** " + companyStockMap);
			return ResponseEntity.status(HttpStatus.CREATED).body(companyStockMap);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HashMap<String, Double>());
		}

	}

}
