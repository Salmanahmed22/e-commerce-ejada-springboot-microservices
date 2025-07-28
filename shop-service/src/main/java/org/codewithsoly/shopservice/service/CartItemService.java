package org.codewithsoly.shopservice.service;

import org.codewithsoly.shopservice.dto.CartItemDto;
import org.codewithsoly.shopservice.dto.CartItemUpdateDto;
import org.codewithsoly.shopservice.model.CartItem;
import org.codewithsoly.shopservice.model.Product;
import org.codewithsoly.shopservice.repo.CartRepo;
import org.codewithsoly.shopservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    private CartRepo cartRepo;
    public ResponseEntity<String> addCartItem(CartItemDto cartItemDto) {
        CartItem newCartItem = new CartItem();
        //no need to check userId or productId as they will be sent from the frontend?
        newCartItem.setProductId(cartItemDto.getProductId());
        newCartItem.setQuantity(cartItemDto.getQuantity());
        newCartItem.setUserId(cartItemDto.getUserId());
        cartRepo.save(newCartItem);
        return ResponseEntity.ok("item is added successfully");
    }

    public ResponseEntity<CartItem> updateCartItem(CartItemUpdateDto cartItemUpdateDto) {
        CartItem updatedCartItem = cartRepo.findById(cartItemUpdateDto.getCartItemId()).orElse(null);
        updatedCartItem.setQuantity(cartItemUpdateDto.getQuantity());
        cartRepo.save(updatedCartItem);
        return ResponseEntity.ok(updatedCartItem);
    }

    public ResponseEntity<String> removeCartItem(Integer cartItemId) {
        cartRepo.deleteById(cartItemId);
        return ResponseEntity.ok("item is removed successfully");
    }
}
