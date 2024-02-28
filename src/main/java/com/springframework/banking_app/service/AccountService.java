package com.springframework.banking_app.service;

import com.springframework.dto.AccountDto;

public interface AccountService {
    
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);
}
