import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            for (int i = 1; i <= 3 * n; i += 3) {
                System.out.print((i + 1) + " " + i + " " + (i + 2) + " ");
            }

            System.out.println();
        }
    }
}