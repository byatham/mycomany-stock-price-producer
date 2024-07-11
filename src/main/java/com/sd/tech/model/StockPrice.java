package com.sd.tech.model;

import org.springframework.stereotype.Component;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class StockPrice {
	
	private String name;
	private Double price;

}
