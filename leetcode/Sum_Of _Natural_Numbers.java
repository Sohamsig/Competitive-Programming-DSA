//using recursion

import java.util.Scanner;

class NaturalSum {

    public static int findSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + findSum(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        
        int n = sc.nextInt();

        int sum = findSum(n);

        System.out.println("Sum = " + sum);

        sc.close();
    }
}
