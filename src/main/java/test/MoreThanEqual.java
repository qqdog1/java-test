package test;

public class MoreThanEqual {
	private static final int MAX = 10;
	private int iii = 9;
	
	private int iCount = 300000;
	
	public static void main(String[] s) {
		new MoreThanEqual();
	}
	
	private MoreThanEqual() {
		long lTime = System.nanoTime();
		for(int i = 0 ; i < iCount; i ++) {
			if(iii < MAX -1) {
			}
		}
		lTime = System.nanoTime() - lTime;
		System.out.println("< : " + lTime);
		
		lTime = System.nanoTime();
		for(int i = 0 ; i < iCount; i ++) {
			if(iii < MAX) {
			}
		}
		lTime = System.nanoTime() - lTime;
		System.out.println("<= : " + lTime);
	}
}
