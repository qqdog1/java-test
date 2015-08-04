package test;
import java.util.Arrays;


public class SplitStringTest {
	
	private static final String s = "123,223,323,asfd,asdf,safd,f,gw,gw,gwhwherf,sdf";
	
	public static void main(String[] s) {
		new SplitStringTest();
	}
	
	private SplitStringTest() {
		
		
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
        
        //=====================
        lTime = System.nanoTime();
        String[] ss = s.split(",");
        
        lTime = System.nanoTime() - lTime;
        
        System.out.println(lTime);
	}
}
