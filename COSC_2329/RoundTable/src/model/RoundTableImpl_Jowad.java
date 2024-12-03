package model;

import java.util.HashSet;
import java.util.Set;

public class RoundTableImpl_Jowad extends RoundTableAbstract {
	public RoundTableImpl_Jowad(int initialChairCount) {
		super(initialChairCount);
		assert initialChairCount >= 0 : "initialChairCount = " + initialChairCount + " < 0!";
		peopleAtTable = new String[initialChairCount];
	}

	@Override
	public Set<String> getSeatedPeople() {
		Set<String> seatedPeople = new HashSet<>();
		if (peopleAtTable != null) {
			for (String person : peopleAtTable) {
				if (person != null) {
					seatedPeople.add(person);
				}
			}
		}
		return seatedPeople;
	}

	@Override
	public int getChairCount() {
		return peopleAtTable == null ? 0 : peopleAtTable.length;
	}

	public static final int NOT_FOUND = -1;

	private static int getSmallestIndexOfMatch(String[] stringArray, String target) {
		if (stringArray == null || target == null) return NOT_FOUND;
		for (int i = 0; i < stringArray.length; i++) {
			if (target.equals(stringArray[i])) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	@Override
	public void addChair() {
		int currentChairCount = getChairCount();
		String[] newPeopleAtTable = new String[currentChairCount + 1];
		if (peopleAtTable != null) {
			System.arraycopy(peopleAtTable, 0, newPeopleAtTable, 0, currentChairCount);
		}
		peopleAtTable = newPeopleAtTable;
	}

	@Override
	public void removeChair() {
		int currentChairCount = getChairCount();
		assert currentChairCount > 0 : "No chairs to remove!";
		assert getSeatedPeople().size() < currentChairCount : "Cannot remove a chair when someone is seated!";

		String[] newPeopleAtTable = new String[currentChairCount - 1];
		System.arraycopy(peopleAtTable, 0, newPeopleAtTable, 0, currentChairCount - 1);
		peopleAtTable = newPeopleAtTable;
	}

	@Override
	public int getChairDistance(String startSeatedPerson, String endSeatedPerson, Side side) {
		// Placeholder implementation for now
		return 0; // Example default value; replace with actual logic later
	}

	@Override
	public String getChairContents(String seatedPerson, Side side, int chairDistance) {
		// Placeholder implementation for now
		return null; // Example default value; replace with actual logic later
	}

	@Override
	public void addChair(String seatedPerson, Side side) {
		// Placeholder implementation for now
	}

	@Override
	public void removeChair(String seatedPerson, Side side) {
		// Placeholder implementation for now
	}

	@Override
	public void seatPerson(String newPerson) {
		// Placeholder implementation for now
	}

	@Override
	public void seatPerson(String newPerson, String seatedPerson, Side side, int chairDistance) {
		// Placeholder implementation for now
	}

	@Override
	public void removePerson(String seatedPerson) {
		// Placeholder implementation for now
	}

	@Override
	public void switchSeats(String seatedPerson1, String seatedPerson2) {
		// Placeholder implementation for now
	}
}
