import java.util.Scanner;

public class AffineCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plainText = scanner.nextLine();

        System.out.print("Enter value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter value of b: ");
        int b = scanner.nextInt();

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int x = c - base;
                char encryptedChar = (char) ((a * x + b) % 26 + base);
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(c);
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        int aInverse = 0;
        for (int x = 1; x < 26; x++) {
            if ((a * x) % 26 == 1) {
                aInverse = x;
                break;
            }
        }

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int y = c - base;
                char decryptedChar = (char) ((aInverse * (y - b + 26)) % 26 + base);
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(c);
            }
        }

        System.out.println("Plain Text: " + plainText);
        System.out.println("Cipher Text: " + cipherText.toString());
        System.out.println("Decrypted Text: " + decryptedText.toString());
    }
}
