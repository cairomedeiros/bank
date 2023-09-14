package bank.bank.service.impl;

import bank.bank.entities.Transaction;
import bank.bank.entities.User;
import bank.bank.repository.TransactionRepository;
import bank.bank.repository.UserRepository;
import bank.bank.service.TransactionService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepository;

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction){
        System.out.println(transaction);
        User userPayer = userRepository.findById(transaction.getPayer().getId()).orElse(null);
        User userPayee = userRepository.findById(transaction.getPayee().getId()).orElse(null);
        transaction.setPayer(userPayer);
        transaction.setPayee(userPayee);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
