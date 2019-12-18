package test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

	public static void main(String[] args) {
		new PathsTest();
	}

	private PathsTest() {
		Path path = Paths.get("abc", "123");
		
		System.out.println(path.toString());
	}
}
