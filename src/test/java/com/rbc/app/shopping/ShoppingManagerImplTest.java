package com.rbc.app.shopping;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.rbc.app.shopping.domain.Basket;
import com.rbc.app.shopping.domain.Item;
import com.rbc.app.shopping.exception.InvalidBasketException;
import com.rbc.app.shopping.exception.InvalidItemException;
import com.rbc.app.shopping.exception.NoItemFoundException;
import com.rbc.app.shopping.services.ifaces.ShoppingManager;
import com.rbc.app.shopping.services.impls.ShoppingManagerImpl;

public class ShoppingManagerImplTest {
	private ShoppingManager shoppingManager;

	@Before
	public void setUp() throws Exception {
		shoppingManager = new ShoppingManagerImpl();

	}

	@Test
	public void getBasketCostWithNoItems() throws Exception {
		Basket basket = new Basket();
		BigDecimal actual = shoppingManager.getBasketCost(basket);
		BigDecimal expected = new BigDecimal(0, new MathContext(2, RoundingMode.HALF_EVEN));
		assertTrue("Price should be 0", actual.compareTo(expected) == 0);
	}

	@Test(expected = InvalidBasketException.class)
	public void getBasketCostWithNullItems() throws Exception {
		BigDecimal price = shoppingManager.getBasketCost(null);
	}

	@Test
	public void getBasketCostWithOneItem() throws Exception {
		Basket basket = new Basket();
		Item item = new Item("Banana", 0.80);
		basket.addItemToBasket(item);

		BigDecimal actual = shoppingManager.getBasketCost(basket);
		BigDecimal expected = new BigDecimal(0.80, new MathContext(2, RoundingMode.HALF_EVEN));
		assertTrue("Price should be 0.80", actual.compareTo(expected) == 0);
	}

	@Test
	public void getBasketCostWith1Item3Quanity() throws Exception {
		Basket basket = new Basket();
		String name = "Banana";
		double price = 0.20;
		Item item1 = new Item(name, price);
		Item item2 = new Item(name, price);
		Item item3 = new Item(name, price);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);
		basket.addItemToBasket(item3);

		BigDecimal expected = new BigDecimal(0.60, new MathContext(2, RoundingMode.HALF_EVEN));
		BigDecimal actual = shoppingManager.getBasketCost(basket);

		assertTrue("Price should be 0.60", actual.compareTo(expected) == 0);
	}

	@Test
	public void getBasketCostWith3ItemQuanity1each() throws Exception {
		Basket basket = new Basket();
		Item item1 = new Item("Banana", 0.20);
		Item item2 = new Item("Apple", 0.30);
		Item item3 = new Item("Orange", 0.60);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);
		basket.addItemToBasket(item3);

		BigDecimal actual = shoppingManager.getBasketCost(basket);
		BigDecimal expected = new BigDecimal(1.10, new MathContext(2, RoundingMode.HALF_EVEN));
		assertTrue("Price should be 1.10", actual.compareTo(expected) == 0);

	}

	@Test
	public void getBasketCostWithMultiItemMultiQuanity() throws Exception {
		Basket basket = new Basket();
		Item item1 = new Item("Banana", 0.20);
		Item item2 = new Item("Apple", 0.30);
		Item item3 = new Item("Orange", 0.50);
		Item item4 = new Item("Banana", 0.20);
		Item item5 = new Item("Orange", 0.50);
		Item item6 = new Item("Orange", 0.50);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);
		basket.addItemToBasket(item3);
		basket.addItemToBasket(item4);
		basket.addItemToBasket(item5);
		basket.addItemToBasket(item6);

		BigDecimal actual = shoppingManager.getBasketCost(basket);
		BigDecimal expected = new BigDecimal(2.20, new MathContext(2, RoundingMode.HALF_EVEN));
		assertTrue("Price should be 2.20", actual.compareTo(expected) == 0);

	}

	@Test(expected = InvalidBasketException.class)
	public void getQuantityForEmptyBasket() throws Exception {
		Integer qty = shoppingManager.getItemQuantity("Banana", null);
	}

	@Test
	public void getQuantityForAvailableItem() throws Exception {
		Basket basket = new Basket();
		Item item1 = new Item("Banana", 0.60);
		Item item2 = new Item("Banana", 0.50);
		Item item3 = new Item("Orange", 0.40);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);
		basket.addItemToBasket(item3);

		Integer actual = shoppingManager.getItemQuantity("Banana", basket);
		Integer expected = 2;
		assertTrue("Quantity should be 2", actual.compareTo(expected) == 0);

	}

	@Test(expected = NoItemFoundException.class)
	public void getQuantityForNotAvailableItem() throws Exception {
		Basket basket = new Basket();
		Item item1 = new Item("Banana", 0.60);
		Item item2 = new Item("Banana", 0.50);
		Item item3 = new Item("Orange", 0.40);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);
		basket.addItemToBasket(item3);

		Integer actual = shoppingManager.getItemQuantity("Apple", basket);

	}

	@Test(expected = InvalidItemException.class)
	public void getQuantityForInvalidItem() throws Exception {
		Basket basket = new Basket();
		Item item1 = new Item("Banana", 0.60);
		Item item2 = new Item("Banana", 0.50);
		Item item3 = new Item("Orange", 0.40);
		basket.addItemToBasket(item1);
		basket.addItemToBasket(item2);
		basket.addItemToBasket(item3);

		Integer actual = shoppingManager.getItemQuantity(null, basket);

	}

}
