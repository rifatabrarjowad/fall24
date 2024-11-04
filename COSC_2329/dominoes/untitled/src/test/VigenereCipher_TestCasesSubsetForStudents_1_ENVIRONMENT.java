package test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.Test;

import encryption.VigenereCipher_Jowad;

public class VigenereCipher_TestCasesSubsetForStudents_1_ENVIRONMENT
{
	//STUDENT: YOU *MUST* CHANGE THE VALUE OF LAST_NAME
	public static final String LAST_NAME = "Skeleton";
	private static final String CLASS_NAME = "VigenereCipher";
	private static final int REQUIRED_JAVA_VERSION = 9;	//Need Class.getPackageName() below
	
	private static final String PACKAGE_NAME = "encryption";
	protected static final String SKELETON = "Skeleton";
	protected static final String SEPARATOR = "_";

	protected static String TEST_GOAL_MESSAGE;
	public final static String SUBGOAL = "Subgoal";
	
	@Points(value=5)
	@Test
	public void correctClassNamePrefix()
	{
		TEST_GOAL_MESSAGE = "Check whether class name has the correct prefix";
		String expectedPrefix = CLASS_NAME + SEPARATOR;
		String actualClassName = getClassNameWithoutPackage(VigenereCipher_Jowad.class);
		String failureMessage = "expectedPrefix = \"" + expectedPrefix + "\" is not a prefix of + actualClassName = \"" + actualClassName + "\"!";
		assertTrue(failureMessage, actualClassName.startsWith(expectedPrefix));
	}
	
	@Points(value=0)
	@Test
	public void correctClassNameSuffix()
	{
		TEST_GOAL_MESSAGE = "Check whether class name has the correct suffix";
		String expectedSuffix = SEPARATOR + LAST_NAME;
		String actualClassName = getClassNameWithoutPackage(VigenereCipher_Jowad.class);
		String failureMessage = "expectedSuffix = \"" + expectedSuffix + "\" is not a suffix of + actualClassName = \"" + actualClassName + "\"!";
		assertTrue(failureMessage, actualClassName.endsWith(expectedSuffix));
	}
	
	@Points(value=5)
	@Test
	public void validLastNameStructureTest()
	{
		TEST_GOAL_MESSAGE = "Check whether class ends with a last name with valid structure";
		String lastName = getStudentLastName();
		
		assertTrue("lastName is null!", lastName != null);
		assertTrue("lastName is the empty string!", lastName.length() > 0);
		assertTrue("First char of lastName is not uppercase!", Character.isUpperCase(lastName.charAt(0)));
		for(int i = 1; i < lastName.length(); i++)
		{
			char char_i = lastName.charAt(i);
			assertTrue("char i = " + char_i + " is not lowercase!", Character.isLowerCase(char_i));
		}
	}
	
	@Points(value=5)
	@Test
	public void lastNameTest()
	{
		TEST_GOAL_MESSAGE = "Check whether class ends with a last name with valid structure";
		String expectedLastName = getStudentLastName();
		assertTrue("expectedLastName is null", expectedLastName != null);
		assertTrue("expectedLastName cannot be \"" + SKELETON + "\"", !SKELETON.equals(expectedLastName));
		
		String actualClassName = getClassNameWithoutPackage(VigenereCipher_Jowad.class);
		
		int indexOfSeparator = actualClassName.indexOf(SEPARATOR);
		
		String actualLastName = actualClassName.substring(indexOfSeparator + 1);
		
		String failureMessage = "actualLastName = \"" + actualLastName + "\"" + " <> " + expectedLastName + " = expectedLastName!";
		assertTrue(failureMessage, expectedLastName.equals(actualLastName));
	}
	
	@Points(value=0)
	@Test
	public void specificationVersionTest()
	{
		int actualJavaVersionBeingUsed = getJavaSpecificationVersion();
		String failureMessage = "You are using Java version " + actualJavaVersionBeingUsed + " but you need to use Java version " + REQUIRED_JAVA_VERSION + " for this assignment! Check Eclipse > Project Properties > Java Build Path";
				
		assertTrue(failureMessage, actualJavaVersionBeingUsed >= REQUIRED_JAVA_VERSION);
	}
	
