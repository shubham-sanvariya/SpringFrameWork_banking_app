package com.springframework.banking_app.service;

import java.util.List;

import com.springframework.dto.AccountDto;

public interface AccountService {
    
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccountDtos();

    void deleteAccount(Long id);
}
