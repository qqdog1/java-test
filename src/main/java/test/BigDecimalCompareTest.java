package test;

import java.math.BigDecimal;

public class BigDecimalCompareTest {

	public static void main(String[] args) {
		new BigDecimalCompareTest();
	}

	private BigDecimalCompareTest() {
		BigDecimal bigDecimal1 = new BigDecimal("0.1");
		BigDecimal bigDecimal2 = new BigDecimal("0.10");
		BigDecimal bigDecimal3 = new BigDecimal("0.11");
		BigDecimal bigDecimal4 = new BigDecimal("0.01");
		
		System.out.println(bigDecimal1.equals(bigDecimal2));
		System.out.println(bigDecimal1.compareTo(bigDecimal2));
		System.out.println(bigDecimal1.compareTo(bigDecimal3));
		System.out.println(bigDecimal1.compareTo(bigDecimal4));
	}
}
