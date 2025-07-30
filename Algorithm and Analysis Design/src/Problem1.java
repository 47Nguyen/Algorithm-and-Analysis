public class Problem1 {
    public static void main(String[] args) {
        int c = 1000; // We choose a large enough c so that the inequality holds
        int n0 = 1;

        System.out.printf("Testing if T(N) = 999N - sqrt(N) is O(N^2) using c = %d and n0 = %d%n", c, n0);
        boolean valid = true;

        for (int n = n0; n <= 1000; n++) {
            double tOfN = 999 * n - Math.sqrt(n);
            double bound = c * Math.pow(n, 2);

            if (tOfN > bound) {
                valid = false;
                System.out.printf("Failed at N = %d: T(N) = %.2f > c*N^2 = %.2f%n", n, tOfN, bound);
                break;
            }
        }

        if (valid) {
            System.out.println("Success: T(N) = 999N - sqrt(N) is O(N^2)");
        } else {
            System.out.println("Failed to prove T(N) = O(N^2) with the given c and n0");
        }
    }
}
/**
 * When the question say Prove that T(N) = O(N^2)
 * It means is that we are trying to prove T(N) is less than or equal to O(N^2)
 */