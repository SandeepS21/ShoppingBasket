package com.rbc.app.shopping.services.ifaces;

import java.math.BigDecimal;

import com.rbc.app.shopping.domain.Basket;
import com.rbc.app.shopping.exception.InvalidBasketException;
import com.rbc.app.shopping.exception.NoItemFoundException;

/**
 * Interface to manage operations while shopping activity
 *
 */
public interface ShoppingManager {

	BigDecimal getBasketCost(Basket basket) throws InvalidBasketException;

	Integer getItemQuantity(String itemName, Basket basket) throws InvalidBasketException, NoItemFoundException;
}
