package test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FilesTest {
	public static void main(String[] s) {
		new FilesTest();
	}
	
	private FilesTest() {
		String sPath = "D:/BinaryData/20150706";
		
		File file = new File(sPath);
		for(File f : file.listFiles()) {
			System.out.println(f.getName());
		}
		
		String[] s = sPath.split("/");
		
		
		try {
			Path p = Files.createSymbolicLink(Paths.get(sPath + "/" + s[s.length-1]), Paths.get(sPath));
			
			File fileSymbolic = new File(p.toString());
			
			for(File f : fileSymbolic.listFiles()) {
				System.out.println(f.getName());
			}
			
			Files.deleteIfExists(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
