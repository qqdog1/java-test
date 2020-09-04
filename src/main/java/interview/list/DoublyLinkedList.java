package interview.list;

public class DoublyLinkedList<T> {
	private Node<T> head;

	public DoublyLinkedList() {
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
	
	public void printAll() {
		Node<T> node = head;
		
		while(node.hasNext()) {
			node = node.next;
			
			String lastValue = "";
			String currentValue = node.getValue().toString();
			String nextValue = "";
			
			if(node.last != null) {
				lastValue = String.valueOf(node.last.getValue());
			}
			if(node.next != null) {
				nextValue = String.valueOf(node.next.getValue());
			}
			
			System.out.println(lastValue + " <-- " + currentValue + " --> " + nextValue);
		}
	}
	
	
	
	private class Node<T> {
		private Node<T> last;
		private Node<T> next;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return value;
		}
		
		public boolean hasLast() {
			return last != null;
		}
		
		public boolean hasNext() {
			return next != null;
		}
		
		public void setNext(Node node) {
			next = node;
			node.last = this;
		}
	}
}
