package change;

import java.util.List;

/**
 * Interface for ChangeMaker.
 * Provides methods to determine if exact change can be made,
 * get the exact change, and calculate the value of a pile of change.
 */
public interface ChangeMaker {

   
    List<Integer> getDenominations();

    boolean canMakeExactChange(int valueInCents);

    List<Integer> getExactChange(int valueInCents);

  
    int calculateValueOfChangeList(List<Integer> changeList);
}
