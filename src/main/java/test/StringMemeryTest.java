package test;

public class StringMemeryTest {

	public static void main(String[] s) {
		String a = "abc";
		String b = a;
		System.out.println(a);
		System.out.println(b);
		
		a = null;
		System.out.println(a);
		System.out.println(b);	
	}
}
