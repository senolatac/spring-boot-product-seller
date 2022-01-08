package com.sha.springbootproductseller.repository.projection;

import java.time.LocalDateTime;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:14
 */
public interface PurchaseItem
{
    String getName();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