	@Points(value=5)
	@Test
	public void correctPackageTest()
	{
		TEST_GOAL_MESSAGE = "Check whether interface is in the correct package";
		String expectedPackageName = PACKAGE_NAME;
		String actualPackageName = VigenereCipher_Jowad.class.getPackageName();
		String failureMessage = "expectedPackageName = \"" + expectedPackageName + "\" <> \"" + actualPackageName + "\" = actualPackageName!";
		assertTrue(failureMessage, expectedPackageName.equals(actualPackageName));
	}
	
	@Points(value=0)
	@Test(expected=AssertionError.class)
	public void assertionsEnabledTest()
	{
		TEST_GOAL_MESSAGE = "Check whether assertions are enabled";
		assert false;
		throw new RuntimeException("ENABLE ASSERTIONS IN RUN CONFIGURATIONS!");
	}
	
	//********************** SUPPORT *******************************************************************************************
	@Retention(value=RUNTIME)
	@Target(value=METHOD)
	public @interface Points
	{
		int value();
	}
	
	protected String getStudentLastName()
	{
		return LAST_NAME;
	}
	
	private static int getJavaSpecificationVersion()
	{
		String fullJavaSpecificationVersion = System.getProperty("java.specification.version");
		//EX: Java 8 or lower: "1.6.0_23", "1.7.0", "1.7.0_80", "1.8.0_211"
		//EX: Java 9 or higher: "9.0.1", "11.0.4", "12", "12.0.1"
		
		final String PREFIX_USED_BEFORE_VERSION_9 = "1.";

		boolean isJavaSpecificationVersionBeforeVersion9 = fullJavaSpecificationVersion.startsWith(PREFIX_USED_BEFORE_VERSION_9);
		int indexOfFirstDot = fullJavaSpecificationVersion.indexOf('.');
		String majorVersionString = null;
		if(isJavaSpecificationVersionBeforeVersion9)
		{
			assert fullJavaSpecificationVersion.length() > 2 : "fullJavaSpecificationVersion.length() = " + fullJavaSpecificationVersion.length() + " <= 2! Must not fully understand the possible formats of the Java specification string! fullJavaSpecificationVersion = " + fullJavaSpecificationVersion;
			assert indexOfFirstDot == 1 : "indexOfFirstDot = " + indexOfFirstDot + " <> 1! Must not fully understand the possible formats of the Java specification string!";
			//EX: fullJavaSpecificationVersion = "1.6.0_23"
			//EX: indexOfFirstDot = 1
			String postFirstDotSuffix = fullJavaSpecificationVersion.substring(indexOfFirstDot + 1);
			//EX: postFirstDotSuffix = "6.0_23"
			boolean postFirstDotSuffixContainsADot = (postFirstDotSuffix.indexOf('.') != -1);
			//EX: postFirstDotSuffixContainsADot = true
			if(postFirstDotSuffixContainsADot)
			{
				int indexOfSecondDot = postFirstDotSuffix.indexOf('.') + indexOfFirstDot + 1;
				//EX: indexOfSecondDot = 1 + 1 + 1 = 3
				assert indexOfSecondDot != -1 : "indexOfSecondDot is -1!";
				majorVersionString = fullJavaSpecificationVersion.substring(indexOfFirstDot + 1, indexOfSecondDot);
				//EX: majorVersionString = "6"
			}
			else
			{
				majorVersionString = postFirstDotSuffix;
			}
		}
		else
		{
			boolean fullJavaSpecificationVersionContainsADot = (indexOfFirstDot != -1);
			if(fullJavaSpecificationVersionContainsADot)
			{
				//EX: fullJavaSpecificationVersion = "11.0.4"
				//EX: indexOfFirstDot = 1
				String preFirstDotPrefix = fullJavaSpecificationVersion.substring(0, indexOfFirstDot);
				//EX: preFirstDotPrefix = "11"
				majorVersionString = preFirstDotPrefix;
				//EX: majorVersionString = "6"
			}
			else
			{
				majorVersionString = fullJavaSpecificationVersion;
			}
		}
		
		assert majorVersionString != null : "majorVersionString is null!";
		assert majorVersionString.length() > 0 : "majorVersionString is the empty string!";
		
		int majorVersion = Integer.parseInt(majorVersionString);
		return majorVersion;
	}
	
	protected static String getClassNameWithoutPackage(Class<?> clazz)
	{
		String classNameWithPackage = clazz.getName();
		int indexOfPeriod = classNameWithPackage.indexOf('.');
		String classNameWithoutPackage = classNameWithPackage.substring(indexOfPeriod + 1);
		return classNameWithoutPackage;
	}
}
