package test;
import java.nio.ByteBuffer;


public class ByteBufferTest {
	public static void main(String[] s) {
		new ByteBufferTest();
	}
	
	private ByteBufferTest() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		
		System.out.println(byteBuffer.hasArray());
		System.out.println(new String(byteBuffer.array()));
	
		long l = Long.MAX_VALUE;
		System.out.println((int)l);
	}
}
