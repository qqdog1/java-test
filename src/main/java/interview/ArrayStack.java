package interview;

import java.util.Arrays;

public class ArrayStack<T> {
	private T[] array;

	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<>();
		
		stack.push("AAA");
		stack.push("BBB");
		stack.push("CCC");
		
		System.out.println(stack.contains("AAA"));
		System.out.println(stack.contains("AACA"));
		
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
		stack.push("AAA");
		stack.push("BBB");
		stack.push("CCC");
		
		stack.clear();
		
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		array = (T[]) new Object[0];
	}
	
	@SuppressWarnings("unchecked")
	public void push(T t) {
		if(t != null) {
			T[] newArray = (T[]) new Object[array.length + 1];
			for(int i = 0 ; i < array.length; i++) {
				newArray[i] = array[i];
			}
			newArray[array.length] = t;
			array = newArray;
		}
	}
	
	public T pop() {
		T t = null;
		if(array.length > 0) {
			t = array[array.length-1];
			
			array = Arrays.copyOf(array, array.length-1);
		}
		
		return t;
	}
	
	public boolean contains(T t) {
		for(T t1 : array) {
			if(t1.equals(t)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		array = (T[]) new Object[0];
	}
	
	public int size() {
		return array.length;
	}
}
