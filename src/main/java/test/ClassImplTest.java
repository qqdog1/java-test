package test;

import java.io.IOException;

import test.interfac.TestInterface;

public class ClassImplTest {
	public static void main(String[] s) throws Exception {
		new ClassImplTest();
	}
	
	public ClassImplTest() throws Exception {
			@SuppressWarnings("unchecked")
//			Class<TestInterface> clazz = (Class<TestInterface>) ClassLoader.getSystemClassLoader().loadClass("./test/TestInterfaceImpl.java");
			
			String s = "TestInterfaceImpl.java";
			Class c = Class.forName(s);
			System.out.println(TestInterface.class.isAssignableFrom(c));
			
			System.out.println("abc");
	}
}
