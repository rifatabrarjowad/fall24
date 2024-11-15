package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class ChangeMakerImpl_jowad implements ChangeMaker {

    private final List<Integer> denominations;

 
    public ChangeMakerImpl_jowad(Set<Integer> denominations) {
        if (denominations == null || denominations.isEmpty() || denominations.contains(0)) {
            throw new IllegalArgumentException("Denominations must be non-empty and contain only positive integers.");
        }
        this.denominations = new ArrayList<>(denominations);
        Collections.sort(this.denominations, Collections.reverseOrder());
    }

    @Override
    public List<Integer> getDenominations() {
        return new ArrayList<>(denominations);
    }

    @Override
    public boolean canMakeExactChange(int valueInCents) {
        if (valueInCents < 0) {
            return false;
        }
        for (int denomination : denominations) {
            valueInCents %= denomination;
        }
        return valueInCents == 0;
    }

    @Override
    public List<Integer> getExactChange(int valueInCents) {
        if (!canMakeExactChange(valueInCents)) {
            throw new IllegalArgumentException("Cannot make exact change for the given value.");
        }

        List<Integer> change = new ArrayList<>(Collections.nCopies(denominations.size(), 0));
        for (int i = 0; i < denominations.size(); i++) {
            int denomination = denominations.get(i);
            change.set(i, valueInCents / denomination);
            valueInCents %= denomination;
        }
        return change;
    }

    @Override
    public int calculateValueOfChangeList(List<Integer> changeList) {
        if (changeList == null || changeList.size() != denominations.size()) {
            throw new IllegalArgumentException("Change list must match the size of denominations.");
        }

        int totalValue = 0;
        for (int i = 0; i < changeList.size(); i++) {
            totalValue += changeList.get(i) * denominations.get(i);
        }
        return totalValue;
    }
}
