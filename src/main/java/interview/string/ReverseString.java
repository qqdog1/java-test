package interview.string;

public class ReverseString {
	// https://javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html
	// Question 6: How to reverse String in Java?
	public static void main(String[] args) {
		new ReverseString();
	}
	
	private ReverseString() {
		String s = "aabbcc ppOOqq";
		
		System.out.println(reverse(s));
	}
	
	private String reverse(String s) {
		if(s.length() == 1) {
			return s;
		}
		return reverse(s.substring(1)) + s.charAt(0);
	}
}
