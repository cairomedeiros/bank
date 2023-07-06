package bank.bank.controller;

import bank.bank.entities.Account;
import bank.bank.service.AccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> findAllAccounts(){
        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    public Optional<Account> findAccountById(@PathVariable("id") Long id){
        return accountService.findById(id);
    }

    @PostMapping
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
    }

}
