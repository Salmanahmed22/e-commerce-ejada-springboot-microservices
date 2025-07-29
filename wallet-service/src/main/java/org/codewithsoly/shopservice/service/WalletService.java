package org.codewithsoly.shopservice.service;

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
    private JwtService jwtService;
    public ResponseEntity<String> create(Integer userId) {
//        if (walletRepo.findByUserId(userId)) {
//            return ResponseEntity.badRequest().body(null); // already exists
//        }

        Wallet wallet = Wallet.builder()
                .userId(userId)
                .balance(0.0)
                .build();

        walletRepo.save(wallet);
        return ResponseEntity.ok("wallet created successfully");
    }

    public ResponseEntity<Wallet> addMoney(Integer walletId, Integer money) {
        Wallet wallet = walletRepo.findById(walletId).get();
        wallet.setBalance(wallet.getBalance() + money);
        walletRepo.save(wallet);
        return ResponseEntity.ok(wallet);
    }
}
