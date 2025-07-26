package org.codewithsoly.shopservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private Integer userId;

    private Double balance = 0.0;
}
