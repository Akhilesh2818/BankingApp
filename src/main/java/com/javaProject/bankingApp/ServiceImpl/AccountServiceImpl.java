package com.javaProject.bankingApp.ServiceImpl;

import com.javaProject.bankingApp.Entity.Account;
import com.javaProject.bankingApp.Mapper.AccountMapper;
import com.javaProject.bankingApp.Repository.AccountRepository;
import com.javaProject.bankingApp.Service.AccountService;
import com.javaProject.bankingApp.dto.AccountDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override

    public AccountDto getAccountById(Long id) {
       Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
       return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id,double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
      double totalAmount=account.getBalance()+amount;
      account.setBalance(totalAmount);
      Account savedAccount=accountRepository.save(account);
      return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
        if(account.getBalance()<amount || account.getBalance()<0 )
            throw  new RuntimeException("Account balance is less");
        double balanceAmount=account.getBalance()-amount;
        account.setBalance(balanceAmount);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account))).collect(Collectors.toList());
    }
}
