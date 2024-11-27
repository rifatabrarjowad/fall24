package model;

import java.util.Set;

public class RoundTableImpl_Skeleton extends RoundTableAbstract
{
	//DO NOT ADD ANY INSTANCE VARIABLES!
	//NOTE THAT YOU HAVE ACCESS TO THE INSTANCE VARIABLE
	//NAMED peopleAtTable FROM THE SUPERCLASS.
	
	//THIS CONSTRUCTOR IS FINE AS IT IS. DON'T CHANGE IT,
	//BUT MAKE SURE THAT YOU KNOW WHAT IS GOING ON HERE.
	public RoundTableImpl_Skeleton(int initialChairCount)
	{
		super(initialChairCount);
		assert initialChairCount >= 0 : "initialChairCount = " + initialChairCount + " < 0!";
		peopleAtTable = null;
	}

	public Set<String> getSeatedPeople()
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public int getChairCount()
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}
	
	public static final int NOT_FOUND = -1;
	private static int getSmallestIndexOfMatch(String[] stringArray, String target)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public int getChairDistance(String startSeatedPerson, String endSeatedPerson, Side side)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public String getChairContents(String seatedPerson, Side side, int chairDistance)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void addChair()
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void addChair(String seatedPerson, Side side)
	{
		assert getSeatedPeople().contains(seatedPerson) : "person is not at table! seatedPerson = " + seatedPerson;

		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void removeChair()
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	public void removeChair(String seatedPerson, Side side)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void seatPerson(String newPerson)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void seatPerson(String newPerson, String seatedPerson, Side side, int chairDistance)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void removePerson(String seatedPerson)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	@Override
	public void switchSeats(String seatedPerson1, String seatedPerson2)
	{
		throw new RuntimeException("NOT IMPLEMENTED!");
	}
	
	public static void main(String[] args)
	{
		//When a programmer finds themselves making a bunch of named
		//constants like this, they should potentially use an Enumeration instead
		final String ALBERT_EINSTEIN = "Einstein, Albert";
		final String BARACK_OBAMA = "Obama, Barak";
		final String DEAN_KAMEN = "Kaman, Dean";
		final String FRAN_LEBOWITZ = "Lebowitz, Fran";
		final String JANELLE_MONAE = "Monae, Janelle";
		final String JOHNNY_CASH = "Cash, Johnny";
		final String MICHAEL_KORS = "Kors, Michael";
		final String SIMON_COWELL = "Cowell, Simon";
		
		RoundTable roundTable = new RoundTableImpl_Skeleton(1);
		
		roundTable.seatPerson(ALBERT_EINSTEIN);

		roundTable.addChair(ALBERT_EINSTEIN, Side.LEFT);
		roundTable.addChair(ALBERT_EINSTEIN, Side.LEFT);
		
		roundTable.seatPerson(BARACK_OBAMA, ALBERT_EINSTEIN, Side.LEFT, 1);
		
		roundTable.seatPerson(DEAN_KAMEN, ALBERT_EINSTEIN, Side.LEFT, 2);

		roundTable.addChair(DEAN_KAMEN, Side.LEFT);

		roundTable.seatPerson(FRAN_LEBOWITZ, ALBERT_EINSTEIN, Side.LEFT, 3);

		roundTable.addChair(FRAN_LEBOWITZ, Side.LEFT);
		roundTable.seatPerson(JANELLE_MONAE, ALBERT_EINSTEIN, Side.LEFT, 4);
	}
}
