package com.demo.GroceryBookingApi.controller;

import com.demo.GroceryBookingApi.dto.ItemDTO;
import com.demo.GroceryBookingApi.dto.OrderDTO;
import com.demo.GroceryBookingApi.service.ItemService;
import com.demo.GroceryBookingApi.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private OrderService orderService;
    private ItemService itemService;

    public UserController(OrderService orderService, ItemService itemService) {
        this.orderService = orderService;
        this.itemService = itemService;
    }

    @GetMapping("/availableItems")
    public List<ItemDTO> getGroceryItems() {
        return itemService.findAll().stream().filter(item -> item.getQuantity() > 0)
                .map(item -> new ItemDTO(item.getName(),
                        item.getPrice(), item.getQuantity())).collect(Collectors.toList());
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody List<OrderDTO> groceryOrderRequest) {
        orderService.placeOrder(groceryOrderRequest);
        return "Order Placed";
    }
}
