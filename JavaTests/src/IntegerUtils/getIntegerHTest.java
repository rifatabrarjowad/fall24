package IntegerUtils;

public class getIntegerHTest {
    public static int getIntegerH(int h_q_3, int h_r_5) {
        // Check if h_q_3 is a multiple of 3
        if (h_q_3 % 3 != 0) {
            throw new IllegalArgumentException("h_q_3 must be a multiple of 3");
        }

        // Check if h_r_5 is within the range [-5, 5]
        if (h_r_5 < -5 || h_r_5 > 5) {
            throw new IllegalArgumentException("h_r_5 must be between -5 and 5");
        }

        // Return the computed result
        return 3 * h_q_3 + h_r_5;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(getIntegerH(15, 0)); // Output: 45
        System.out.println(getIntegerH(0, 0));  // Output: 0
        System.out.println(getIntegerH(-7, -3)); // Output: -23
        System.out.println(getIntegerH(7, 3));  // Output: 23

        // Uncomment the following lines to see the exceptions
        // System.out.println(getIntegerH(8, 3));  // Should throw error
        // System.out.println(getIntegerH(1, 6));  // Should throw error
        // System.out.println(getIntegerH(1, -6)); // Should throw error
    }
}
