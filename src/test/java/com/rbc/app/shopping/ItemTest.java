package com.rbc.app.shopping;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rbc.app.shopping.domain.Item;
import com.rbc.app.shopping.exception.InvalidItemException;

public class ItemTest {

	@Test(expected = InvalidItemException.class)
	public void createItemWithNullNameAndPrice() {
		Item item = new Item(null, null);
	}

	@Test(expected = InvalidItemException.class)
	public void createItemWithNullNameAndValidPrice() {
		Item item = new Item(null, 0.10);
	}

	@Test(expected = InvalidItemException.class)
	public void createItemWithValidNameAndNullPrice() {
		Item item = new Item("Test", null);
	}

	@Test(expected = InvalidItemException.class)
	public void createItemWithEmptyNameAndValidPrice() {
		Item item = new Item("", 0.10);
	}

	@Test(expected = InvalidItemException.class)
	public void createItemWithBlankSpaceNameAndPrice() {
		Item item = new Item(" ", 0.10);
	}

	@Test
	public void testEquals() throws Exception {
		Item item1 = new Item("Banana", 0.10);
		Item item2 = new Item("Banana", 0.10);
		

		assertEquals("Items should be equal", item1, item2);
		
	}

	@Test
	public void testHashCode() throws Exception {
		Item item1 = new Item("Apple", 0.10);
		Item item2 = new Item("Apple", 0.10);
		

		assertEquals("Items should be equal", item1.hashCode(), item2.hashCode());
		
	}

}
