package com.sha.springbootproductseller.controller;

import com.sha.springbootproductseller.model.Purchase;
import com.sha.springbootproductseller.security.UserPrinciple;
import com.sha.springbootproductseller.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * @author sa
 * @date 18.12.2021
 * @time 16:14
 */
@RestController
@RequestMapping("api/purchase") //pre-path
public class PurchaseController
{
    @Autowired
    private PurchaseService purchaseService;


    @PostMapping //api/purchase
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping //api/purchase
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrinciple userPrinciple)
    {
        return ResponseEntity.ok(purchaseService.findPurchaseItemsOfUser(userPrinciple.getId()));
    }
}
