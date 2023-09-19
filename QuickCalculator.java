/*
 * Author: Christina Vu
 * QuickCalculator takes the expressions from the command line and then print out the results.
 */
public class QuickCalculator {
    public static void main(String[] args) {
        BFCalculator calculator = new BFCalculator();

        for (String arg : args) {
            if (arg.startsWith("STORE")) {
                char register = arg.charAt(6); // Assumes input format "STORE X"
                calculator.store(register);
            } else {
                BigFraction result = calculator.evaluate(arg);
                System.out.println(arg + " = " + result);
            }
        }
    }
}
