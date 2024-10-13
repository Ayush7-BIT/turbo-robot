import java.util.*;

public class Has {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num > 9) {

            int sum = 0;

            while (num != 0) {
                int rem = num % 10;

                sum += rem;
                num /= 10;
            }

            num = sum;
        }

        System.out.println("Single digit: " + num);

        sc.close();
    }
}
