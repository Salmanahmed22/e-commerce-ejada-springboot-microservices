package org.codewithsoly.shopservice.repo;

import org.codewithsoly.shopservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByUserId(Integer userId);

    void deleteByUserId(Integer userId);
}
