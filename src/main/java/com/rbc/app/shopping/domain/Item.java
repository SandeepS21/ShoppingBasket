package com.rbc.app.shopping.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class holds details of item, which user is going to shop Item is having
 * 2 attributes name and item price
 */
public class Item {

	private String itemName;

	private BigDecimal itemPrice;

	/**
	 * Constructor for Item class, which sets values to attributes 
	 * @param itemName
	 * @param itemPrice
	 */
	public Item(String itemName, BigDecimal itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice.setScale(2, RoundingMode.HALF_EVEN);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item Details :- [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}

}
