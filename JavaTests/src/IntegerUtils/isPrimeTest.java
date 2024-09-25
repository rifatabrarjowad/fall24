package IntegerUtils;

public class isPrimeTest {
    public static boolean isPrime(int k) {
        if (k < 2) {
            return false;
        }
        int lastNumb = k-1;
        for (int i = 2; i <= lastNumb; i++) {
            if (k % i == 0) {
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        boolean even = isPrime(31849);
        System.out.printf(String.valueOf(even));
    }
}
