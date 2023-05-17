public class large_int {
    public static void main(String[] args) {
        int x, y, z;
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        z = Integer.parseInt(args[2]);
        if (x > y && x > z)
            System.out.print(x);
        else
            if (y > x && y > z)
                System.out.print(y);
            else
                System.out.print(z);

    }
}
