package test;

import java.math.BigDecimal;

public class ArithDouble {

	public static void main(String[] args) {
		new ArithDouble();
	}
	
	public ArithDouble() {
		double d1 = 0.05;
		double d2 = 0.1;
		
		System.out.println(d1+d2);
		System.out.println(d1-d2);
		System.out.println(d1*d2);
		System.out.println(d1/d2);
		
		System.out.println("============");
		
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		
		System.out.println(b1.add(b2).doubleValue());
		System.out.println(b1.subtract(b2).doubleValue());
		System.out.println(b1.multiply(b2).doubleValue());
		System.out.println(b1.divide(b2).doubleValue());
	}

}
