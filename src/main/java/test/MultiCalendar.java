package test;
import java.util.Calendar;

public class MultiCalendar {
	public static void main(String[] s) {
		new MultiCalendar();
	}
	
	private MultiCalendar() {
		Calendar a = Calendar.getInstance();
		
		a.set(Calendar.YEAR, 2001);
		
		Calendar b = Calendar.getInstance();
		
		a.set(Calendar.YEAR, 2001);
		
		System.out.println(b.get(Calendar.YEAR));
	}
}
