package bank.bank.controller;

import bank.bank.entities.Transaction;
import bank.bank.service.TransactionService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/save")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    @PutMapping("/update")
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }
}
