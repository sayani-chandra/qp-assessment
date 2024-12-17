package com.demo.GroceryBookingApi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemOrderId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private OrderItem(Builder builder) {
        this.quantity = builder.quantity;
        this.orderDetails = builder.orderDetails;
        this.item = builder.item;
    }

    public static class Builder {
        private int quantity;
        private OrderDetails orderDetails;
        private Item item;

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder item(Item item) {
            this.item = item;
            return this;
        }

        public Builder orderDetails(OrderDetails orderDetails) {
            this.orderDetails = orderDetails;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }

}
