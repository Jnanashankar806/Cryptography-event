import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase();
        System.out.print("Enter key: ");
        String key = scanner.nextLine().toUpperCase();

        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            if (Character.isLetter(plainChar)) {
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char encryptedChar = (char) (((plainChar - 'A' + shift) % 26) + 'A');
                ciphertext.append(encryptedChar);
                keyIndex++;
            } else {
                ciphertext.append(plainChar);
            }
        }
        System.out.println("Ciphertext: " + ciphertext);

        StringBuilder decryptedText = new StringBuilder();
        keyIndex = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            if (Character.isLetter(cipherChar)) {
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char decryptedChar = (char) (((cipherChar - 'A' - shift + 26) % 26) + 'A');
                decryptedText.append(decryptedChar);
                keyIndex++;
            } else {
                decryptedText.append(cipherChar);
            }
        }
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
