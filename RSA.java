import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public static void main(String[] args) {
        Random rand = new Random();
        BigInteger p = BigInteger.probablePrime(8, rand);
        BigInteger q = BigInteger.probablePrime(8, rand);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(3);
        while (e.gcd(phi).compareTo(BigInteger.ONE) != 0) {
            e = e.add(BigInteger.TWO);
        }
        BigInteger d = e.modInverse(phi);

        String plaintext = "hello";
        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            BigInteger m = BigInteger.valueOf((int) c - 97);
            BigInteger ciph = m.modPow(e, n);
            ciphertext.append(ciph.toString()).append(" ");
        }

        System.out.println("Ciphertext: " + ciphertext);

        String[] cipherNumbers = ciphertext.toString().split(" ");
        StringBuilder decryptedText = new StringBuilder();

        for (String num : cipherNumbers) {
            BigInteger ciph = new BigInteger(num);
            BigInteger m = ciph.modPow(d, n);
            decryptedText.append((char) (m.intValue() + 97));
        }

        System.out.println("Decrypted Text: " + decryptedText);
    }
}
