package test;
import java.util.concurrent.TimeUnit;


public class TimeUnitTest {
	
	private static final long MILLIS = 987654321;

	public static void main(String[] args) {
		new TimeUnitTest();
	}

	private TimeUnitTest() {
		int iCount = 10000;
		
		final long l = 1000L;
		
//		1436931608116
//
//
//		1436424300000
		
		System.out.println(TimeUnit.MILLISECONDS.toDays(1436424300000L));
		
		System.out.println(TimeUnit.MILLISECONDS.toDays(1436424300000L));
		System.out.println(TimeUnit.MILLISECONDS.toHours(1436931608116L));
		
		//
		for(int i = 0 ; i < iCount ; i++) {
			long lMicro = TimeUnit.MILLISECONDS.toMicros(MILLIS);
		}
		for(int i = 0 ; i < iCount ; i++) {
			long lMicro = MILLIS * l;
		}
		
		long lTime = System.nanoTime();
		//----------------------------
		
		//=========
		for(int i = 0 ; i < iCount ; i++) {
			long lMicro = MILLIS * l;
		}
		//============
		lTime = System.nanoTime() - lTime;
		
		System.out.println(lTime);
		
		
		lTime = System.nanoTime();
		
		//=========
		
		for(int i = 0 ; i < iCount ; i++) {
			long lMicro = TimeUnit.MILLISECONDS.toMicros(MILLIS);
		}
		//============
		lTime = System.nanoTime() - lTime;
		
		System.out.println(lTime);
		
		System.out.println(TimeUnitEnumTest.NANOSECONDS.toNanos(5));
		System.out.println(TimeUnitEnumTest.MICROSECONDS.toNanos(5));
	}
}
