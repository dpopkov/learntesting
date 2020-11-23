package learn.junitia.ch01start;

public class CalculatorTestSimple {
    private int nbErrors = 0;

    public void testAdd() {
        Calculator calc = new Calculator();
        double result = calc.add(10, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }

    public static void main(String[] args) {
        CalculatorTestSimple test = new CalculatorTestSimple();
        try {
            test.testAdd();
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors + " error(s)");
        }
    }
}
