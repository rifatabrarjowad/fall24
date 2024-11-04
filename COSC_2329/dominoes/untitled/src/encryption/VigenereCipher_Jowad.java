package encryption;

import java.util.Arrays;
import java.util.List;

public interface VigenereCipher_Jowad {
    public final static List<Character> ENGLISH_LOWERCASE_LETTERS_LIST = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    );

    public final static List<Character> ENGLISH_UPPERCASE_LETTERS_LIST = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    );

    public static String encrypt(String[] plainMessage, String key) {
        if (plainMessage == null || key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Message and key cannot be null, and key must not be empty.");
        }

        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (String word : plainMessage) {
            if (word == null) throw new IllegalArgumentException("Each word in plainMessage must be non-null.");
            for (char c : word.toCharArray()) {
                if (!ENGLISH_LOWERCASE_LETTERS_LIST.contains(c)) throw new IllegalArgumentException("Plaintext must contain only lowercase letters.");
                char keyChar = key.charAt(keyIndex % key.length());
                encryptedText.append(getMatrixEntry(c, keyChar));
                keyIndex++;
            }
            encryptedText.append(" ");
        }
        return encryptedText.toString().trim();
    }

    public static String encrypt(String plainText, String key) {
        if (plainText == null || key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Plaintext and key cannot be null, and key must not be empty.");
        }

        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (char c : plainText.toCharArray()) {
            if (!ENGLISH_LOWERCASE_LETTERS_LIST.contains(c)) throw new IllegalArgumentException("Plaintext must contain only lowercase letters.");
            char keyChar = key.charAt(keyIndex % key.length());
            encryptedText.append(getMatrixEntry(c, keyChar));
            keyIndex++;
        }
        return encryptedText.toString();
    }


    public static String decrypt(String[] encryptedMessage, String key) {
        if (encryptedMessage == null || key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Encrypted message and key cannot be null, and key must not be empty.");
        }

        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (String word : encryptedMessage) {
            if (word == null) throw new IllegalArgumentException("Each word in encryptedMessage must be non-null.");
            for (char c : word.toCharArray()) {
                if (!ENGLISH_UPPERCASE_LETTERS_LIST.contains(c)) throw new IllegalArgumentException("Encrypted message must contain only uppercase letters.");
                char keyChar = key.charAt(keyIndex % key.length());
                decryptedText.append(getColumn(keyChar, c));
                keyIndex++;
            }
            decryptedText.append(" ");
        }
        return decryptedText.toString().trim();
    }

    public static String decrypt(String encryptedText, String key) {
        if (encryptedText == null || key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Encrypted text and key cannot be null, and key must not be empty.");
        }

        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (char c : encryptedText.toCharArray()) {
            if (!ENGLISH_UPPERCASE_LETTERS_LIST.contains(c)) throw new IllegalArgumentException("Encrypted text must contain only uppercase letters.");
            char keyChar = key.charAt(keyIndex % key.length());
            decryptedText.append(getColumn(keyChar, c));
            keyIndex++;
        }
        return decryptedText.toString();
    }

    public static char getMatrixEntry(char row, char column) {
        int rowIndex = ENGLISH_LOWERCASE_LETTERS_LIST.indexOf(row);
        int columnIndex = ENGLISH_LOWERCASE_LETTERS_LIST.indexOf(column);

        return ENGLISH_UPPERCASE_LETTERS_LIST.get((rowIndex + columnIndex) % 26);
    }

    public static char getColumn(char row, char matrixEntry) {
        int rowIndex = ENGLISH_LOWERCASE_LETTERS_LIST.indexOf(row);
        int matrixIndex = ENGLISH_UPPERCASE_LETTERS_LIST.indexOf(matrixEntry);

        return ENGLISH_LOWERCASE_LETTERS_LIST.get((matrixIndex - rowIndex + 26) % 26);
    }
}
