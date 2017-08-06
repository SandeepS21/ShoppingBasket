package com.rbc.app.shopping.domain;

import java.util.HashMap;

/**
 * Basket class represents collection of Items This class provides addItem and
 * clear facilities on Basket
 */
public class Basket {

	private HashMap<Item, Integer> basketItems;

	public Basket() {
		this.basketItems = new HashMap<Item, Integer>();
	}

	public Basket(HashMap<Item, Integer> basketItems) {
		this.basketItems = basketItems;
	}

	public HashMap<Item, Integer> getItems() {
		return basketItems;
	}

	/**
	 * This method adds item to basket and if the
	 * same item already present in basket then it increments
	 * item count by 1
	 */
	public void addItemToBasket(Item item) {
		if (basketItems.containsKey(item)) {
			basketItems.replace(item, basketItems.get(item) + 1);
		} else {
			basketItems.put(item, 1);
		}
	}

	/**
	 * This method makes basket empty
	 */
	public void clearBasket() {
		basketItems.clear();
	}
}
