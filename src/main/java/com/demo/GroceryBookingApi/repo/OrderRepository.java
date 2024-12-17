package com.demo.GroceryBookingApi.repo;

import com.demo.GroceryBookingApi.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {
}
