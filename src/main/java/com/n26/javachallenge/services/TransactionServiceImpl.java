package com.n26.javachallenge.services;

import com.n26.javachallenge.dto.Transaction;
import com.n26.javachallenge.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final long ONE_MINUTE = 60 * 1_000;
    private final TransactionRepository transactionRepository;

    @Override
    public void putTransaction(Transaction transaction) {
        if(transaction.getTimestamp() > System.currentTimeMillis() - ONE_MINUTE) {
            transactionRepository.addTransaction(transaction);
        }
    }
}