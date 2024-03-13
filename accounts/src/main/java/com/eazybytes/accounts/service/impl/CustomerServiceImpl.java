package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Account;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.CustomerService;
import com.eazybytes.accounts.service.client.CardsClient;
import com.eazybytes.accounts.service.client.LoansClient;
import lombok.AllArgsConstructor;
import org.bouncycastle.crypto.agreement.ECDHCUnifiedAgreement;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private AccountRepository accountRepository;

    private CustomerRepository customerRepository;

    private CardsClient cardsClient;

    private LoansClient loansClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));

        if(cardsClient.fetchCardDetails(mobileNumber) != null) {
            customerDetailsDto.setCardsDto(cardsClient.fetchCardDetails(mobileNumber).getBody());
        }

        if(loansClient.fetchLoanDetails(mobileNumber) != null) {
            customerDetailsDto.setLoansDto(loansClient.fetchLoanDetails(mobileNumber).getBody());
        }

        return customerDetailsDto;
    }
}
