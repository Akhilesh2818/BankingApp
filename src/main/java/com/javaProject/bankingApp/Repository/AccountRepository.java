package com.javaProject.bankingApp.Repository;

import com.javaProject.bankingApp.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
