package test.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToObject {
	private ObjectToObject() {
		moreToLess();
		lessToMore();
	}
	
	private void lessToMore() {
		ObjectMapper objectMapper = new ObjectMapper();
		Object2 o2 = getObject2();
		
		String s2 = "";
		try {
			s2 = objectMapper.writeValueAsString(o2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(s2);
		
		Object1 o1 = null;
		try {
			o1 = objectMapper.readValue(s2, Object1.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(o1 != null) {
			System.out.println(o1.getName());
			System.out.println(o1.getId());
			System.out.println(o1.getValue());
		}
	}
	
	private void moreToLess() {
		ObjectMapper objectMapper = new ObjectMapper();
		Object1 o1 = getObject1();
		
		String s1 = "";
		try {
			s1 = objectMapper.writeValueAsString(o1);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(s1);
		
		Object2 o2 = null;
		try {
			o2 = objectMapper.readValue(s1, Object2.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(o2 != null) {
			System.out.println(o2.getName());
			System.out.println(o2.getId());
		}
	}
	
	private Object1 getObject1() {
		Object1 o1 = new Object1();
		o1.setName("QQQQQ1");
		o1.setId(123);
		o1.setValue("VAVAAVAVAAVAAVA");
		return o1;
	}
	
	private Object2 getObject2() {
		Object2 o2 = new Object2();
		o2.setName("22222AAAA");
		o2.setId(999);
		return o2;
	}
	
	public static void main(String[] s) {
		new ObjectToObject();
	}
}
