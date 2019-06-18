package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageReadTest {
	private static final String address = "";
	
	public static void main(String[] s) {
		new ImageReadTest();
	}
	
	private ImageReadTest() {
		try {
			URL url = new URL(address);
			BufferedImage bufferedImage;
			bufferedImage = ImageIO.read(url);
			ImageIO.write(bufferedImage, "jpg", new File("C:/Users/qqdog1/Desktop/test.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
