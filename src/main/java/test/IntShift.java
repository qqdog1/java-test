package test;

public class IntShift {
	public static void main(String[] s) {
		new IntShift();
	}
	
	private IntShift() {
		int i = 5;
		
		i = i&2;
		
		System.out.println(i);
	}
}
