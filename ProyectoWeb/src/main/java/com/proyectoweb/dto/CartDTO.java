package com.proyectoweb.dto;

import java.util.Set;

public class CartDTO {
    private Long id;
    private Long userId;
    private Set<CartItemDTO> items; // Lista de ítems en el carrito

    // Constructor
    public CartDTO(Long id, Long userId, Set<CartItemDTO> items) {
        this.id = id;
        this.userId = userId;
        this.items = items;
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

    public Set<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<CartItemDTO> items) {
        this.items = items;
    }
}
