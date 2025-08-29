public class CalculateSqRoot {
	public static void main(String[] args) {
		System.out.printf("Square root of %d ≈ %.6f%n", 25, calculateSq(25));
	}
	static double calculateSq(int val) {
		double precision = 0.000001;

		double low = 0, high = val, mid = 0;

		while ((high - low) > precision){
			mid =(high + low) /2;
			if (mid * mid > val){
				high = mid;
			}
			else {
				low = mid;
			}
		}
		return (low + high) / 2;
	}


}
