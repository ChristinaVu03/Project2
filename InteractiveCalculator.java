
/*Author: Christina Vu
 * InteractiveCalculator class computes the result, and print out the result for the user.
 */
import java.util.Scanner;

public class InteractiveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BFCalculator calculator = new BFCalculator();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equals("QUIT")) {
                break;
            }

            if (!input.isEmpty()) {
                if (input.startsWith("STORE")) {
                    char register = input.charAt(6); // Assumes input format "STORE X"
                    calculator.store(register);
                } else {
                    BigFraction result = calculator.evaluate(input);
                    System.out.println(result);
                }
            }
        }

        scanner.close();
    }
}
