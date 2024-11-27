package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class RoundTableAbstract implements RoundTable
{
	protected String[] peopleAtTable;
	
	protected static boolean VERBOSE = true;
	
	protected RoundTableAbstract(int initialChairCount)
	{
		peopleAtTable = new String[initialChairCount];
	}

	private static int[] getIndicesForTableTemplate(int chairCount)
	{
		assert chairCount <= 12 : "Table template cannot admit a chairCount greater than 12! chairCount = " + chairCount;
		
		int[] indices = new int[chairCount];
		switch(chairCount)
		{
			case 1:
				indices[0] = 0;
				break;
			case 2:
				indices[0] = 0;
				indices[1] = 6;
				break;
			case 3:
				indices[0] = 0;
				indices[1] = 4;
				indices[2] = 8;
				break;
			case 4:
				indices[0] = 0;
				indices[1] = 3;
				indices[2] = 6;
				indices[3] = 9;
				break;
			case 5:
				indices[0] = 0;
				indices[1] = 2;
				indices[2] = 5;
				indices[3] = 7;
				indices[4] = 10;
				break;
			case 6:
				indices[0] = 0;
				indices[1] = 2;
				indices[2] = 4;
				indices[3] = 6;
				indices[4] = 8;
				indices[5] = 10;
				break;
			case 7:
				indices[0] = 0;
				indices[1] = 2;
				indices[2] = 4;
				indices[3] = 6;
				indices[4] = 8;
				indices[5] = 10;
				indices[6] = 11;
				break;
			case 8:
				indices[0] = 0;
				indices[1] = 1;
				indices[2] = 4;
				indices[3] = 5;
				indices[4] = 6;
				indices[5] = 8;
				indices[6] = 9;
				indices[7] = 10;
				break;
			case 9:
				indices[0] = 0;
				indices[1] = 1;
				indices[2] = 2;
				indices[3] = 4;
				indices[4] = 5;
				indices[5] = 6;
				indices[6] = 8;
				indices[7] = 9;
				indices[8] = 10;
				break;
			case 10:
				indices[0] = 0;
				indices[1] = 1;
				indices[2] = 2;
				indices[3] = 3;
				indices[4] = 4;
				indices[5] = 6;
				indices[6] = 7;
				indices[7] = 8;
				indices[8] = 9;
				indices[9] = 10;
				break;
			case 11:
				indices[0] = 0;
				indices[1] = 1;
				indices[2] = 2;
				indices[3] = 3;
				indices[4] = 4;
				indices[5] = 5;
				indices[6] = 7;
				indices[7] = 8;
				indices[8] = 9;
				indices[9] = 10;
				indices[10] = 11;
				break;
			case 12:
				indices[0] = 0;
				indices[1] = 1;
				indices[2] = 2;
				indices[3] = 3;
				indices[4] = 4;
				indices[5] = 5;
				indices[6] = 6;
				indices[7] = 7;
				indices[8] = 8;
				indices[9] = 9;
				indices[10] = 10;
				indices[11] = 11;
				break;
		}
		return indices;
	}
	
	private static char[] positions = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '%'};
	
	protected static String getInitials(String name)
	{
		assert RoundTable.isName(name) : "Name = " + name + " is not a name!";
		
		final String DELIMITER = ", ";	
		
		String lastName = name.substring(0, name.indexOf(DELIMITER));
		String firstName = name.substring(name.indexOf(DELIMITER) + DELIMITER.length());
		
		String initials = "" + firstName.charAt(0) + lastName.charAt(0);
		assert initials.length() == 2 : "initials.length() = " + initials.length() + " <> 2!";
		return initials;
	}
	
	private static String getTableTemplate()
	{
		return
				"       %  0      " + "\n" +
				"    &        1   " + "\n" + 
				"   9          2  " + "\n" + 
				"   8          3  " + "\n" +
				"    7        4   " + "\n" +
				"       6  5      " + "\n";
	}
	
	private String toStringNoOneSeatedMaxCapacity12()
	{
		assert getSeatedPeople().size() == 0 : "Someone is seated at the table! getSeatedPeople() = " + getSeatedPeople();
		assert getChairCount() <= 12 : "There are more than 12 chairs at the table!";
		
		final char SPACE = ' ';
		final char CHAIR = '*';
	
		String tableFace = getTableTemplate();
	
		final int CHAIR_COUNT = getChairCount();

		int[] indices = getIndicesForTableTemplate(CHAIR_COUNT);

		int j = 0;
		char positionChar_j = positions[j];
		for(int i = 0; i < indices.length; i++)
		{
			int index_i = indices[i];
			while(j < index_i)
			{
				tableFace.replace(positionChar_j, SPACE);
				j++;
				if(j < positions.length) positionChar_j = positions[j];
			}
			assert j == index_i : "j = " + j + " <> " + index_i + " = index_i!";
			tableFace = tableFace.replace(positionChar_j, CHAIR);
			j++;
			if(j < positions.length) positionChar_j = positions[j];
		}
		while(j < positions.length)
		{
			tableFace = tableFace.replace(positionChar_j, SPACE);
			j++;
			if(j < positions.length) positionChar_j = positions[j];
		}

		return tableFace;
	}
	
	private static int getSmallestIndexOfMinimumInitials(List<String> nameList)
	{
		assert nameList != null : "stringList is null!";
		assert !nameList.contains(null) : "stringList contains null! : stringList = " + nameList;
		assert nameList.size() > 0 : "stringList.size() = " + nameList.size() + " = 0!";
		
		int indexOfMinimum = nameList.size() - 1;
		
		String minimum = getInitials(nameList.get(indexOfMinimum));
		for(int i = nameList.size() - 2; i >= 0; i--)
		{
			String initials_i = getInitials(nameList.get(i));
			if(initials_i.compareTo(minimum) < 0)
			{
				indexOfMinimum = i;
			}
		}
		
		return indexOfMinimum;
	}
	
	private String toStringSomeoneSeatedMaxCapacity12()
	{
		assert getSeatedPeople().size() > 0 : "No one is seated at the table! getSeatedPeople().size() = 0!";
		assert getChairCount() <= 12 : "There are more than 12 chairs at the table!";
		
		final char SPACE = ' ';
		final char CHAIR = '*';
		final String EMPTY = null;
	
		String tableFace = getTableTemplate();
	
		final int CHAIR_COUNT = getChairCount();

		int[] indices = getIndicesForTableTemplate(CHAIR_COUNT);
		
		Set<String> seatedPeople = getSeatedPeople();
		List<String> seatedPeopleList = new ArrayList<String>(seatedPeople);
		
		int smallestIndexOfLowestInitials = getSmallestIndexOfMinimumInitials(seatedPeopleList);
		
		String distinguishedPerson = seatedPeopleList.get(smallestIndexOfLowestInitials);

		int j = 0;
		char positionChar_j = positions[j];
		for(int i = 0; i < indices.length; i++)
		{
			int index_i = indices[i];
			while(j < index_i)
			{
				tableFace = tableFace.replace(positionChar_j, SPACE);
				j++;
				if(j < positions.length) positionChar_j = positions[j];
			}
			assert j == index_i : "j = " + j + " <> " + index_i + " = index_i!";
			String chairContents_i = getChairContents(distinguishedPerson, Side.LEFT, i);
			
			if(chairContents_i != EMPTY)
			{
				String personAtDistanceIFromDistinguished = chairContents_i;
				String personInitials = getInitials(personAtDistanceIFromDistinguished);
				tableFace = tableFace.replace("" + positionChar_j + ' ', personInitials);
			}
			else
			{
				tableFace = tableFace.replace(positionChar_j, CHAIR);
			}
			j++;
			if(j < positions.length) positionChar_j = positions[j];
		}
		while(j < positions.length)
		{
			tableFace = tableFace.replace(positionChar_j, SPACE);
			j++;
			if(j < positions.length) positionChar_j = positions[j];
		}

		return tableFace;
	}
	
	private String toStringLinear()
	{
		final String PREFIX = "LEFT <--";
		final String SUFFIX = "--> RIGHT";
		final char CHAIR = '*';
		final String EMPTY = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(PREFIX);
		
		final int CHAIR_COUNT = getChairCount();
		Set<String> seatedPeople = getSeatedPeople();
		boolean isSomeoneSeated = seatedPeople.size() > 0;
		if(isSomeoneSeated)
		{
			String distinguishedPerson = seatedPeople.iterator().next();
			
			for(int i = 0; i < CHAIR_COUNT; i++)
			{
				String chairContents_i = getChairContents(distinguishedPerson, Side.RIGHT, i);
				if(chairContents_i == EMPTY)
				{
					sb.append(" " + CHAIR + " ");
				}
				else
				{
					String person = chairContents_i;
					String initials = getInitials(person);
					sb.append(" " + initials + " ");
				}
			}
		}
		else
		{
			for(int i = 0; i < CHAIR_COUNT; i++)
			{
				sb.append(" " + CHAIR + " ");
			}
		}

		sb.append(SUFFIX);
		sb.append("\n");
		sb.append("Chair count = " + CHAIR_COUNT);
		
		return sb.toString();
	}
	
	public String toString()
	{
		boolean isSomeoneSeated = (getSeatedPeople().size() > 0);
		
		final int CHAIR_COUNT = getChairCount();
		String t;
		if(CHAIR_COUNT <= 12)
		{
			t = (isSomeoneSeated ? toStringSomeoneSeatedMaxCapacity12() : toStringNoOneSeatedMaxCapacity12());
		}
		else
		{
			t = toStringLinear();
		}
		
		return t;
	}
}
