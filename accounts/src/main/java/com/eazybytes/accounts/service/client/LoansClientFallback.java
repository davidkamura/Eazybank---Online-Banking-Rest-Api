package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansClientFallback implements LoansClient {
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String mobileNumber) {
        return null;
    }
}
