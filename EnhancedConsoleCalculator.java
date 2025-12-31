import java.util.InputMismatchException;
import java.util.Scanner;

public class EnhancedConsoleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n====== Enhanced Console Calculator ======");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = getSafeInt(sc);

            switch (choice) {
                case 1 -> basicArithmeticMenu(sc);
                case 2 -> scientificMenu(sc);
                case 3 -> conversionMenu(sc);
                case 4 -> {
                    System.out.println("Exiting calculator...");
                    running = false;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }

        sc.close();
    }

    public static int getSafeInt(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }
        }
    }

    public static double getSafeDouble(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid number! Enter again: ");
                sc.next();
            }
        }
    }

    public static void basicArithmeticMenu(Scanner sc) {
        System.out.println("\n--- Basic Arithmetic ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose: ");

        int ch = getSafeInt(sc);

        System.out.print("Enter first number: ");
        double a = getSafeDouble(sc);

        System.out.print("Enter second number: ");
        double b = getSafeDouble(sc);

        switch (ch) {
            case 1 -> System.out.println("Result = " + (a + b));
            case 2 -> System.out.println("Result = " + (a - b));
            case 3 -> System.out.println("Result = " + (a * b));
            case 4 -> {
                if (b == 0)
                    System.out.println("Error: Division by zero!");
                else
                    System.out.println("Result = " + (a / b));
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void scientificMenu(Scanner sc) {
        System.out.println("\n--- Scientific Calculations ---");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (a^b)");
        System.out.print("Choose: ");

        int ch = getSafeInt(sc);

        switch (ch) {
            case 1 -> {
                System.out.print("Enter number: ");
                double a = getSafeDouble(sc);
                if (a < 0)
                    System.out.println("Error: Cannot compute square root of negative number!");
                else
                    System.out.println("Result = " + Math.sqrt(a));
            }
            case 2 -> {
                System.out.print("Enter base (a): ");
                double a = getSafeDouble(sc);

                System.out.print("Enter exponent (b): ");
                double b = getSafeDouble(sc);

                System.out.println("Result = " + Math.pow(a, b));
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void conversionMenu(Scanner sc) {
        System.out.println("\n--- Unit Conversions ---");
        System.out.println("1. Temperature");
        System.out.println("2. Currency");
        System.out.print("Choose: ");

        int ch = getSafeInt(sc);

        switch (ch) {
            case 1 -> temperatureMenu(sc);
            case 2 -> currencyMenu(sc);
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void temperatureMenu(Scanner sc) {
        System.out.println("\n--- Temperature Conversion ---");
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Fahrenheit → Celsius");
        System.out.println("3. Celsius → Kelvin");
        System.out.println("4. Kelvin → Celsius");
        System.out.print("Choose: ");

        int ch = getSafeInt(sc);

        System.out.print("Enter temperature: ");
        double t = getSafeDouble(sc);

        switch (ch) {
            case 1 -> System.out.println("Result = " + (t * 9 / 5 + 32) + " °F");
            case 2 -> System.out.println("Result = " + ((t - 32) * 5 / 9) + " °C");
            case 3 -> System.out.println("Result = " + (t + 273.15) + " K");
            case 4 -> System.out.println("Result = " + (t - 273.15) + " °C");
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void currencyMenu(Scanner sc) {
        System.out.println("\n--- Currency Conversion ---");
        System.out.println("1. USD → EUR");
        System.out.println("2. EUR → USD");
        System.out.println("3. USD → INR");
        System.out.println("4. INR → USD");
        System.out.print("Choose: ");

        int ch = getSafeInt(sc);

        double usdToEur = 0.92;
        double eurToUsd = 1.09;
        double usdToInr = 83.0;
        double inrToUsd = 0.012;

        System.out.print("Enter amount: ");
        double amt = getSafeDouble(sc);

        switch (ch) {
            case 1 -> System.out.println("Result = €" + (amt * usdToEur));
            case 2 -> System.out.println("Result = $" + (amt * eurToUsd));
            case 3 -> System.out.println("Result = ₹" + (amt * usdToInr));
            case 4 -> System.out.println("Result = $" + (amt * inrToUsd));
            default -> System.out.println("Invalid choice!");
        }
    }
}
