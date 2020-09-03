package interview.list;

public class LinkedList<T> {
	private Node<T> head;

	public LinkedList() {
		head = new Node<T>(null);
	}
	
	public void add(T value) {
		Node<T> node = new Node<T>(value);
		
		Node<T> finalNode = head;
		while(finalNode.hasNext()) {
			finalNode = finalNode.next;
		}
		
		finalNode.setNext(node);
	}
	
	public void makeCycled() {
		Node<T> finalNode = head;
		while(finalNode.hasNext()) {
			finalNode = finalNode.next;
		}
		
		finalNode.next = head.next;
	}
	
	public T getMiddleObject() {
		return getMiddleObject(head, head);
	}
	
	public boolean isLinkedListCycled() {
		return isLinkedListCycled(head, head);
	}
	
	private T getMiddleObject(Node<T> fast, Node<T> slow) {
		try {
			fast = fast.next.next;
		} catch (NullPointerException e) {
			return slow.value;
		}
		
		slow = slow.next;
		
		if(fast == null) {
			return slow.value;
		} else {
			return getMiddleObject(fast, slow);
		}
	}
	
	private boolean isLinkedListCycled(Node<T> fast, Node<T> slow) {
		try {
			fast = fast.next.next;
		} catch (NullPointerException e) {
			return false;
		}
		
		slow = slow.next;
		
		if(fast == slow) {
			return true;
		} else {
			return isLinkedListCycled(fast, slow);
		}
	}
	
	private class Node<T> {
		private Node<T> next;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}
		
		public boolean hasNext() {
			return next != null;
		}
		
		public void setNext(Node node) {
			next = node;
		}
	}
}

