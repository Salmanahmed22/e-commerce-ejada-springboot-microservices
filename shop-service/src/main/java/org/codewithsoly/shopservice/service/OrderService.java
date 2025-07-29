package org.codewithsoly.shopservice.service;

import org.codewithsoly.shopservice.model.CartItem;
import org.codewithsoly.shopservice.model.Order;
import org.codewithsoly.shopservice.model.OrderItem;
import org.codewithsoly.shopservice.model.Product;
import org.codewithsoly.shopservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;
    public ResponseEntity<Order> placeOrder(Integer userId) {
        Order order = new Order();
        List<CartItem> userCartItems = cartItemService.getCartItems(userId).getBody();
        order.setUserId(userId);
        List<OrderItem> orderItems = new ArrayList<>();
        double priceSum = 0;
        for (CartItem cartItem : userCartItems) {
            OrderItem orderItem = new OrderItem();
            Product product = productService.getProduct(cartItem.getProductId());
            priceSum += product.getPrice() * cartItem.getQuantity();
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProductName(product.getName());
            orderItem.setPriceAtPurchase(product.getPrice());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        order.setTotalPrice(priceSum);
        orderRepo.save(order);
        cartItemService.deleteCart(userId);
        return ResponseEntity.ok(order);
    }

    public ResponseEntity<List<Order>> getUserOrders(Integer userId) {
        List<Order> userOrders = orderRepo.findAllByUserId(userId);
        return ResponseEntity.ok(userOrders);
    }
}
