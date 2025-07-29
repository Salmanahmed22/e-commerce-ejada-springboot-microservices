package org.codewithsoly.shopservice.service;

import org.codewithsoly.shopservice.model.Transaction;
import org.codewithsoly.shopservice.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;


    public ResponseEntity<Transaction> createTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
        return ResponseEntity.ok(transaction);
    }
}
