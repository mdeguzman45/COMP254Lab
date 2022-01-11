

public class ProductAlgorithmCheck {
	// for this exercise we are only expected positive integer values
	public static int computeProductByAddSubtract(int m, int n) {
		// if input is 0 return 0;
		if (m == 0 || n == 0) {
			return 0;
		}
		
		// if input n is 1 return m
		if (n == 1) {
			return m;
		}
		
		// if input m is 1 return n
		if (m == 1) {
			return n;
		}
		
		// recursive call; lets use n as the counter
		return m + computeProductByAddSubtract(m, n -1);
	}
	
	public static void main(String[] args) {
		// test the algorithm
		System.out.println("product of 4 and 5 using computeProductByAddSubtract: " + computeProductByAddSubtract(4, 5));
		System.out.println("product of 20 and 30 using computeProductByAddSubtract: " + computeProductByAddSubtract(20, 30));
		System.out.println("product of 0 and 5 using computeProductByAddSubtract: " + computeProductByAddSubtract(0, 5));
		System.out.println("product of 1500 and 1 using computeProductByAddSubtract: " + computeProductByAddSubtract(1500, 1));
		System.out.println("product of 25655 and 157 using computeProductByAddSubtract: " + computeProductByAddSubtract(25655, 157));
	}
}
