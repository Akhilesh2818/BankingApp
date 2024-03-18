package com.javaProject.bankingApp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class AccountDto {
    private  Long id;
    private  String accountHolderName;
    private double balance;
}
