import java.util.Scanner;

public class ExtendedEuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();

        int t1 = 0, t2 = 1, t3, q, r, r1 = a, r2 = n;

        while (r2 != 0) {
            q = r1 / r2;
            r = r1 % r2;
            t3 = t1 - q * t2;
            t1 = t2;
            t2 = t3;
            r1 = r2;
            r2 = r;
        }

        if (r1 == 1) {
            if (t1 < 0) t1 += n;
            System.out.println(t1);
        } else {
            System.out.println("No modular inverse exists.");
        }
    }
}
