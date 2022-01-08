package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.security.UserPrinciple;
import com.sha.springbootproductseller.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author sa
 * @date 18.12.2021
 * @time 13:42
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User signInRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrinciple);

        User signInUser = userPrinciple.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
}
