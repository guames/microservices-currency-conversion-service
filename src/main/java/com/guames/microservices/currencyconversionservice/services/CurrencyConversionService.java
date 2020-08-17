package com.guames.microservices.currencyconversionservice.services;

import com.guames.microservices.currencyconversionservice.exceptions.NotFoundException;
import com.guames.microservices.currencyconversionservice.protocols.CurrencyConversionResponse;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    CurrencyConversionResponse convertCurrency(String from, String to, BigDecimal quantity) throws NotFoundException ;
}