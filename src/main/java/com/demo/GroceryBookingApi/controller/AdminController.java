package com.demo.GroceryBookingApi.controller;

import com.demo.GroceryBookingApi.entity.Item;
import com.demo.GroceryBookingApi.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    private ItemService itemService;

    public AdminController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public List<Item> addGroceryItems(@RequestBody List<Item> items) {
        for (Item item : items) {
            item.setId(0);
        }
        return itemService.saveAll(items);
    }

    @GetMapping("/items")
    public List<Item> getGroceryItems() {
        return itemService.findAll();
    }

    @DeleteMapping("/items/{itemId}")
    public String removeGroceryItem(@PathVariable int itemId){
        Item item = itemService.findById(itemId);
        if (item == null) {
            throw new RuntimeException("Item not found with id "+itemId);
        }
        itemService.deleteById(itemId);
        return "Deleted Item with id "+itemId;
    }

    @PutMapping("/items")
    public Item updateGroceryItem(@RequestBody Item item) {
        Item savedItem = itemService.save(item);
        return savedItem;
    }

    @PatchMapping("/items/{itemId}")
    public Item updateInventory(@PathVariable int itemId, @RequestBody Map<String, Integer> updates) {
        int newStock = updates.get("quantity");
        return itemService.updateStock(itemId, newStock);
    }


}
