/**
 * Terminal program that uses recursion to impliment math functions and a menu
 * Math functions include power, decrease, and summation
 * @author    David Pavlicek
 */
import java.util.*;

public class AllRecursive {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        int menuSelect = 10;

        System.out.println("\n\n1.Power\n2.Decrease\n3.Summation\n0.Exit");
        Scanner input = new Scanner(System.in); // Create Scanner object
        System.out.print("Enter Number:");
        String userSelect = input.nextLine();

        try {
            menuSelect = Integer.parseInt(userSelect);
        } catch (Exception NumberFormatException) {
            System.out.println("Incorrect input format. Please enter a number 0-3.");
            menu();
        }

        if (menuSelect < 0 || menuSelect > 3) {
            System.out.println("Number out of range. Please enter a number 0-3");
            menu();
        }

        if (menuSelect == 1) {
            int base = 0;
            int power = 0;

            try {
                System.out.println("\nEnter numbers 0-12");
                System.out.print("Base:");
                base = input.nextInt();
                System.out.print("Power:");
                power = input.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Incorrect input format. Please enter a number.");
                menu();
            }

            if (base < 0 || base > 12 || power < 0 || power > 12)
                System.out.println("\nNumber out of range 0-12");
            else
                System.out.println(power(base, power));

            menu();
        }

        if (menuSelect == 2) {
            int number = 0;

            try {
                System.out.println("\nEnter a number 0-12");
                System.out.print("Number:");
                number = input.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Incorrect input format. Please enter a number.");
                menu();
            }

            if (number < 0 || number > 12)
                System.out.println("\nNumber out of range 0-12");
            else
                decrease(number);

            menu();
        }

        if (menuSelect == 3) {
            int number = 0;

            try {
                System.out.println("\nEnter a number 0-12");
                System.out.print("Number:");
                number = input.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Incorrect input format. Please enter a number.");
                menu();
            }

            if (number < 0 || number > 12)
                System.out.println("\nNumber out of range 0-12");
            else
                System.out.println(summation(number));

            menu();
        }

        if (menuSelect == 0) {
            System.out.println("Thank you!");
        }
    }

    public static long power(int a, int b) {
        if (0 <= b) {
            if (b != 0)
                return (a * power(a, b - 1));
            else
                return 1;
        }
        return 1;
    }

    public static void decrease(int n) {
        if (0 <= n) {
            System.out.println(n);
            decrease(n - 1);
        }
    }

    public static int summation(int n) {
        if (0 <= n) {
            if (n == 1)
                return 1;
            else if (n == 0)
                return 0;
            else
                return n + summation(n - 1);
        }
        return 0;
    }
}