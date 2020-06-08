package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsTest {
	public static void main(String[] s) {
		new ListsTest();
	}
	
	private ListsTest() {
		testArrayList();
		
		testLinkedList();
	}
	
	private void testArrayList() {
		ArrayList<String> lst = new ArrayList<>();
		addData(lst);
		print(lst);
		
		lst.add(1, "Q");
		print(lst);
	}
	
	private void testLinkedList() {
		LinkedList<String> lst = new LinkedList<>();
		addData(lst);
		print(lst);
		
		lst.add(1, "Q");
		print(lst);
	}
	
	private void addData(List<String> lst) {
		lst.add("a");
		lst.add("b");
		lst.add("c");
	}
	
	private void print(List<String> lst) {
		for(String s : lst) {
			System.out.print(s);
		}
		System.out.println("");
	}
}
