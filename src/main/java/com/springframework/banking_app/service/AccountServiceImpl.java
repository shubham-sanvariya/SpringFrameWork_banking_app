package com.springframework.banking_app.service;

import com.springframework.banking_app.entity.Account;
import com.springframework.banking_app.repository.AccountRepository;
import com.springframework.dto.AccountDto;
import com.springframework.mapper.AccountMapper;

public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    
}
