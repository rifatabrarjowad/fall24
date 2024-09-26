package IntegerUtils;

public class sumthingTest {
    public static int sumthing(long k) {
        if (k < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }

        // Digital root calculation:
        int sum = (int) k;

        while (sum >= 10) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10;  // Add the last digit to the temp sum
                sum /= 10;            // Remove the last digit
            }
            sum = tempSum;            // Update sum with tempSum
        }

        return sum;
    }
    public static void main(String[] args) {
        int even = sumthing(841);
        System.out.printf(String.valueOf(even));
    }
}
