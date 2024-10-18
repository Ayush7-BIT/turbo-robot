package Algorithms.Bit_Manipulation.Binary_Number_With_Alternating_Bits;

// Leetcode 693 - Binary Number with Alternating Bits

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        int temp = n & 1;
        while(n > 0){
            n >>= 1;
            int a = n & 1;
            if((a ^ temp) == 0){
                System.out.println(false);
                c++;
                break;
            }
            temp = a;
        }
        if(c == 0){
            System.out.println(true);
        }

    }
}