package bank.bank.service;

import bank.bank.entities.Transaction;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction);
}
