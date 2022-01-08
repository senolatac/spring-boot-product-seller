package com.sha.springbootproductseller.repository;

import com.sha.springbootproductseller.model.Purchase;
import com.sha.springbootproductseller.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:13
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long>
{
    @Query("select " +
            "prd.name as name, pur.price as price, pur.purchaseTime as purchaseTime " +
            "from Purchase pur left join Product prd on prd.id = pur.productId " +
            "where pur.userId = :userId")
    List<PurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
