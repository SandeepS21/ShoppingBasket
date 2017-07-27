package com.rbc.app.shopping.services.impls;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import com.rbc.app.shopping.domain.Basket;
import com.rbc.app.shopping.domain.Item;
import com.rbc.app.shopping.exception.InvalidBasketException;
import com.rbc.app.shopping.exception.NoItemFoundException;
import com.rbc.app.shopping.services.ifaces.ShoppingManager;

/**
 * This is concrete implementation of ShoppingManager interface
 *
 */
public class ShoppingManagerImpl implements ShoppingManager {

	/*
	 * This method calculate total cost of all items present in basket
	 * 
	 * @param - basket - consists list of all items to be purchased
	 * 
	 * @return - BigDecimal - total cost price for the basket items
	 */
	@Override
	public BigDecimal getBasketCost(Basket basket) {
		if (basket == null) {
			throw new InvalidBasketException("Basket should not be Null");
		}

		final Map<Item, Integer> items = basket.getItems();
		BigDecimal itemsCost = BigDecimal.ZERO;
		MathContext ctx = new MathContext(2, RoundingMode.HALF_EVEN);

		for (Map.Entry<Item, Integer> item : items.entrySet()) {
			itemsCost = itemsCost.add(item.getKey().getItemPrice()
					.multiply(new BigDecimal(item.getValue(),ctx)));
		}
		return itemsCost;
	}

	/*
	 * This method provide item quantity based upon given item name
	 * 
	 * @param - itemName - Name of item name which want to be lookup
	 * 
	 * @param - basket - Collection of items
	 * 
	 * @return - Integer - item quantity
	 */
	@Override
	public Integer getItemQuantity(String itemName, Basket basket) {
		if (basket == null) {
			throw new InvalidBasketException("Basket should not be Null");
		}

		final Map<Item, Integer> items = basket.getItems();
		Integer quantity = 0;
		Item item = new Item(itemName, 0.0);
		if (items.containsKey(item)) {
			quantity = items.get(item);
		} else {

			throw new NoItemFoundException("No such item found in basket");
		}

		return quantity;
	}

}
