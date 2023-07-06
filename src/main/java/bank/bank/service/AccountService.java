package bank.bank.service;

import bank.bank.entities.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAllAccounts();

    Optional<Account> findById(Long id);

    Account saveAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(Long id);
}
