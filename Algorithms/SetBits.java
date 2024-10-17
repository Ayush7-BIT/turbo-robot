import java.util.Scanner;

public class SetBits {
    // Brute Approach
    public static int countSetBrute(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 1)
                count++;
            n = n / 2;
        }
        if (n == 1)
            count++;
        return count;
    }

    // Better Approach
    public static int countSetBetter1(int n) {
        int count = 0;
        while (n > 1) {
            count += n & 1;
            n = n >> 1;
        }
        if (n == 1)
            count++;
        return count;
    }

    // Optimal Approach
    public static int countSetBetter2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        int c = countSetBetter2(n);
        System.out.println("Number of set bits : " + c);
    }
}
