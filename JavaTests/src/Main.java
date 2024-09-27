//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int getIntegerH(int h_q_3, int h_r_5) {

        int gussNum = h_q_3 * 3;
        int h_r = gussNum / 5; // output : 4
        int h_q_5 = h_r * 5; //output :20
        int finalGuess = h_q_5 + h_r_5;
        return finalGuess;
    }
    public static void main(String[] args) {

        System.out.println(getIntegerH(-7, -3));  // Output: 45

    }
}