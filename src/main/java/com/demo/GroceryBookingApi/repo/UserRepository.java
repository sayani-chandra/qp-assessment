package com.demo.GroceryBookingApi.repo;

import com.demo.GroceryBookingApi.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByEmail(String email);
}
