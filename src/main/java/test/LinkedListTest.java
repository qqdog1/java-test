package test;

import java.util.LinkedList;

public class LinkedListTest {
	private LinkedList<String> lst = new LinkedList<>();
	
	public static void main(String[] s) {
		new LinkedListTest();
	}
	
	private LinkedListTest() {
		lst.add("a");
		lst.add("b");
		lst.add("c");
		
		for(String s : lst) {
			System.out.println(s);
		}
		
		firstToLast();
		
		for(String s : lst) {
			System.out.println(s);
		}
	}
	
	private void firstToLast() {
		String last = lst.poll();
		lst.add(last);
	}
}
