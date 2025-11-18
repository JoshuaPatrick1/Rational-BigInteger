import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }

        // Normalize sign
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }

        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator)
                .add(denominator.multiply(secondRational.numerator));
        BigInteger d = denominator.multiply(secondRational.denominator);
        return new Rational(n, d);
    }

    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator)
                .subtract(denominator.multiply(secondRational.numerator));
        BigInteger d = denominator.multiply(secondRational.denominator);
        return new Rational(n, d);
    }

    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.numerator);
        BigInteger d = denominator.multiply(secondRational.denominator);
        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator);
        BigInteger d = denominator.multiply(secondRational.numerator);
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        else
            return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(Rational o) {
        BigInteger left = numerator.multiply(o.denominator);
        BigInteger right = denominator.multiply(o.numerator);
        return left.compareTo(right);
    }

    // Implement abstract methods from Number
    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }

    @Override
    public float floatValue() {
        return numerator.divide(denominator).floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.divide(denominator).doubleValue();
    }
}
