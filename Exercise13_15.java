import java.math.BigInteger;
import java.util.Scanner;

public class Exercise13_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for two rational numbers
        System.out.print("Enter the first rational number (numerator/denominator): ");
        String[] r1Parts = input.nextLine().split("/");
        BigInteger n1 = new BigInteger(r1Parts[0]);
        BigInteger d1 = new BigInteger(r1Parts[1]);

        System.out.print("Enter the second rational number (numerator/denominator): ");
        String[] r2Parts = input.nextLine().split("/");
        BigInteger n2 = new BigInteger(r2Parts[0]);
        BigInteger d2 = new BigInteger(r2Parts[1]);

        Rational r1 = new Rational(n1, d1);
        Rational r2 = new Rational(n2, d2);

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));

        System.out.println(r1 + " is " + (r1.compareTo(r2) == 0 ? "equal to " : 
                          (r1.compareTo(r2) > 0 ? "greater than " : "less than ")) + r2);
    }
}
