package interview;

public class FibonacciSeries {
	public static void main(String[] args) {
		FibonacciSeries fs = new FibonacciSeries();
		
		System.out.println(fs.getNth(7));
	}

	private FibonacciSeries() {
	}
	
	public int getNth(int n) {
		if(n == 1) return 1;
		if(n < 1) return 0;
		return getNth(n-1) + getNth(n-2);
	}
}
