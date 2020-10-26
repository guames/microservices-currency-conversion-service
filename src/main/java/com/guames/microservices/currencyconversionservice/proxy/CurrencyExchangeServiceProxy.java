package com.guames.microservices.currencyconversionservice.proxy;

import com.guames.microservices.currencyconversionservice.protocols.ExchangeValueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8082")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("from/{from}/to/{to}")
    ExchangeValueResponse retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
