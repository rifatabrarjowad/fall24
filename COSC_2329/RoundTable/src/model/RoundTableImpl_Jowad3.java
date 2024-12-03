package model;

import java.util.HashSet;
import java.util.Set;

public class RoundTableImpl_Jowad3 extends RoundTableAbstract {
    private final Set<String> seatedPeople;

    public RoundTableImpl_Jowad3(int initialChairCount) {
        super(initialChairCount);
        seatedPeople = new HashSet<>();
    }

    @Override
    public void addChair() {
        if (getSeatedPeople().isEmpty()) {
            String[] newPeopleAtTable = new String[peopleAtTable.length + 1];
            System.arraycopy(peopleAtTable, 0, newPeopleAtTable, 0, peopleAtTable.length);
            peopleAtTable = newPeopleAtTable;
        } else {
            throw new IllegalStateException("Cannot add chairs while people are seated.");
        }
    }

    @Override
    public int getChairCount() {
        return peopleAtTable.length;
    }

    @Override
    public void seatPerson(String newPerson) {
        if (!isName(newPerson)) {
            throw new IllegalArgumentException("Invalid person name.");
        }
        if (!seatedPeople.isEmpty()) {
            throw new IllegalStateException("Table is already occupied.");
        }
        if (getChairCount() == 0) {
            throw new IllegalStateException("No chairs available.");
        }
        peopleAtTable[0] = newPerson;
        seatedPeople.add(newPerson);
    }

    @Override
    public Set<String> getSeatedPeople() {
        return new HashSet<>(seatedPeople);
    }
}
