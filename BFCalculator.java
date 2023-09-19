/*Author: Christina Vu
 * BFCalculator class that has 2 non-static methods evaluate, which evaluates an expression, ignoring priority, and store, which stores that last value computed in the name register.
 */
public class BFCalculator {
    public BigFraction currentResult;
    public BigFraction[] registers;
    public char lastRegister;

    public BFCalculator() {
        currentResult = new BigFraction(0, 1);
        registers = new BigFraction[26]; // 26 registers (A-Z)
    }

    public BigFraction evaluate(String exp) {
        String[] inputs = exp.split(" ");
        for (String input : inputs) {
            if (isNumeric(input)) {
                currentResult = currentResult.add(parseFraction(input));
            } else if (isRegister(input)) {
                char register = input.charAt(0);
                if (registers[register - 'a'] != null) {
                    currentResult = currentResult.add(registers[register - 'a']);
                }
            }
        }
        return currentResult;
    }

    public void store(char register) {
        registers[register - 'a'] = currentResult;
        // evaluate(register[register - 'a']);
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+/\\d+");
    }

    public BigFraction parseFraction(String str) {
        return new BigFraction(str);
    }

    public boolean isRegister(String str) {
        return str.matches("[a-z]");
    }
}
