package dominoes;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
public class DominoTest {
    public static void main(String[] args) {
//        test 1
//        Domino domino1 = new DominoHighLowImpl_Jowad(3, 3);
//        System.out.println("[3:3] => High: " + domino1.getHighPipCount() + ", Low: " + domino1.getLowPipCount());
//        Test 2
//        Domino domino2 = new DominoHighLowImpl_Jowad("6:4");
//        System.out.println("domino2: " + domino2.getHighPipCount() + domino2.getLowPipCount());
//        Test 3
//        int[] sumDifference = {7,3};
//        Domino domino3 = new DominoHighLowImpl_Jowad(sumDifference);
//        System.out.println(domino3.getHighPipCount() +" "+ domino3.getLowPipCount());
//
//        Test 4
//        Set<Integer> highLowSet1 = new HashSet<>();
//        highLowSet1.add(6);
//
//        highLowSet1.add(4);
//
//        Domino domino1 = new DominoHighLowImpl_Jowad(highLowSet1);
//        System.out.println(domino1.getHighPipCount()+" " + domino1.getLowPipCount());


//        Test 5
//        int input = 43;
//        DominoLowDifferenceStringImpl_Kart domino = new DominoLowDifferenceStringImpl_Kart(input);
//
//        // Validate the results
//        if (domino.getHighPipCount() == 2 && domino.getLowPipCount() == 1) {
//            System.out.println("Test passed!");
//        } else {
//            System.out.println("Test failed!");
//            System.out.println("Expected highPipCount: 2, lowPipCount: 1");
//            System.out.println("Actual highPipCount: " + domino.getHighPipCount() +
//                    ", lowPipCount: " + domino.getLowPipCount());
//        }

//        Test 6:


        List<Integer> validInput = new ArrayList<>();
        validInput.add(4); // highPipCount
        validInput.add(4); // highSum value

        Domino domino7 = new DominoLowDifferenceStringImpl_Kart(validInput);
        System.out.println(domino7.getHighPipCount() + " " + domino7.getLowPipCount() );
            // Validate the results

//        Domino domino2 = new DominoHighLowSetImpl_Kart("8,2");
//        System.out.println("[8,2] => High: " + domino2.getHighPipCount() + ", Low: " + domino2.getLowPipCount());
//
//        Domino domino3 = new DominoLowDifferenceStringImpl_Kart(42); // 5 * 8 + 2 = 42
//        System.out.println("[42] => High: " + domino3.getHighPipCount() + ", Low: " + domino3.getLowPipCount());
    }
}
