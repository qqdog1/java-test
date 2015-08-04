package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionTest {
	public static void main(String[] s) {
		new CollectionTest();
	}
	
	private CollectionTest() {
		int iCount = 1000000;
		
		for(int i = 0 ; i < iCount ; i++) {
			getEmptyList();
		}
		
		for(int i = 0 ; i < iCount ; i++) {
			getList();
		}
		
		//=========================================
		long lTime = System.nanoTime();
		for(int i = 0 ; i < iCount ; i++) {
			getEmptyList();
		}
		lTime = System.nanoTime() - lTime;
		
		System.out.println(lTime);
		//===
		lTime = System.nanoTime();
		for(int i = 0 ; i < iCount ; i++) {
			getList();
		}
		lTime = System.nanoTime() - lTime;
		
		System.out.println(lTime);
	}
	
	private List<String> getEmptyList() {
		return Collections.emptyList();
	}
	
	private List<String> getList() {
		return new ArrayList<String>();
	}
}
