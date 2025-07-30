package org.codewithsoly.shopservice.repo;

import org.codewithsoly.shopservice.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer> {
    Wallet findByUserId(Integer userId);
}
