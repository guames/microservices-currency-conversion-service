package com.guames.microservices.currencyconversionservice.protocols;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ExchangeValueResponse {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;

}
