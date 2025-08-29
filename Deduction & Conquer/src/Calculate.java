public class Calculate {
	public static void main(String[] args) {
		System.out.println(calculate(2_000_000_007,2));
		System.out.println(calculate(1_000_000_007,3));
	}
	static int calculate(int x, int n){
		int val = 1_000_000_007;
		if (n > (10^9)){
			return 0;
		}

		return (x^n) % val;
	}
}
