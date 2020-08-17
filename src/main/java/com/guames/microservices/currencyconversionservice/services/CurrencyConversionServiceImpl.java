package com.guames.microservices.currencyconversionservice.services;

import com.guames.microservices.currencyconversionservice.exceptions.NotFoundException;
import com.guames.microservices.currencyconversionservice.protocols.CurrencyConversionResponse;
import com.guames.microservices.currencyconversionservice.protocols.ExchangeValueResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final String FROM = "from";
    private final String TO = "to";
    private final String CONVERSION_URI = "http://localhost:8082/currency-exchange/" + FROM + "/{" + FROM + "}/" + TO + "/{" + TO + "}";


    @Override
    public CurrencyConversionResponse convertCurrency(String from, String to, BigDecimal quantity) throws NotFoundException {
        Map<String, String> uriVariables = getConvertCurrencyRequestMap(from, to);
        ResponseEntity<ExchangeValueResponse> responseResponseEntity = getExchangeValueResponseFromCurrencyExchangeService(uriVariables);
        Optional<ExchangeValueResponse> exchangeValueResponse = Optional.of(responseResponseEntity.getBody());
        return CurrencyConversionResponse.of(exchangeValueResponse);
    }

    private Map<String, String> getConvertCurrencyRequestMap(String from, String to) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put(FROM, from);
        uriVariables.put(TO, to);
        return uriVariables;
    }

    private ResponseEntity<ExchangeValueResponse> getExchangeValueResponseFromCurrencyExchangeService(Map<String, String> uriVariables) {
        return new RestTemplate()
                .getForEntity(
                        CONVERSION_URI,
                        ExchangeValueResponse.class,
                        uriVariables);
    }
}
