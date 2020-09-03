package test;

public class StringBufferTest {

	public static void main(String[] args) {
		new StringBufferTest();
	}
	
	private StringBufferTest() {
		StringBuffer sb = new StringBuffer();
		sb.insert(0, true);
		
		System.out.println(sb.toString());
		System.out.println(sb.reverse());
	}

}
