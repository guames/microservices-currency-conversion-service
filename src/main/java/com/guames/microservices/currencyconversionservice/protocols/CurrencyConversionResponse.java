package com.guames.microservices.currencyconversionservice.protocols;

import com.guames.microservices.currencyconversionservice.exceptions.NotFoundException;
import lombok.*;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyConversionResponse {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;

    public static CurrencyConversionResponse of(Optional<ExchangeValueResponse> exchangeValue) throws NotFoundException {
        return exchangeValue.map(exchangeVal -> CurrencyConversionResponse.builder()
                .id(exchangeVal.getId())
                .from(exchangeVal.getFrom())
                .to(exchangeVal.getTo())
                .conversionMultiple(exchangeVal.getConversionMultiple())
                .port(exchangeVal.getPort())
                .build())
                .orElseThrow(NotFoundException::new);
    }
}
