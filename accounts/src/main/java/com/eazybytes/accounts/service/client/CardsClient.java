package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", url = "http://cards-service:9000" , fallback = CardsClientFallback.class)
public interface CardsClient {

    @GetMapping(path = "/api/fetch", consumes = "application/json")
    ResponseEntity<CardsDto> fetchCardDetails(
            @RequestParam String mobileNumber);

}
