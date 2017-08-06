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
	 * This method calculates total cost of all items present in basket
	 * 
	 * @param - basket - consists list of all items to be purchased
	 * 
	 * @return - BigDecimal - total cost price for the basket items
	 */
	@Override
	public BigDecimal getBasketCost(Basket basket) throws InvalidBasketException {
		if (basket == null) {
			throw new InvalidBasketException("Basket should not be Null");
		}

		final Map<Item, Integer> items = basket.getItems();
		BigDecimal itemsCost = BigDecimal.ZERO;
		MathContext ctx = new MathContext(2, RoundingMode.HALF_EVEN);
		
		itemsCost = items.keySet().stream().map(item -> item.getItemPrice()
				.multiply(new BigDecimal(items.get(item),ctx)))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

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
	public Integer getItemQuantity(String itemName, Basket basket) 
			throws InvalidBasketException,NoItemFoundException {
		if (basket == null) {
			throw new InvalidBasketException("Basket should not be Null");
		}
		final Map<Item, Integer> items = basket.getItems();
		Integer quantity = 0;
		final Item item = new Item(itemName, new BigDecimal(0.0));
		if (items.containsKey(item)) {
			quantity = items.get(item);
		} else {
			throw new NoItemFoundException("No such item found in basket");
		}

		return quantity;
	}

}
