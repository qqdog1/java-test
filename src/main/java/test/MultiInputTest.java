package test;

public class MultiInputTest {

	public static void main(String[] args) {
		new MultiInputTest();
	}
	
	private MultiInputTest() {
		inputTest(1);
	}
	
	private void inputTest(int i, String ... s) {
		System.out.println(s.length);
	}
}
