package IntegerUtils;

public class getMaximumTest {
    public static int getMaximum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 17, -22, 48, 19};
        System.out.println(getMaximum(array));  // Output: 48
    }
}
