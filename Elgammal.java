import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class ElGamal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        BigInteger p = BigInteger.probablePrime(8, rand);
        BigInteger g = new BigInteger("2");
        BigInteger d = new BigInteger(p.bitLength(), rand);
        BigInteger e1 = g.modPow(d, p);
        BigInteger e2;

        System.out.println("Enter plaintext (lowercase letters only):");
        String plaintext = sc.nextLine();

        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            BigInteger m = BigInteger.valueOf((int) c - 97);
            BigInteger k = new BigInteger(p.bitLength(), rand);
            BigInteger c1 = g.modPow(k, p);
            e2 = e1.modPow(k, p).multiply(m).mod(p);
            ciphertext.append(c1.toString() + " " + e2.toString() + " ");
        }

        System.out.println("Ciphertext: " + ciphertext);

        StringBuilder decryptedText = new StringBuilder();
        String[] cipherPairs = ciphertext.toString().split(" ");
        for (int i = 0; i < cipherPairs.length; i += 2) {
            BigInteger c1 = new BigInteger(cipherPairs[i]);
            BigInteger c2 = new BigInteger(cipherPairs[i + 1]);
            BigInteger m = c2.multiply(c1.modPow(d, p).modInverse(p)).mod(p);
            decryptedText.append((char) (m.intValue() + 97));
        }

        System.out.println("Decrypted Text: " + decryptedText);
    }
}
