package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.User;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:42
 */
public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
