/**
 * Project: java8-examples
 * FileName: OopAnotherExample
 * Date: 2015-09-30
 * Time: 오후 1:13
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class OopAndFpAnotherExamples {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService(new Addition(), new Subtraction());
        final int additionResult = calculatorService.calculate(11, 4);
        System.out.println(additionResult);

        final int subtractionResult = calculatorService.calculate(11, 1);
        System.out.println(subtractionResult);

        final int multiplicactionResult = calculatorService.calculate(11, 2);
        System.out.println(multiplicactionResult);

        final int divisionResult = calculatorService.calculate(20, 4);
        System.out.println(divisionResult);

        final FpCalculatorService fpCalculatorService = new FpCalculatorService();
        final Calculation addition = (i1, i2) -> i1 + i2;
        System.out.println("      addition: " + fpCalculatorService.calculate(addition, 11, 4));
        System.out.println("   Subtraction: " + fpCalculatorService.calculate((i1, i2) -> i1 - i2, 11, 2));
        System.out.println("Multiplication: " + fpCalculatorService.calculate((i1, i2) -> i1 * i2, 11, 2));
        System.out.println("      Division: " + fpCalculatorService.calculate((i1, i2) -> i1 / i2, 20, 4));
        System.out.println("   custom calc: " + fpCalculatorService.calculate((i1, i2) -> ((i1 + i2) * 2) / i2, 20, 4));
    }
}

interface Calculation {
    int calculate(final int num1, final int num2);
}

class Addition implements Calculation {

    @Override
    public int calculate(final int num1, final int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculation {

    @Override
    public int calculate(final int num1, final int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {

    @Override
    public int calculate(final int num1, final int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {

    @Override
    public int calculate(final int num1, final int num2) {
        return num1 / num2;
    }
}

class CalculatorService {
    private final Calculation calculation;
    private final Calculation calculation2;

    public CalculatorService(Calculation calculation, Calculation calculation2) {
        this.calculation = calculation;
        this.calculation2 = calculation2;
    }

    public int calculate(int num1, int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }

    public int compute(int num1, int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation2.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }
}

class FpCalculatorService {
    public int calculate(Calculation calculation, int num1, int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }
}

