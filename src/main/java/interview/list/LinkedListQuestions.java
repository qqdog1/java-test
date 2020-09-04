package interview.list;

// https://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html
// Question 1: How to find middle element of linked list in one pass?
// Question 2: How to find if a linked list has a loop?
public class LinkedListQuestions {
	
	private LinkedList<String> lst = new LinkedList<>();
	private DoublyLinkedList<String> doublyLst = new DoublyLinkedList<>();
	
	private LinkedListQuestions() {
		initList();
		
		getMiddleObject();
		
		isLinkedListCycled();
		
		lst.makeCycled();
		
		isLinkedListCycled();
		
		doublyLst.printAll();
	}
	
	private void getMiddleObject() {
		System.out.println(lst.getMiddleObject());
	}
	
	private void isLinkedListCycled() {
		System.out.println(lst.isLinkedListCycled());
	}
	
	private void initList() {
		lst.add("a");
		lst.add("b");
		lst.add("c");
		lst.add("d");
		lst.add("e");
		lst.add("f");
		
		doublyLst.add("a");
		doublyLst.add("b");
		doublyLst.add("c");
		doublyLst.add("d");
		doublyLst.add("e");
	}
	
	public static void main(String[] s) {
		new LinkedListQuestions();
	}
}
