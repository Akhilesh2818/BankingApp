package com.javaProject.bankingApp.Service;

import com.javaProject.bankingApp.Entity.Account;
import com.javaProject.bankingApp.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {
    AccountDto create(AccountDto accout);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);

    AccountDto withDraw(Long id,double amount);

    List<AccountDto> getAllAccounts();
}
