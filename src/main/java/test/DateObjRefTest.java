package test;

import java.util.Calendar;
import java.util.Date;

public class DateObjRefTest {
	public static void main(String[] s) {
		new DateObjRefTest();
	}
	
	private DateObjRefTest() {
		Date date = new Date();
		
		System.out.println(date);
		
		addOneDay(date);
		
		System.out.println(date);
	}
	
	public void addOneDay(Date date) {
		Date addDate = date;
		Calendar c = Calendar.getInstance();
		c.setTime(addDate);
		c.add(Calendar.DATE, 1);
		addDate = c.getTime();
	}
}
