package com.proyectoweb.dto;

import java.util.Date;
import java.util.Set;

public class OrderDTO {
    private Long id;
    private Long userId;
    private Date orderDate;
    private Set<OrderItemDTO> items; // Lista de ítems en la orden
    private Double totalAmount;

    // Constructor
    public OrderDTO(Long id, Long userId, Date orderDate, Set<OrderItemDTO> items, Double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<OrderItemDTO> items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
