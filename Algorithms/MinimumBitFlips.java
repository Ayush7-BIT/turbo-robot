import java.util.Scanner;

public class MinimumBitFlips {
    public static int countSet(int n) {
        int count = 0;
        while (n > 1) {
            count += n & 1;
            n >>= 1;
        }
        if (n == 1)
            count++;
        return count;
    }

    public static int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int count = countSet(ans);
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting number : ");
        int a = sc.nextInt();
        System.out.println("Enter the goal : ");
        int b = sc.nextInt();
        int result = minBitFlips(a, b);
        System.out.println("Minimum bit flips : "+result);
    }
    
}
