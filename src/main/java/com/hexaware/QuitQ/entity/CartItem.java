package com.hexaware.QuitQ.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartitem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;
    private Integer cartItemQuantity;

    @ManyToOne
    private Product cartProduct;

    public CartItem() {
        super();
    }

    public CartItem(long cartItemId, Integer cartItemQuantity, Product cartProduct) {
        super();
        this.cartItemId = cartItemId;
        this.cartItemQuantity = cartItemQuantity;
        this.cartProduct = cartProduct;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(Integer cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    public Product getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(Product cartProduct) {
        this.cartProduct = cartProduct;
    }

    @Override
    public String toString() {
        return "CartItem [cartItemId=" + cartItemId + ", cartItemQuantity=" + cartItemQuantity + ", cartProduct="
                + cartProduct + "]";
    }
}
