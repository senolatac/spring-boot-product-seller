package com.sha.springbootproductseller.security;

import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.service.UserService;
import com.sha.springbootproductseller.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:42
 */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        //UserDetails
        return UserPrinciple.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
