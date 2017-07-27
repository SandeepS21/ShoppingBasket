package com.rbc.app.shopping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rbc.app.shopping.domain.Basket;
import com.rbc.app.shopping.domain.Item;
import com.rbc.app.shopping.exception.InvalidItemException;

public class BasketTest {

	private Basket basket;

	@Before
	public void setUp() throws Exception {
		basket = new Basket();
	}

	@Test
	public void add1ItemToBasket() {
		Item item = new Item("Apple", 0.60);
		basket.addItemToBasket(item);

		assertEquals("Should have 1 item", 1, basket.getItems().size());
	}

	@Test
	public void add2DiffItemsToBasket() {
		Item item1 = new Item("Apple", 0.60);
		Item item2 = new Item("banana", 0.40);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);

		assertEquals("Should have 1 item", 2, basket.getItems().size());
	}

	@Test
	public void add2ItemsOfSameType() {
		Item item1 = new Item("Apple", 0.60);
		Item item2 = new Item("Apple", 0.60);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);

		assertEquals("Should have 1 item with qty as 2", 1, basket.getItems().size());
		assertEquals("Should have 1 item with qty as 2", new Integer(2), basket.getItems().get(item1));
	}

	@Test(expected = InvalidItemException.class)
	public void addNullItem() {
		basket.addItemToBasket(null);
	}

	@Test(expected = InvalidItemException.class)
	public void addItemWithEmptyName() {
		Item item = new Item("", 0.60);
		basket.addItemToBasket(item);

	}

	@Test
	public void clearsAllItemsFromTheBasket() {
		Item item = new Item("Apple", 0.60);
		basket.addItemToBasket(item);
		assertTrue(basket.getItems().size() > 0);
		basket.clearBasket();
		assertEquals("Basket must be empty", 0, basket.getItems().size());
	}

	@Test(expected = InvalidItemException.class)
	public void addItemWithNameAsBlankSpace() {
		Item item = new Item(" ", 0.60);
		basket.addItemToBasket(item);
	}

}
