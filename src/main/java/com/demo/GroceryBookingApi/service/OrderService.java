package com.demo.GroceryBookingApi.service;

import com.demo.GroceryBookingApi.dto.OrderDTO;
import com.demo.GroceryBookingApi.entity.Item;
import com.demo.GroceryBookingApi.entity.OrderDetails;
import com.demo.GroceryBookingApi.entity.OrderItem;
import com.demo.GroceryBookingApi.repo.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ItemService itemService;

    public OrderService(OrderRepository orderRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }


    public void placeOrder(List<OrderDTO> groceryOrderRequest) {
        Map<String, Item> processedGroceryItems = new HashMap<>();
        groceryOrderRequest.stream()
                .map(orderItem -> itemService.manageInventory(orderItem.getItemName(), orderItem.getQuantity()))
                .forEach(item -> processedGroceryItems.put(item.getName(), item));

        //store the ordered items transaction
        if (!processedGroceryItems.isEmpty()) {
            OrderDetails orderDetails = new OrderDetails();
            List<OrderItem> orderItemList = groceryOrderRequest.stream()
                    .map(orderItem ->
                            new OrderItem.Builder()
                                    .item(processedGroceryItems.get(orderItem.getItemName()))
                                    .quantity(orderItem.getQuantity())
                                    .orderDetails(orderDetails)
                                    .build())
                    .toList();

            orderDetails.setOrderItems(orderItemList);
            orderRepository.save(orderDetails);
        }
    }
}
