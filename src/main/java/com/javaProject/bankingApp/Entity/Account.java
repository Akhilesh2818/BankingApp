package com.javaProject.bankingApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name="account_holder_name")
    private  String accountHolderName;
    @Column(name="balance")
    private double balance;

}
