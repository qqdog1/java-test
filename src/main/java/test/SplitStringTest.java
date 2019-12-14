package test;

import java.util.Arrays;

public class SplitStringTest {

	private static final String s = "123,223,323,asfd,asdf,safd,f,gw,gw,gwhwherf,sdf";
	private static final String s2 = "aaaaaaaa";

	public static void main(String[] s) {
		new SplitStringTest();
	}

	private SplitStringTest() {
//		testSpace();
		test2();
	}

	private void test1() {
		int index, lastIndex = 0, i = 0;

		String[] stringArray = new String[11];

		long lTime = System.nanoTime();

		while ((index = s.indexOf(',', lastIndex)) != -1) {
			stringArray[i] = s.substring(lastIndex, index);
			lastIndex = index + 1;
			i++;
		}
		stringArray[i] = s.substring(lastIndex);

		lTime = System.nanoTime() - lTime;

		System.out.println(lTime);

		// =====================
		lTime = System.nanoTime();
		String[] ss = s.split(",");

		lTime = System.nanoTime() - lTime;

		System.out.println(lTime);
	}
	
	private void testSpace() {
		String s = " 1 2 3 4 ";
		String[] ss = s.split(" ");
		for(String t : ss) {
			System.out.println(t);
		}
		
		System.out.println("++++++++++++++");
		
		ss = s.trim().split(" ");
		for(String t : ss) {
			System.out.println(t);
		}
	}
	
	private void test2() {
		String[] ssss = s2.split("Q");
		System.out.println(ssss.length);
		System.out.println(ssss[0]);
	}
}
