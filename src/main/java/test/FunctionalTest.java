package test;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalTest {

	public static void main(String[] s) {
		new FunctionalTest();
	}
	
	private FunctionalTest() {
		passMethod(1, 5, this::methodA);
	}
	
	public void passMethod(int x, int y, Function <Integer, Void> f) {
		for(int i = x ; i < y ; i++) {
			try {
				f.apply(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Void methodA(int x) {
		System.out.println(x);
		return null;
	}
}
