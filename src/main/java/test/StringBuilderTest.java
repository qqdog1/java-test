package test;

public class StringBuilderTest {

	public static void main(String[] args) {
		new StringBuilderTest();
	}

	private StringBuilderTest() {
		StringBuilder sb = new StringBuilder();
		sb.append("1234567890");
		
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb.toString());
	}
}
