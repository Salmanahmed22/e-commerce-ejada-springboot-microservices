package org.codewithsoly.shopservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("WALLET-SERVICE")
public interface WalletInterface {
    @PostMapping("api/wallet/create/{userId}")
    public ResponseEntity<String> create(@PathVariable("userId") Integer userId);
    @GetMapping("api/wallet/{userId}")
    public ResponseEntity<Double> getUserWalletBalance(@PathVariable Integer userId);
    @PostMapping("api/wallet/update/balance/{walletId}")
    public ResponseEntity<String> updateBalance(
            @PathVariable("walletId") Integer walletId, @RequestBody double amount);
}
