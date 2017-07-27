package com.rbc.app.shopping.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.rbc.app.shopping.exception.InvalidItemException;

/**
 * This class holds item details which user is going to shop Item is having 2
 * attributes name and item price
 */
public class Item {

	private String itemName;

	private BigDecimal itemPrice;

	public Item(String itemName, Double itemPrice) {
		if (itemName == null || itemName.trim().isEmpty()) {
			throw new InvalidItemException("Item name should not be null or empty");
		}
		if (itemPrice == null || itemPrice < 0.0) {
			throw new InvalidItemException("Item price should be null or less than 0.0");
		}
		this.itemName = itemName;
		this.itemPrice = new BigDecimal(itemPrice,new MathContext(2, RoundingMode.HALF_EVEN));
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
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
