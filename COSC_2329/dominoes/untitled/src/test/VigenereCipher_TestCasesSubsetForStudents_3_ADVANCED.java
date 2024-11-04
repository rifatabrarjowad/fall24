package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import encryption.VigenereCipher_Jowad;

public class VigenereCipher_TestCasesSubsetForStudents_3_ADVANCED extends VigenereCipher_TestCasesSubsetForStudents_2_BASIC
{
	@Points(value=4)
	@Test(timeout=3000)
	public void crytoisshortDecryptionTest_CaseInsensitive()
	{
		String key = "abcd";
		String plainTextMessage = "crypto is short for cryptography";
		String[] encryptedMessage = new String[]{"CSASTP","KV","SIQUT","GQU","CSASTPIUAQJB"};
		TEST_GOAL_MESSAGE = "Check that decrypt(\"" + Arrays.toString(encryptedMessage) + "\", " + "\"" + key + "\").toUpperCase() = \"" + plainTextMessage.toUpperCase() + "\"";
		
		String actual = VigenereCipher_Jowad.decrypt(encryptedMessage, key);
		String testFailureMessage = "Expected.toUpperCase() + \"" + plainTextMessage.toUpperCase()  + " <> " + "\" actual.toUpperCase() = \"" + actual.toUpperCase() + "\"";
		assertEquals(testFailureMessage, plainTextMessage.toUpperCase(), actual.toUpperCase());
	}
}
