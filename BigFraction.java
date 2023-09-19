
/*Author: Christina Vu
 * BigFraction class is an extended version of Fraction class, which has more functions like add,subtract,multiply,divide.
 */
import java.math.BigInteger;
import java.io.PrintWriter;

public class BigFraction {
  // Fields
  public BigInteger num;
  public BigInteger denom;

  // Constructors
  public BigFraction(BigInteger num, BigInteger denom) {
    if (denom.equals(BigInteger.ZERO)) {
      System.out.println("Denominator cannot be zero.");
    }
    this.num = num;
    this.denom = denom;
    reduce();
  }

  public BigFraction(int num, int denom) {
    this(BigInteger.valueOf(num), BigInteger.valueOf(denom));
  }

  public BigFraction(String str) {
    String[] parts = str.split("/");
    if (parts.length != 2) {
      System.out.println("Invalid fraction format: " + str);
    }
    BigInteger parsedNumerator = new BigInteger(parts[0]);
    BigInteger parsedDenominator = new BigInteger(parts[1]);
    if (parsedDenominator.compareTo(BigInteger.ZERO) <= 0) {
      System.out.println("Denominator must be positive: " + str);
    }
    this.num = parsedNumerator;
    this.denom = parsedDenominator;
    reduce();
  }

  // Methods
  public void reduce() {
    BigInteger gcd = num.gcd(denom);
    num = num.divide(gcd);
    denom = denom.divide(gcd);
  }

  public BigFraction add(BigFraction add_input) {
    BigInteger resultnum = num.multiply(add_input.denom).add(add_input.num.multiply(denom));
    BigInteger resultdenom = denom.multiply(add_input.denom);
    return new BigFraction(resultnum, resultdenom);
  }

  public BigFraction subtract(BigFraction subtract_input) {
    BigInteger resultnum = num.multiply(subtract_input.denom).subtract(subtract_input.num.multiply(denom));
    BigInteger resultdenom = denom.multiply(subtract_input.denom);
    return new BigFraction(resultnum, resultdenom);
  }

  public BigFraction multiply(BigFraction multiply_input) {
    BigInteger resultnum = num.multiply(multiply_input.num);
    BigInteger resultdenom = denom.multiply(multiply_input.denom);
    return new BigFraction(resultnum, resultdenom);
  }

  public BigFraction divide(BigFraction divide_input) {
    if (divide_input.num.equals(BigInteger.ZERO)) {
      System.out.println("Division by zero.");
    }
    BigInteger resultnum = num.multiply(divide_input.denom);
    BigInteger resultdenom = denom.multiply(divide_input.num);
    return new BigFraction(resultnum, resultdenom);
  }

  public BigInteger getNumerator() {
    return num;
  }

  public BigInteger getDenominator() {
    return denom;
  }

  public String toString() {
    if (denom.equals(BigInteger.ONE)) {
      return num.toString();
    } else {
      return num + "/" + denom;
    }
  }

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    BigFraction fraction1 = new BigFraction(1, 3);
    BigFraction fraction2 = new BigFraction(1, 5);

    pen.println("Addition: " + fraction1.add(fraction2));
    pen.println("Subtraction: " + fraction1.subtract(fraction2));
    pen.println("Multiplication: " + fraction1.multiply(fraction2));
    pen.println("Division: " + fraction1.divide(fraction2));
  }
}
