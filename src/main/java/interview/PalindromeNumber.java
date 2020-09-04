package interview;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindromeNumber(156));
		
		System.out.println(PalindromeNumber.isPalindromeNumber(121));

		System.out.println(PalindromeNumber.isPalindromeNumber(134565431));
		System.out.println(PalindromeNumber.isPalindromeNumber(13455431));
	}

	public PalindromeNumber() {
	}
	
	public static boolean isPalindromeNumber(int i) {
		int reverse = 0;
		int current = i;
		while(current != 0) {
			reverse = (reverse * 10) + (current % 10);
			current = current / 10;
		}
		
		return reverse == i;
	}
}
