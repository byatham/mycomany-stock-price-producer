package com.sd.tech.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sd.tech.service.StockPriceProducerService;

@WebMvcTest(value = StockPriceProducerController.class)
public class StockPriceProducerControllerTest {
	
	@MockBean
	private StockPriceProducerService   stockPriceProducerService;

	@Autowired
	private MockMvc mvc;
	private final  String companyName = "TCD";
	
	@Test
    void testGetStock_Success() throws Exception {
        Double stockPrice = 123.45;

        when(stockPriceProducerService.produceStockPrice()).thenReturn(stockPrice);

        mvc.perform(get("/stock/price/{name}", companyName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(companyName))
                .andExpect(jsonPath("$.price").value(stockPrice));
    }

    @Test
    void testGetStock_InternalServerError() throws Exception {

        when(stockPriceProducerService.produceStockPrice()).thenThrow(new RuntimeException("Error occurred"));

        mvc.perform(get("/stock/price/{name}", companyName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").doesNotExist())
                .andExpect(jsonPath("$.price").doesNotExist());
    }

}
