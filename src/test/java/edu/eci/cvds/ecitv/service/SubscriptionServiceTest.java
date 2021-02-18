package edu.eci.cvds.ecitv.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import edu.eci.cvds.ecitv.model.SubscriptionCategory;

/**
 * Test class for {@link SubscriptionService}
 */
public class SubscriptionServiceTest {

	/**
	 * The class under test.
	 */
	private SubscriptionService service = new SubscriptionService();

	// @Test
	public void test() {
		Assert.assertEquals(BigDecimal.ZERO, service.calculateCost(null, null));
	}

	@Test
	public void CalculoMenoresDeEdad() {
		Assert.assertEquals(new BigDecimal(15000), service.calculateCost(0, SubscriptionCategory.SILVER));
		Assert.assertEquals(new BigDecimal(20000), service.calculateCost(17, SubscriptionCategory.GOLD));
	}

	@Test
	public void Calculo18a25Años() {
		Assert.assertEquals(new BigDecimal(11748.375), service.calculateCost(18, SubscriptionCategory.SILVER));
		Assert.assertEquals(new BigDecimal(25500), service.calculateCost(20, SubscriptionCategory.DIAMOND));
		Assert.assertEquals(new BigDecimal(11748.375), service.calculateCost(25, SubscriptionCategory.SILVER));
	}

	@Test
	public void Calculo26a30Años() {
		Assert.assertEquals(new BigDecimal(17600), service.calculateCost(26, SubscriptionCategory.GOLD));
		Assert.assertEquals(new BigDecimal(13200), service.calculateCost(28, SubscriptionCategory.SILVER));
		Assert.assertEquals(new BigDecimal(13200), service.calculateCost(30, SubscriptionCategory.SILVER));
	}

	@Test
	public void Calculo31a60Años() {
		Assert.assertEquals(new BigDecimal(27000), service.calculateCost(31, SubscriptionCategory.DIAMOND));
		Assert.assertEquals(new BigDecimal(18000), service.calculateCost(40, SubscriptionCategory.GOLD));
		Assert.assertEquals(new BigDecimal(13500), service.calculateCost(60, SubscriptionCategory.SILVER));
	}

	@Test
	public void CalculoMasDe60Años() {
		Assert.assertEquals(new BigDecimal(16000), service.calculateCost(61, SubscriptionCategory.GOLD));
		Assert.assertEquals(new BigDecimal(12000), service.calculateCost(70, SubscriptionCategory.SILVER));
	}
}