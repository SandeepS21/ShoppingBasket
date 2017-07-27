package com.rbc.app.shopping.services.ifaces;

import java.math.BigDecimal;

import com.rbc.app.shopping.domain.Basket;

/**
 * Interface to manage operations while shopping activity
 *
 */
public interface ShoppingManager {

	BigDecimal getBasketCost(Basket basket);

	Integer getItemQuantity(String itemName, Basket basket);
}
