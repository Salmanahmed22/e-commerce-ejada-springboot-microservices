package org.codewithsoly.shopservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("WALLET-SERVICE")
public interface WalletInterface {
    @PostMapping("api/wallet/create/{userId}")
    public ResponseEntity<String> create(@PathVariable("userId") Integer userId);
    }
