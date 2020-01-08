package test.enumTest;

public class EnumTest {

	public static void main(String[] args) {
		new EnumTest();
	}

	private EnumTest() {
		TestEnum testEnum = TestEnum.valueOf("D");
		System.out.println(testEnum);
	}
}
