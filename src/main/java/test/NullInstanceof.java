package test;

public class NullInstanceof {

	
	
	public static void main(String[] s) {
		new NullInstanceof();
	}
	
	private NullInstanceof() {
		try {
			throw null;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
