package org.codewithsoly.shopservice.repo;

import org.codewithsoly.shopservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartItem,Integer> {
}
