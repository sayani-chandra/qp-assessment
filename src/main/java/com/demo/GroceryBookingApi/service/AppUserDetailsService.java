package com.demo.GroceryBookingApi.service;

import com.demo.GroceryBookingApi.entity.UserInfo;
import com.demo.GroceryBookingApi.repo.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User details not found for the user "+username));
        List<SimpleGrantedAuthority> authorities = userInfo.getRoles().stream().map(a -> new SimpleGrantedAuthority(a.getRole())).collect(Collectors.toList());
        return new User(userInfo.getEmail(), userInfo.getPwd(), authorities);
    }

}
