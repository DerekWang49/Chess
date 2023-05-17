public class sumDigits {

    public static void main(String[] args)  {
        System.out.println(sumDigits(298345));
    }
    public static int sumDigits (int n) {
        if (n == 0) {
            return 0;
        }
        else {
            return n % 10 + sumDigits(n / 10);
        }

    }
}
7 + 98