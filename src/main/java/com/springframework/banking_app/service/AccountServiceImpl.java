package com.springframework.banking_app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springframework.banking_app.entity.Account;
import com.springframework.banking_app.repository.AccountRepository;
import com.springframework.dto.AccountDto;
import com.springframework.mapper.AccountMapper;

@Service
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

    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return AccountMapper.mapToAccountDto(account);
    }

    public AccountDto deposit(Long id, double amount) {
        Account account =  accountRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Account not found"));
        double updatedAmount = account.getBalance() + amount;
        account.setBalance(updatedAmount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }
    
}
