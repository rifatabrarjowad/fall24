package utils;

import java.util.HashSet;
import java.util.Set;

public interface IntegerUtils_jowad {

    /**
     * Checks if a number is even.
     * Examples:
     * - Straightforward: isEven(4) -> true
     * - Extreme: isEven(0) -> true
     * - Bizarre/Exotic: isEven(-2) -> true
     */
    public static boolean isEven(int k) {
        return k % 2 == 0;
    }

    /**
     * Checks if a number is odd.
     * Examples:
     * - Straightforward: isOdd(3) -> true
     * - Extreme: isOdd(0) -> false
     * - Bizarre/Exotic: isOdd(-3) -> true
     */
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    /**
     * Checks if a number is prime.
     * Examples:
     * - Straightforward: isPrime(7) -> true
     * - Extreme: isPrime(1) -> false
     * - Bizarre/Exotic: isPrime(-11) -> false
     */
    public static boolean isPrime(int k) {
        if (k < 2) {
            return false;
        }
        int lastNumb = k - 1;
        for (int i = 2; i <= lastNumb; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the greatest common factor (GCF) of two numbers.
     * Examples:
     * - Straightforward: greatestCommonFactor(8, 12) -> 4
     * - Extreme: greatestCommonFactor(17, 31) -> 1
     * - Bizarre/Exotic: greatestCommonFactor(0, 5) -> 5
     */
    public static int greatestCommonFactor(int m, int n) {
        while (n != 0 && n != 1) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }

    /**
     * Finds the greatest multiple of k that is less than or equal to the given maximum.
     * Examples:
     * - Straightforward: getGreatestConstrainedMultiple(3, 10) -> 9
     * - Extreme: getGreatestConstrainedMultiple(10, 100) -> 100
     * - Bizarre/Exotic: getGreatestConstrainedMultiple(5, 4) -> 0
     */
    public static int getGreatestConstrainedMultiple(int k, int maximum) {
        return (maximum / k) * k;
    }

    /**
     * A customized method for computing a value based on two integers.
     * Examples:
     * - Straightforward: getIntegerH(5, 3) -> 23
     * - Extreme: getIntegerH(0, 1) -> 1
     * - Bizarre/Exotic: getIntegerH(-2, -1) -> -11
     */
    public static int getIntegerH(int h_q_3, int h_r_5) {
        int gussNum = h_q_3 * 3;
        int h_r = gussNum / 5; // output: 4
        int h_q_5 = h_r * 5; // output: 20
        int finalGuess = h_q_5 + h_r_5;
        return finalGuess;
    }

    /**
     * Returns the maximum number from a set of integers.
     * Examples:
     * - Straightforward: getMaximum(Set.of(1, 2, 3)) -> 3
     * - Extreme: getMaximum(Set.of(-1000, -500, 0)) -> 0
     * - Bizarre/Exotic: getMaximum(Set.of(9999)) -> 9999
     */
    public static int getMaximum(Set<Integer> integerSet) {
        if (integerSet == null || integerSet.isEmpty()) {
            throw new IllegalArgumentException("Set must not be null or empty");
        }

        int max = Integer.MIN_VALUE;
        for (int num : integerSet) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Returns the minimum number from an array of integers.
     * Examples:
     * - Straightforward: getMinimum(new int[]{1, 2, 3}) -> 1
     * - Extreme: getMinimum(new int[]{1000, 100, 10}) -> 10
     * - Bizarre/Exotic: getMinimum(new int[]{0}) -> 0
     */
    public static int getMinimum(int[] intArray) {
        if (intArray == null || intArray.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = intArray[0];
        for (int num : intArray) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Checks if the array is sorted in non-decreasing order.
     * Examples:
     * - Straightforward: isSorted(new int[]{1, 2, 3}) -> true
     * - Extreme: isSorted(new int[]{3, 2, 1}) -> false
     * - Bizarre/Exotic: isSorted(new int[]{1, 1, 1, 1}) -> true
     */
    public static boolean isSorted(int[] intArray) {
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < intArray[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the index of the first occurrence of the target value in the array.
     * Examples:
     * - Straightforward: getSmallestIndexOfMatch(new int[]{1, 2, 3}, 2) -> 1
     * - Extreme: getSmallestIndexOfMatch(new int[]{10, 20, 30}, 5) -> -1
     * - Bizarre/Exotic: getSmallestIndexOfMatch(new int[]{7, 7, 7}, 7) -> 0
     */
    public static int getSmallestIndexOfMatch(int[] intArray, int target) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds common decimal digits between two integers.
     * Examples:
     * - Straightforward: getCommonDecimalDigits(123, 321) -> [1, 2, 3]
     * - Extreme: getCommonDecimalDigits(1000, 9999) -> []
     * - Bizarre/Exotic: getCommonDecimalDigits(987654321, 123456789) -> [1, 2, 3, 4, 5, 6, 7, 8, 9]
     */
    public static Set<Integer> getCommonDecimalDigits(int a, int b) {
        Set<Integer> digitsA = new HashSet<>();
        Set<Integer> digitsB = new HashSet<>();

        while (a > 0) {
            digitsA.add(a % 10);
            a /= 10;
        }

        while (b > 0) {
            digitsB.add(b % 10);
            b /= 10;
        }

        digitsA.retainAll(digitsB);
        return digitsA;
    }

    /**
     * Reverses the digits of a number.
     * Examples:
     * - Straightforward: reverse(123) -> 321
     * - Extreme: reverse(1000) -> 1
     * - Bizarre/Exotic: reverse(-456) -> -654
     */
    public static int reverse(int k) {
        int reversed = 0;
        while (k != 0) {
            reversed = reversed * 10 + k % 10;
            k /= 10;
        }
        return reversed;
    }

    /**
     * Reduces a number by summing its digits repeatedly until the result is a single digit.
     * Examples:
     * - Straightforward: sumthing(987) -> 6
     * - Extreme: sumthing(1000000000) -> 1
     * - Bizarre/Exotic: sumthing(999999999) -> 9
     */
    public static int sumthing(long k) {
        if (k < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        int sum = (int) k;

        while (sum >= 10) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10;
                sum /= 10;
            }
            sum = tempSum;
        }

        return sum;
    }
}
