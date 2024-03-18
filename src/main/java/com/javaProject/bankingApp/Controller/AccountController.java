package com.javaProject.bankingApp.Controller;

import com.javaProject.bankingApp.Service.AccountService;
import com.javaProject.bankingApp.dto.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.create(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccount(@PathVariable Long id)
    {
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}/deposit")
    public  ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request)
    {
            Double amount=request.get("amount");
            AccountDto accountDto=accountService.deposit(id,amount);
            return  ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id,@RequestBody Map<String,Double> request)
    {
        Double withDrawAmount = request.get("withDrawAmount");
        AccountDto accountDto=accountService.withDraw(id,withDrawAmount);
        return ResponseEntity.ok(accountDto);

    }

    @GetMapping("/allAccounts")
    public  ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return  ResponseEntity.ok(accounts);
    }
}
