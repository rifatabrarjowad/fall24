package IntegerUtils;

public class getGreatestConstrainedMultipleTest {
    public static int getGreatestConstrainedMultiple(int k, int maximum) {
        return (maximum / k) * k;
    }
    public static void main(String[] args) {
        System.out.print(getGreatestConstrainedMultiple(5, -13));
    }
}
