package com.rbc.app.shopping;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.rbc.app.shopping.domain.Item;

public class ItemTest {

	@Test
	public void testEquals() throws Exception {
		Item item1 = new Item("Banana", new BigDecimal(0.10));
		Item item2 = new Item("Banana", new BigDecimal(0.10));

		assertEquals("Items should be equal", item1, item2);

	}

	@Test
	public void testHashCode() throws Exception {
		Item item1 = new Item("Apple", new BigDecimal(0.10));
		Item item2 = new Item("Apple", new BigDecimal(0.10));

		assertEquals("Items should be equal", item1.hashCode(), item2.hashCode());

	}

	@Test
	public void testEqualsFalse() throws Exception {
		Item item1 = new Item("Apple", new BigDecimal(0.10));
		Item item2 = new Item("Banana", new BigDecimal(0.10));
		assertNotEquals("Items are not equal", item1.hashCode(), item2.hashCode());
		
	}

	
}
