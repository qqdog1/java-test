package interview.sort;

public class BubbleSort {

	// https://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html
	// Question 7: Write a Java program to sort an array using the Bubble Sort algorithm?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {54, 32, 11};
		
		array = new BubbleSort().sort(array);
		
		for(int i : array) {
			System.out.println(i);
		}
	}
	
	public BubbleSort() {
	}

	public int[] sort(int[] array) {
		for(int times = 0 ; times < array.length ; times++) {
			boolean isClean = true;
			for(int index = 0 ; index < array.length - 1 ; index++) {
				if(array[index] < array[index+1]) {
					int temp = array[index];
					array[index] = array[index+1];
					array[index+1] = temp;
					isClean = false;
				}
			}
			if(isClean) break;
		}
		return array;
	}
}
