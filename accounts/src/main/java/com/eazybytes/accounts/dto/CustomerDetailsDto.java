package com.eazybytes.accounts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(name = "Customer_Data",
        description = "An aggregate of all accounts, loans, cards and customer info")
@Data
public class CustomerDetailsDto {

    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @JsonProperty("accountDetails")
    private AccountsDto accountsDto;

    @JsonProperty("cardsDetails")
    private CardsDto cardsDto;

    @JsonProperty("loansDetails")
    private LoansDto loansDto;

}
