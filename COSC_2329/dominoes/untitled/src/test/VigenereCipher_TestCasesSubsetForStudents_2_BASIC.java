package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import encryption.VigenereCipher_Jowad;

public class VigenereCipher_TestCasesSubsetForStudents_2_BASIC extends VigenereCipher_TestCasesSubsetForStudents_1_ENVIRONMENT
{
	public static final String PACKAGE_NAME = "encryption";
	public static final String PREFIX = "VigenereCipher";
	
	public final static String SUBGOAL = "Subgoal";
	
	protected static String TEST_GOAL_MESSAGE;
	
	@Points(value=5)
	@Test(timeout=3000)
	public void matrixEntryTest()
	{
		TEST_GOAL_MESSAGE = "Check that a specific subset of Big Matrix is correct";
		runMatrixEntryTest('A', 'a', 'a');
		runMatrixEntryTest('B', 'a', 'b');
		runMatrixEntryTest('C', 'a', 'c');
		runMatrixEntryTest('D', 'a', 'd');
		runMatrixEntryTest('E', 'a', 'e');
		runMatrixEntryTest('F', 'a', 'f');
		runMatrixEntryTest('G', 'a', 'g');
	}
	
	@Points(value=4)
	@Test(timeout=3000)
	public void KeyIsA_EncryptionTest_CaseInsensitive()
	{
		String key = "a";
		String plainText = "thiswillmatch";
		String encryptedMessage = "THISWILLMATCH";
		TEST_GOAL_MESSAGE = "Check that encrypt(\"" + plainText + "\", " + "\"" + key + "\").toLowerCase() = \"" + encryptedMessage.toLowerCase() + "\"";

		String actual = VigenereCipher_Jowad.encrypt(plainText, key);
		String testFailureMessage = "Expected.toLowerCase() = \"" + encryptedMessage.toLowerCase()  + " <> " + "\" actual.toLowerCase() = \"" + actual.toLowerCase() + "\"";
		assertEquals(testFailureMessage, encryptedMessage.toLowerCase(), actual.toLowerCase());
	}
	
	@Points(value=1)
	@Test(timeout=3000)
	public void keyIsQEncryptionTest()
	{
		String key = "q";
		String plainText = "abcdefghijklmnopqrstuvwxyz";
		String encryptedMessage = "QRSTUVWXYZABCDEFGHIJKLMNOP";
		TEST_GOAL_MESSAGE = "Check that encrypt(\"" + plainText + "\", " + "\"" + key + "\") = \"" + encryptedMessage + "\"";

		String actual = VigenereCipher_Jowad.encrypt(plainText, key);
		String testFailureMessage = "Expected = \"" + encryptedMessage + "\" Actual = \"" + actual + "\"";
		assertEquals(testFailureMessage, encryptedMessage, actual);
	}
	
	@Points(value=1)
	@Test(timeout=3000)
	public void alphabetEncryptionTest()
	{
		String key = "abcdefghijklmnopqrstuvwxyz";
		String plainText = key;
		String encryptedMessage = "ACEGIKMOQSUWYACEGIKMOQSUWY";
		TEST_GOAL_MESSAGE = "Check that encrypt(\"" + plainText + "\", " + "\"" + key + "\") = \"" + encryptedMessage + "\"";
		
		String actual = VigenereCipher_Jowad.encrypt(plainText, key);
		String testFailureMessage = "Expected = \"" + encryptedMessage + "\" Actual = \"" + actual + "\"";
		assertEquals(testFailureMessage, encryptedMessage, actual);
	}
	
	@Points(value=1)
	@Test(timeout=3000)
	public void wormEncryptionTest()
	{
		String key = "front";
		String plainText = "worm";
		String encryptedMessage = "BFFZ";
		TEST_GOAL_MESSAGE = "Check that encrypt(\"" + plainText + "\", " + "\"" + key + "\") = \"" + encryptedMessage + "\"";

		String actual = VigenereCipher_Jowad.encrypt(plainText, key);
		String testFailureMessage = "Expected = \"" + encryptedMessage + "\" Actual = \"" + actual + "\"";
		assertEquals(testFailureMessage, encryptedMessage, actual);
	}
	
	@Points(value=1)
	@Test(timeout=3000)
	public void wormDecryptionTest()
	{
		String key = "front";
		String plainText = "worm";
		String encryptedMessage = "BFFZ";
		TEST_GOAL_MESSAGE = "Check that decrypt(\"" + encryptedMessage + "\", " + "\"" + key + "\") = \"" + plainText + "\"";

		String actual = VigenereCipher_Jowad.decrypt(encryptedMessage, key);
		String testFailureMessage = "Expected = \"" + plainText + "\" Actual = \"" + actual + "\"";
		assertEquals(testFailureMessage, plainText, actual);
	}
	
	//********************** SUPPORT *******************************************************************************************	
	private static void runMatrixEntryTest(char matrixEntry, char row, char column)
	{
		final String INBOUND_TEST_GOAL_MESSAGE = TEST_GOAL_MESSAGE;
		TEST_GOAL_MESSAGE = TEST_GOAL_MESSAGE + "\n" + 
						SUBGOAL + ": " + "Check that getMatrixEntry(" + row + ", " + column + ") = " + matrixEntry;
		char expected = matrixEntry;
		char actual = VigenereCipher_Jowad.getMatrixEntry(row, column);
		String testFailureMessage = "Expected = '" + expected + "' Actual = '" + actual + "'";
		assertEquals(testFailureMessage, expected, actual);
		TEST_GOAL_MESSAGE = INBOUND_TEST_GOAL_MESSAGE;
	}
}
