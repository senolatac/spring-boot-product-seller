package com.sha.springbootproductseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sa
 * @date 18.12.2021
 * @time 11:54
 */
@Data
@Entity
@Table(name = "purchase")
public class Purchase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)//It is only for foreign key.
    private User user;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;
}
