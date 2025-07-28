package org.codewithsoly.shopservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Integer productId;
    private Integer userId;
    private int quantity;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
