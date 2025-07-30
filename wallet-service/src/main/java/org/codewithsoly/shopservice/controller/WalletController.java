package org.codewithsoly.shopservice.controller;

import org.codewithsoly.shopservice.model.Wallet;
import org.codewithsoly.shopservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    //creating wallet to registered user
    @PostMapping("create/{userId}")
    public ResponseEntity<String> create(@PathVariable("userId") Integer userId) {
        return walletService.create(userId);
    }
    @PutMapping("addMoney/{walletId}")
    public ResponseEntity<Wallet> addMoney(
            @PathVariable("walletId") Integer walletId, @RequestBody double money) {
        return walletService.addMoney(walletId,money);
    }

    @PostMapping("update/balance/{userId}")
    public ResponseEntity<String> updateBalance(
            @PathVariable("userId") Integer userId, @RequestBody double amount) {
        return walletService.updateBalance(userId,amount);
    }
    @GetMapping("{userId}")
    public ResponseEntity<Double> getUserWalletBalance(@PathVariable Integer userId) {
        return walletService.getUserWalletBalance(userId);
    }
}
