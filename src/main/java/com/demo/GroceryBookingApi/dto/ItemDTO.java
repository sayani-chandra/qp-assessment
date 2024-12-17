package com.demo.GroceryBookingApi.dto;

public class ItemDTO {

    String name;
    String price;
    int quantity;

    public ItemDTO(String name, String price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
