import java.util.Scanner;

public class Histogram {
    private int lowerbound;
    private int upperbound;
    private Histogram[] frequency;
    public Histogram(int lowerbound, int upperbound) {
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    public boolean add(int i) {
        if (lowerbound <= i && i <= upperbound) {
            frequency = new Histogram[i];
            frequency[i - lowerbound] += 1;
            return true;
        }
        return false;
    }

    public String toString() {

    }
    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n -1) + (fibonacciRecursive(n - 2));
        }
    }

    public static int fibonacciIterative(int n) {
        int num1 = 0;
        int num2 = 1;
        int count = 2;
        while (count < n) {
            num2 = num1 + num2;
            num1 = num2 - num1;
            count++;
        }
        if (n == 0) {
            return num1;
        }
        if (n == 1) {
            return num2;
        }

        return num1 + num2;
    }

    public static int recursiveMaxDigit(int num) {
        return recursiveMaxDigitHelper(num, 0);
    }

    public static int recursiveMaxDigitHelper(int num, int maxDigit) {
        if (num / 10 == 0) {
            if (num % 10 > maxDigit) {
                maxDigit = num % 10;
            }
            return maxDigit;
        } else if (num % 10 > maxDigit) {
            maxDigit = num % 10;
        }
        return recursiveMaxDigitHelper(num / 10, maxDigit);
    }

    public static int iterativeMaxDigit(int num) {
        int maxDigit = 0;
        for (int i = 0; num > 0; i++) {
            if (num % 10 > maxDigit) {
                maxDigit = num % 10;
            }
            num = num / 10;
        }
        return maxDigit;
    }



    public static void main (String[] args) {
//        System.out.println("Enter an integer n to get the n'th Fibonacci number:");
//        Scanner myScanner = new Scanner(System.in);
//        int n = myScanner.nextInt();
//        System.out.println("The " + n + "th Fibonacci number using fibonacciIterative is "
//        + fibonacciIterative(n));
//        System.out.println("The " + n + "th Fibonacci number using fibonacciRecursive is " +
//                fibonacciRecursive(n));
        System.out.println("Enter a digit: ");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        System.out.println(recursiveMaxDigit(n));
        System.out.println(iterativeMaxDigit(n));


    }

}
