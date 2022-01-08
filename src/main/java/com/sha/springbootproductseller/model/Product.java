package com.sha.springbootproductseller.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author sa
 * @date 18.12.2021
 * @time 11:51
 */
@Data
@Entity
@Table(name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    //private Set<Purchase> purchaseList;
}
