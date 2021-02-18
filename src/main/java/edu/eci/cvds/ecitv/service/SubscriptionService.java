package edu.eci.cvds.ecitv.service;

import java.math.BigDecimal;
import java.util.Hashtable;

import edu.eci.cvds.ecitv.model.SubscriptionCategory;

/**
 * Subscription Service class in charge of calculating the monthly subscription.
 */
public class SubscriptionService {

	private Hashtable<SubscriptionCategory, Integer> costs;

	public SubscriptionService() {
		costs = new Hashtable<SubscriptionCategory, Integer>();
		costs.put(SubscriptionCategory.SILVER, 15000);
		costs.put(SubscriptionCategory.GOLD, 20000);
		costs.put(SubscriptionCategory.DIAMOND, 30000);
	}

	/**
	 * Calculate the cost of sucribing for the tc service, depending on the
	 * subscription category and the age of the client.
	 *
	 * @param age         the age of the client
	 * @param subCategory The subscription category
	 * @return The amount to be charged to the client
	 */
	public BigDecimal calculateCost(final Integer age, final SubscriptionCategory subCategory) {
		float percentage = 0;
		if (age <= 17) {
			percentage = 0;
		} else if (18 <= age && age <= 25) {
			percentage = 0.15f;
		} else if (26 <= age && age <= 30) {
			percentage = 0.12f;
		} else if (31 <= age && age <= 60) {
			percentage = 0.1f;
		} else if (age >= 61) {
			percentage = 0.2f;
		}
		return new BigDecimal(costs.get(subCategory) * (1 - percentage));
	}

	/*
	 * Tip: Siempre que se desee realizar cálculos matemáticos de alta precisión
	 * (por ejemplo para temas de dinero) es mucho más confiable usar el tipo de
	 * dato BigDecimal, pues soporta un alto rango de número, decimales y tiene
	 * mayor precisión en los cálculos. <br /> Ejemplos básicos de operaciones con
	 * BigDecimal, teniendo las variables `bd1` y `bd2`: <ul> <li>Creación:
	 * <code>BigDecimal nuevo = new BigDecimal(10);</code></li> <li>Sumas:
	 * <code>BigDecimal suma = bd1.add(bd2);</code></li> <li>Restas:
	 * <code>BigDecimal resta = bd1.subtract(bd2);</code></li> <li>Multiplicación:
	 * <code>BigDecimal multiplicacion = bd1.multiply(bd2);</code></li>
	 * <li>División: <code>BigDecimal division = bd1.divide(bd2);</code></li> </ul>
	 */
}