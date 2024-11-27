package model;

import java.util.Set;

public interface RoundTable
{
	//part of pre: true
	//NOTE: The conceptual dissonance here should be
	//taken as a design cue to use a Person class instead.
	//However, leave as-is for this assignment. That is,
	//do not add Person to the interface or otherwise
	//change the interface in any way.
	public static boolean isName(String personName)
	{
		boolean isNameNull = (personName == null);
		
		boolean foundDisqualification = isNameNull;
		
		if(!foundDisqualification)
		{
			final String DELIMITER = ", ";			
			boolean nameContainsDelimiter = (personName.indexOf(DELIMITER) != -1);
			boolean nameContainsSingleDelimiter = (personName.indexOf(DELIMITER) == personName.lastIndexOf(DELIMITER));
			
			foundDisqualification = (!nameContainsDelimiter || !nameContainsSingleDelimiter);
			
			if(!foundDisqualification)
			{
				String lastNameCandidate = personName.substring(0, personName.indexOf(DELIMITER));
				String firstNameCandidate = personName.substring(personName.indexOf(DELIMITER) + DELIMITER.length());
			
				boolean isLastNameCandidateEmpty = (lastNameCandidate.length() == 0);
				boolean isFirstNameCandidateEmpty = (firstNameCandidate.length() == 0);
				
				foundDisqualification = (isLastNameCandidateEmpty || isFirstNameCandidateEmpty);
				
				int i = 0;
				while(!foundDisqualification && i < lastNameCandidate.length())
				{
					foundDisqualification = !Character.isLetter(lastNameCandidate.charAt(i));
					if(!foundDisqualification) i++;
				}
					
				i = 0;
				while(!foundDisqualification && i < firstNameCandidate.length())
				{
					foundDisqualification = !Character.isLetter(firstNameCandidate.charAt(i));
					if(!foundDisqualification) i++;
				}
			}
		}
		
		boolean isName = (!foundDisqualification);
		return isName;
	}
	
	//part of post: rv != null
	//part of post: !rv.contains(null)
	public Set<String> getSeatedPeople();
	
	//part of pre: true
	//part of post: rv >= 0
	public int getChairCount();
	
	//part of pre: getSeatedPeople().contains(startSeatedPerson)
	//part of pre: getSeatedPeople().contains(endSeatedPerson)
	//part of post: startSeatedPerson.equals(endSeatedPerson) ==> rv == 0
	//part of post: !startSeatedPerson.equals(endSeatedPerson) ==> 0 < rv < chairCount()
	public int getChairDistance(String startSeatedPerson, String endSeatedPerson, Side side);
	
	public static final String EMPTY = null;
	
	//part of pre: 0 <= distance < chairCount()
	//part of pre: getSeatedPeople().contains(seatedPerson)
	//part of post: rv == EMPTY <==> the indicated chair is empty
	public String getChairContents(String seatedPerson, Side side, int distance);
	
	//part of pre: getSeatedPeople().size() == 0
	public void addChair();
	
	//part of pre: getSeatedPeople().contains(seatedPerson)
	public void addChair(String seatedPerson, Side side);
	
	//part of pre: chairCount_pre == getChairCount() > 0
	//part of pre: getSeatedPeople().size() == 0
	//part of post: (chairCount_pre - 1) == getChairCount() >= 0
	public void removeChair();

	//part of pre: getSeatedPeople().contains(seatedPerson)
	//part of pre: getChairContents(seatedPerson, side, 1) == EMPTY
	public void removeChair(String seatedPerson, Side side);
	
	//part of pre: isName(newPerson)
	//part of pre: getSeatedPeople().size() == 0
	//part of pre: getChairCount() > 0
	public void seatPerson(String newPerson);
	
	//part of pre: isName(newPerson)
	//part of pre: !getPeopleSeated().contains(newPerson)
	//part of pre: getPeopleSeated().contains(seatedPerson)
	//part of pre: 0 < chairDistance < getChairCount()
	//part of pre: getChairContents(seatedPerson, side, chairDistance) == EMPTY
	public void seatPerson(String newPerson, String seatedPerson, Side side, int chairDistance);

	//part of pre: getPeopleSeated().contains(seatedPerson)
	//part of pre: chairCount_pre == getChairCount()
	//part of post: (chairCount_pre - 1) == getChairCount()
	public void removePerson(String seatedPerson);
	
	//part of pre: getPeopleSeated().contains(seatedPerson1)
	//part of pre: getPeopleSeated().contains(seatedPerson2)
	//part of pre: seatedPerson1_pre == seatedPerson1 && seatedPerson1_pre == seatedPerson2
	//part of post: 0 <= distance < chairCount() ==> getPersonAt(seatedPerson1_pre, side, distance).equals(getPersonAt(seatedPerson2, side, distance))
	//part of post: 0 <= distance < chairCount() ==> getPersonAt(seatedPerson2_pre, side, distance).equals(getPersonAt(seatedPerson1, side, distance))
	public void switchSeats(String seatedPerson1, String seatedPerson2);
}
