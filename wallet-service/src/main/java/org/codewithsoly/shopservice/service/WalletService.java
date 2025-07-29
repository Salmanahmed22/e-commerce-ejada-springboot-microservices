package org.codewithsoly.shopservice.service;

import jakarta.transaction.Transactional;
import org.codewithsoly.shopservice.model.Transaction;
import org.codewithsoly.shopservice.model.TransactionType;
import org.codewithsoly.shopservice.model.Wallet;
import org.codewithsoly.shopservice.repo.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private WalletRepo walletRepo;
    @Autowired
    private TransactionService transactionService;
    public ResponseEntity<String> create(Integer userId) {
        if (walletRepo.findByUserId(userId)) {
            return ResponseEntity.badRequest().body(null); // already exists
        }

        Wallet wallet = Wallet.builder()
                .userId(userId)
                .balance(0.0)
                .build();

        walletRepo.save(wallet);
        return ResponseEntity.ok("wallet created successfully");
    }
    @Transactional
    public ResponseEntity<Wallet> addMoney(Integer walletId, double money) {
        Wallet wallet = walletRepo.findById(walletId).get();
        wallet.setBalance(wallet.getBalance() + money);
        walletRepo.save(wallet);
        Transaction newTransaction = new Transaction();
        newTransaction.setWallet(wallet);
        newTransaction.setAmount(money);
        newTransaction.setType(TransactionType.DEPOSIT);
        newTransaction.setDescription(money + " is added to your wallet");
        transactionService.createTransaction(newTransaction);
        return ResponseEntity.ok(wallet);
    }
}
