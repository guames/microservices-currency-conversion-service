package com.guames.microservices.currencyconversionservice.controllers;

import com.guames.microservices.currencyconversionservice.exceptions.NotFoundException;
import com.guames.microservices.currencyconversionservice.protocols.CurrencyConversionResponse;
import com.guames.microservices.currencyconversionservice.services.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-converter")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrency(@PathVariable String from, @PathVariable String to,
                                                      @PathVariable BigDecimal quantity) throws NotFoundException {
        return currencyConversionService.convertCurrency(from, to, quantity);
    }
}
