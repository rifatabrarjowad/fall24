package IntegerUtils;

public class getIntegerHTest {
    public static int getIntegerH(int h_q_3, int h_r_5) {

        int gussNum = h_q_3 * 3;
        int h_r = gussNum / 5; // output : 4
        int h_q_5 = h_r * 5; //output :20
        int finalGuess = h_q_5 + h_r_5;
        return finalGuess;
    }

    public static void main(String[] args) {
        System.out.println(getIntegerH(15, 0));  // Output: 45
        System.out.println(getIntegerH(0, 0));   // Output: 0
        System.out.println(getIntegerH(3, 4));   // Output: 9

        System.out.println(getIntegerH(7, 3));   // Output: 23
        System.out.println(getIntegerH(-9, -3)); // Output: -23

        // These will throw an error
        System.out.println(getIntegerH(8, 3));   // Error
        System.out.println(getIntegerH(1, 6));   // Error
        System.out.println(getIntegerH(1, -6));  // Error

    }
}
