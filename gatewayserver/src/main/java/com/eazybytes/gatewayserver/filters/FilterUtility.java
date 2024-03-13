package com.eazybytes.gatewayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {

    public static final String CORRELATION_ID = "eazybank-correlation-id";

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if(requestHeaders.get(CORRELATION_ID) != null) {
            List<String> requestHeaderList = requestHeaders.get(CORRELATION_ID);
            assert requestHeaderList != null;
            return requestHeaderList.stream().findFirst().get();
        }
        else {
            return null;
        }
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String uuid) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, uuid).build()).build();
    }

    public ServerWebExchange bindCorrelationIdHeader(ServerWebExchange exchange, String uuid) {
        return this.setRequestHeader(exchange, CORRELATION_ID, uuid);
    }

}
