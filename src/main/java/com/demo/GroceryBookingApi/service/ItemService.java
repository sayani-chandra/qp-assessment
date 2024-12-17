package com.demo.GroceryBookingApi.service;

import com.demo.GroceryBookingApi.entity.Item;
import com.demo.GroceryBookingApi.repo.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> saveAll(List<Item> items) {
        return itemRepository.saveAll(items);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    public Item findById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    public Item updateStock(int id, int newStock) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setQuantity(newStock);
        return itemRepository.save(item);
    }

    public Item findByName(String name) {
        Optional<Item> item = itemRepository.findByName(name);
        return item.orElse(null);
    }

    public Item manageInventory(String name, int quantity) {
        Item item = findByName(name);
        int itemQuantity = item.getQuantity();
        if(quantity > itemQuantity){
            throw new RuntimeException("Ordered quantity is more than available quantity");
        }
        item.setQuantity(itemQuantity - quantity);
        return itemRepository.save(item);
    }

}

