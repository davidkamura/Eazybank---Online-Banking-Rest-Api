package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Make sure to change the host from localhost to cards-service while running in a container
 */
@FeignClient(name = "loans", url = "http://loans-service:8090/", fallback = LoansClientFallback.class)
public interface LoansClient {

    @GetMapping(path = "/api/fetch", consumes = "application/json")
    ResponseEntity<LoansDto> fetchLoanDetails(
            @RequestParam String mobileNumber);

}
