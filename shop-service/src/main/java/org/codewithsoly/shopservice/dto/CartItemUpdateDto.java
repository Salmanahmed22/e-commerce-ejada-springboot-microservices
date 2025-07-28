package org.codewithsoly.shopservice.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemUpdateDto {
    private Integer cartItemId;
    private int quantity;
}
