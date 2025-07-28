package org.codewithsoly.shopservice.controller;

import org.codewithsoly.shopservice.dto.CartItemDto;
import org.codewithsoly.shopservice.dto.CartItemUpdateDto;
import org.codewithsoly.shopservice.model.CartItem;
import org.codewithsoly.shopservice.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/cart")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("add")
    public ResponseEntity<String> addCartItem(
            @RequestBody CartItemDto cartItemDto) {
        System.out.println(cartItemDto);
        return cartItemService.addCartItem(cartItemDto);
    }
    @PutMapping("update")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItemUpdateDto cartItemUpdateDto) {
        return cartItemService.updateCartItem(cartItemUpdateDto);
    }
    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> removeCartItem(@PathVariable("id") Integer cartItemID) {
        return cartItemService.removeCartItem(cartItemID);
    }
}
